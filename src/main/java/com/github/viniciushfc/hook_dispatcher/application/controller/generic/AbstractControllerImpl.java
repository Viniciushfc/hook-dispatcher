package com.github.viniciushfc.hook_dispatcher.application.controller.generic;

import com.github.viniciushfc.hook_dispatcher.application.service.generic.IBaseService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class AbstractControllerImpl<ID, D, S extends IBaseService<ID, D>>
        implements IBaseController<ID, D> {

    protected S service;

    @Override
    public ResponseEntity<D> save(D dto) {
        return new ResponseEntity<>(service.save(dto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Page<D>> findAll(Pageable pageable) {
        return new ResponseEntity<>(service.findAll(pageable), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<D> findById(ID id) {
        return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<D> update(ID id, D dto) {
        return new ResponseEntity<>(service.update(id, dto), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> delete(ID id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
