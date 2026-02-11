package com.github.viniciushfc.hook_dispatcher.application.service.generic;

import com.github.viniciushfc.hook_dispatcher.application.converter.Converter;
import jakarta.annotation.PostConstruct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;


public abstract class AbstractBaseServiceImpl<ID, E, D, R extends JpaRepository<E, ID> & JpaSpecificationExecutor<E>>
        implements IBaseService<ID, D> {

    protected R repository;
    private Class<E> entityClass;
    private Class<D> dtoClass;

    @SuppressWarnings("unchecked")
    @PostConstruct
    private void init() {
        Type genericSuperclass = getClass().getGenericSuperclass();

        if (genericSuperclass instanceof ParameterizedType parameterizedType) {
            Type[] typeArguments = parameterizedType.getActualTypeArguments();

            this.entityClass = (Class<E>) typeArguments[1];
            this.dtoClass = (Class<D>) typeArguments[2];
        }
    }

    @Override
    public Page<D> findAll(Pageable pageable) {
        Page<E> page = repository.findAll(pageable);
        List<D> dtos = page.getContent().stream()
                .map(entity -> Converter.toDTO(entity, dtoClass))
                .collect(Collectors.toList());

        return new PageImpl<>(dtos, pageable, page.getTotalElements());
    }

    @Override
    public D findById(ID id) {
        E entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("No entity found with id " + id));

        return Converter.toDTO(entity, dtoClass);
    }

    @Override
    public D save(D dto) {
        E entity = Converter.toEntity(dto, entityClass);
        entity = repository.save(entity);

        return Converter.toDTO(entity, dtoClass);
    }

    @Override
    public D update(ID id, D dto) {
        findById(id);
        E entity = Converter.toEntity(dto, entityClass);
        entity = repository.save(entity);

        return Converter.toDTO(entity, dtoClass);
    }

    @Override
    public String delete(ID id) {
        findById(id);
        repository.deleteById(id);

        return "Successfully deleted dtoEntity with id " + id;
    }
}