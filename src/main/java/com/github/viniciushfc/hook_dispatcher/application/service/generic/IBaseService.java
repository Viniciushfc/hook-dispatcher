package com.github.viniciushfc.hook_dispatcher.application.service.generic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBaseService<ID, D> {

    D save(D dto);

    Page<D> findAll(Pageable pageable);

    D findById(ID id);

    D update(ID id, D dto);

    String delete(ID id);
}
