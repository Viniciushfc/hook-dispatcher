package com.github.viniciushfc.hook_dispatcher.domain.enums.contract;

public interface IEnum<K, V> {

    K getKey();
    V getValue();
}
