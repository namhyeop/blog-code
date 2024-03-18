package com.example.blogcode.effectiveJava.item32.DoubleContainer;

import java.util.ArrayList;
import java.util.List;

public class GenericTypeCastProblem {

    public class NonTypeSafeContainerExample {

        public static void main(String[] args) {
            //로타입 선언
            List elements = new ArrayList();
            elements.add("String Element");
            elements.add(10); // 잘못된 타입의 요소 추가
            elements.add(new Object());

            // 요소를 꺼내어 형변환하여 사용
            for (Object element : elements) {
                if (element instanceof String strElement) {
                    System.out.println("String Element: " + strElement.toUpperCase());
                } else if (element instanceof Integer) {
                    int intElement = (int) element; // 형변환 오류 발생 가능
                    System.out.println("Integer Element: " + intElement);
                } else {
                    System.out.println(
                        "Unknown Element Type: " + element.getClass().getSimpleName());
                }
            }
        }
    }

}
