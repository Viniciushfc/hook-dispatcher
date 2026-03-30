package com.github.viniciushfc.hook_dispatcher.service.generic;

import com.github.viniciushfc.hook_dispatcher.domain.entity.generic.AbstractBaseEntity;
import com.github.viniciushfc.hook_dispatcher.exception.HookDispatcherException;
import com.github.viniciushfc.hook_dispatcher.service.generic.contract.IAbstractService;
import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.support.Repositories;
import org.springframework.web.context.WebApplicationContext;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractBaseServiceImpl<E extends AbstractBaseEntity, I, D> implements IAbstractService<E, I, D> {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    protected Class<E> entityClass;
    protected Class<D> dtoClass;
    protected JpaRepository<E, I> repository;

    @Autowired
    protected ModelMapper modelMapper;

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
                .orElseThrow(() -> new HookDispatcherException("No repository found for " + entityClass.getSimpleName()));
    }

    @Override
    public List<D> findAll() {
        log.info("Fetching all records of {}", entityClass.getSimpleName());
        return repository.findAll().stream()
                .map(entity -> modelMapper.map(entity, dtoClass))
                .toList();
    }

    @Override
    public D findById(I id) {
        log.info("Fetching {} by id={}", entityClass.getSimpleName(), id);
        return modelMapper.map(findEntityById(id), dtoClass);
    }

    @Override
    public void deleteById(I id) {
        log.info("Deleting {} by id={}", entityClass.getSimpleName(), id);
        findEntityById(id);
        repository.deleteById(id);
        log.info("{} deleted successfully. id={}", entityClass.getSimpleName(), id);
    }

    protected E findEntityById(I id) {
        return repository.findById(id)
                .orElseThrow(() -> {
                    log.warn("{} not found. id={}", entityClass.getSimpleName(), id);
                    return new HookDispatcherException(entityClass.getSimpleName() + " not found with id: " + id);
                });
    }
}
