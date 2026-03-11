package com.github.viniciushfc.hook_dispatcher.service.generic;

import com.github.viniciushfc.hook_dispatcher.domain.entity.generic.AbstractBaseEntity;
import com.github.viniciushfc.hook_dispatcher.service.generic.contract.IAbstractService;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.support.Repositories;
import org.springframework.web.context.WebApplicationContext;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractBaseServiceImpl<E extends AbstractBaseEntity, I, D> implements IAbstractService<E, I, D> {

    protected Class<E> entityClass;
    protected Class<D> dtoClass;
    protected JpaRepository<E, I> repository;

    @Autowired
    private WebApplicationContext applicationContext;

    @SuppressWarnings("unchecked")
    protected AbstractBaseServiceImpl() {
        ParameterizedType parameterizedType
                = (ParameterizedType) this.getClass().getGenericSuperclass();

        this.entityClass = (Class<E>) parameterizedType.getActualTypeArguments()[0];
        this.dtoClass = (Class<D>) parameterizedType.getActualTypeArguments()[2];
    }

    @SuppressWarnings("unchecked")
    @PostConstruct
    private void initRepository() {
        Repositories repositories = new Repositories(applicationContext);
        this.repository = (JpaRepository<E, I>) repositories.getRepositoryFor(entityClass)
                .orElseThrow(() -> new IllegalStateException("No repository found for " + entityClass.getSimpleName()));
    }

    @Override
    public List<E> findAll() {
        return repository.findAll();
    }

    @Override
    public E findById(I id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Não foi encontrado " + entityClass.getSimpleName() + " com o id: " + id));
    }

    @Override
    public void deleteById(I id) {
        findById(id);
        repository.deleteById(id);
    }
}
