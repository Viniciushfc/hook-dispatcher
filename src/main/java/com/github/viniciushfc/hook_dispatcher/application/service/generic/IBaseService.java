package com.github.viniciushfc.hook_dispatcher.application.service.generic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface IBaseService<ID, T, D> {

    T save(D dto);

    Page<T> findAll(Pageable pageable, Specification<T> spec);

    T findById(ID id);

    T update(ID id, D dto);

    String delete(ID id);
}
