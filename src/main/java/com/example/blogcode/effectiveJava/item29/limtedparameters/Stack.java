package com.example.blogcode.effectiveJava.item29.limtedparameters;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

public class Stack<E extends Number> {  //(2) Number를 상속받은 객체만 Stack의 E 타입으로 사용 가능
    private Number[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    @SuppressWarnings("unchecked")
    public Stack() {
        elements = new Number[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0)
            throw new EmptyStackException();
        @SuppressWarnings("unchecked") E result = (E)elements[--size];
        elements[size] = null; // 다 쓴 참조 해제
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void ensureCapacity() {
        if (elements.length == size)
            elements = Arrays.copyOf(elements, 2 * size + 1);
    }

    // 코드 29-5 제네릭 Stack을 사용하는 맛보기 프로그램 (174쪽)
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(); //(1) 생성한 Stack을 Integer 타입으로 설정
        for (Integer arg : List.of(1, 2, 3))
            stack.push(arg);
        while (!stack.isEmpty())
            System.out.println(stack.pop());
    }
}
