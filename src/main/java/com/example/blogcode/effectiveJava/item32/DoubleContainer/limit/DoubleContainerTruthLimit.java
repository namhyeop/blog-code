package com.example.blogcode.effectiveJava.item32.DoubleContainer.limit;

import com.example.blogcode.effectiveJava.item32.DoubleContainer.DoubleContainer;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DoubleContainerTruthLimit {

    private final Map<Class<?>, Object> doubleContainer = new HashMap<>();

    public <T> void putContainer(Class<T> type, T instance){
        doubleContainer.put(Objects.requireNonNull(type), instance);
    }

    public <T> T getContainer(Class<T> type){
        return type.cast(doubleContainer.get(type));
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
        System.out.println("Integer value: " + intValue); // 컴파일 경고 발생

        String stringValue = container.getContainer(String.class);
        System.out.println("String value: " + stringValue); // 컴파일 경고 발생
    }

}
