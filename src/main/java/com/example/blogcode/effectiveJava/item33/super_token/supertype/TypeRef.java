package com.example.blogcode.effectiveJava.item33.super_token.supertype;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class TypeRef<T> {
    private final Type type;

    protected TypeRef() {
        ParameterizedType superclass = (ParameterizedType) getClass().getGenericSuperclass();
        type = superclass.getActualTypeArguments()[0];
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof TypeRef && ((TypeRef)o).type.equals(type);
    }

    @Override
    public int hashCode() {
        return type.hashCode();
    }

    public Type getType() {
        return type;
    }
}
