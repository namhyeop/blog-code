package com.example.blogcode.effectiveJava.item32.DoubleContainer;


import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DoubleContainer {

    private final Map<Class<?>, Object> doubleContainer = new HashMap<>();

    static Annotation getAnnotation(AnnotatedElement element,
        String annotationTypeName) {
        Class<?> annotationType = null;
        try {
            annotationType = Class.forName(annotationTypeName);
        } catch (Exception ex) {
            throw new IllegalArgumentException(ex);
        }
        return element.getAnnotation(
            annotationType.asSubclass(Annotation.class));
    }

    public static void main(String[] args) {
        // DoubleContainer 객체 생성
        DoubleContainer container = new DoubleContainer();

        // Integer 타입의 요소 추가
        container.putContainer(Integer.class, 10);

        // String 타입의 요소 추가
        container.putContainer(String.class, "Hello, world!");

        // 요소 꺼내기
        int intValue = container.getContainer(Integer.class);
        System.out.println("Integer value: " + intValue); // Integer value: 10

        String stringValue = container.getContainer(String.class);
        System.out.println("String value: " + stringValue); // String value: Hello, world!
    }

    public <T> void putContainer(Class<T> type, T instance) {
        doubleContainer.put(Objects.requireNonNull(type), instance);
    }

    public <T> T getContainer(Class<T> type) {
        return type.cast(doubleContainer.get(type));
    }
}
