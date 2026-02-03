package com.github.viniciushfc.hook_dispatcher.application.service.generic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface IBaseService<ID, E, D> {

    E save(D dto);

    Page<E> findAll(Pageable pageable, Specification<E> spec);

    E findById(ID id);

    E update(ID id, D dto);

    String delete(ID id);
}
