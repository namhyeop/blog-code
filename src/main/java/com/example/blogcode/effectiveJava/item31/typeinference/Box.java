package com.example.blogcode.effectiveJava.item31.typeinference;

public class Box<T> {

    private T t;

    public T get() {
        return t;
    }

    public <E extends T> void set(E e) {
        this.t = e;
    }
}
