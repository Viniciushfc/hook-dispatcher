package com.github.viniciushfc.hook_dispatcher.application.converter;

import java.lang.reflect.Field;

public abstract class Converter<E, D> {

    public static <D, E> E toEntity(D classRoot, Class<E> classDestiny) {
        try {
            E destiny = classDestiny.getDeclaredConstructor().newInstance();
            for (Field fieldClassRoot : classRoot.getClass().getDeclaredFields()) {
                fieldClassRoot.setAccessible(true);

                try {
                    Field destinyField =
                            classDestiny.getDeclaredField(fieldClassRoot.getName());
                    destinyField.setAccessible(true);

                    Object value = fieldClassRoot.get(classRoot);
                    destinyField.set(destiny, value);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

            return destiny;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static <E, D> D toDTO(E classRoot, Class<D> classDestiny) {
        try {
            D destiny = classDestiny.getDeclaredConstructor().newInstance();
            for (Field fieldClassRoot : classRoot.getClass().getDeclaredFields()) {
                fieldClassRoot.setAccessible(true);

                try {
                    Field destinyField =
                            classDestiny.getDeclaredField(fieldClassRoot.getName());
                    destinyField.setAccessible(true);

                    Object value = fieldClassRoot.get(classRoot);
                    destinyField.set(destiny, value);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

            return destiny;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
