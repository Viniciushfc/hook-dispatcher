package com.github.viniciushfc.hook_dispatcher.application.controller.generic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public interface IBaseController<ID, D> {

    @PostMapping
    ResponseEntity<D> save(@RequestBody D dto);

    @GetMapping
    ResponseEntity<Page<D>> findAll(Pageable pageable);

    @GetMapping("/{id}")
    ResponseEntity<D> findById(@PathVariable ID id);

    @PutMapping("/{id}")
    ResponseEntity<D> update(@PathVariable ID id, @RequestBody D dto);

    @DeleteMapping("/{id}")
    ResponseEntity<String> delete(@PathVariable ID id);
}
