package com.example.blogcode.effectiveJava.item32.DoubleContainer.limit;

import com.example.blogcode.effectiveJava.item32.DoubleContainer.DoubleContainer;

public class DoubleContainerLimit {

    public static void main(String[] args) {
        // DoubleContainer 객체 생성
        DoubleContainer container = new DoubleContainer();

        // Integer 타입의 요소 추가
        container.putContainer(Integer.class, 10);

        // String 타입의 요소 추가
        container.putContainer(String.class, "Hello, world!");

        // 잘못된 타입(Class)을 사용하여 요소 가져오기
        Class<String> maliciousType = (Class<String>) (Class) Integer.class; // 악의적인 클라이언트가 잘못된 타입을 전달
        String stringValue = container.getContainer(maliciousType);
        System.out.println("String value: " + stringValue); // ClassCastException 발생
    }
}
