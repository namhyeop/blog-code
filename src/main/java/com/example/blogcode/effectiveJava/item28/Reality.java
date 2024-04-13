package com.example.blogcode.effectiveJava.item28;

import java.util.ArrayList;
import java.util.List;

public class Reality {
    public static void main(String[] args) {
        // 배열은 실체화되므로 런타임에 타입 검사를 할 수 있습니다.
        // Integer 배열을 생성하고 String을 추가하려고 하면 런타임 에러가 발생합니다.
        Object[] array = new Integer[5];
        array[0] = "Hello"; // 런타임 에러: ArrayStoreException

        // 제네릭은 실체화되지 않으므로 런타임에 타입 검사를 할 수 없습니다.
        // 컴파일은 되지만 런타임에 ClassCastException이 발생합니다.
        List<Integer> list = new ArrayList<>();
        List rawList = list;
        rawList.add("Hello");
        Integer number = list.get(0); // 런타임 에러: ClassCastException
    }
}
