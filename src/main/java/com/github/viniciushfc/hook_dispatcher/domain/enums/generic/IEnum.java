package com.github.viniciushfc.hook_dispatcher.domain.enums.generic;

public interface IEnum<K, V> {

    K getKey();
    V getValue();
}
