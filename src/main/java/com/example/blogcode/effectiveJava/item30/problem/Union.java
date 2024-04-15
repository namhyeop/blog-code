package com.example.blogcode.effectiveJava.item30.problem;

import java.util.HashSet;
import java.util.Set;

// 제네릭 union 메서드와 테스트 프로그램 (177쪽)
public class Union {

    // 코드 30-2 제네릭 메서드 (177쪽)
    public static Set union(Set s1, Set s2) {
        Set result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    /// 코드 30-3 제네릭 메서드를 활용하는 간단한 프로그램 (177쪽)
    public static void main(String[] args) {
        Set<String> guys = Set.of("톰", "딕", "해리");
        Set<Integer> stooges = Set.of(1, 2, 3); // (1) 로타입인 경우 ClassCasteException 발생!
        Set<String> all = union(guys, stooges);

        for (String o : all) {
            System.out.println(o);
        }
    }
}
