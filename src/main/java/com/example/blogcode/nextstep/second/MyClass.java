package com.example.blogcode.nextstep.second;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MyClass {
    private String privateField = "privateValue";

    private void privateMethod() {
        System.out.println("리플렉션을 사용한 메소드 접근, privateMethod called");
    }

    public static void main(String[] args) throws Exception {
        MyClass myObject = new MyClass();

        // private 필드에 접근하기
        Field privateField = MyClass.class.getDeclaredField("privateField");
        privateField.setAccessible(true); // 접근 가능하게 설정
        String fieldValue = (String) privateField.get(myObject);
        System.out.println("리플렉션을 사용한 필드 접근, privateField : " + fieldValue);

        // private 메서드에 접근하기
        Method privateMethod = MyClass.class.getDeclaredMethod("privateMethod");
        privateMethod.setAccessible(true); // 접근 가능하게 설정
        privateMethod.invoke(myObject); // private 메서드 호출
    }
}
