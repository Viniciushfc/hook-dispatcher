package com.github.viniciushfc.hook_dispatcher.application.domain.generic;

public interface IEnum<K, V> {

    K getKey();

    V getValue();
}
