package com.github.viniciushfc.hook_dispatcher.application.domain.generic;

import lombok.Getter;

@Getter
public abstract class AbstractEntityDTO<ID> {
    private ID id;
}
