package com.github.viniciushfc.hook_dispatcher.service.generic.contract;

import com.github.viniciushfc.hook_dispatcher.domain.entity.generic.AbstractBaseEntity;

import java.util.List;

public interface IAbstractService<E extends AbstractBaseEntity, I, D> {

    List<E> findAll();

    E findById(I id);

    void deleteById(I id);
}
