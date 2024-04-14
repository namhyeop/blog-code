package com.example.blogcode.effectiveJava.item29.soultion1;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.List;

// E[]를 이용한 제네릭 스택 (170-174쪽)
public class Stack<E> { //(1)클래스 선언 타입에 매개변수 추가
    private E[] elements; // (2) 자료형 E로 변환
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    //(3) 불필요한 경고 제거
    // 코드 29-3 배열을 사용한 코드를 제네릭으로 만드는 방법 1 (172쪽)
    // 배열 elements는 push(E)로 넘어온 E 인스턴스만 담는다.
    // 따라서 타입 안전성을 보장하지만,
    // 이 배열의 런타임 타입은 E[]가 아닌 Object[]다!
    @SuppressWarnings("unchecked")
    public Stack() {
        elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY]; //(4) 생성자 (E[])로 형변환
    }

    public void push(E e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public E pop() {
        if (size == 0)
            throw new EmptyStackException();
        E result = elements[--size];
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
        Stack<String> stack = new Stack<>();
        for (String arg : List.of("a", "b", "c"))
            stack.push(arg);
        while (!stack.isEmpty())
            System.out.println(stack.pop().toUpperCase()); // (5) 형변환 로직 제거
    }

    //Heap 오염이 가능한 코드 작성이 가능
//    public static void main(String[] args) {
//        Stack<String> stack = new Stack<>();
//        List<String> strings = Arrays.asList("one", "two", "three");
//        List<Integer> integers = Arrays.asList(1, 2, 3);
//
//        // 힙 오염을 발생시키기 위해 제네릭 배열에 서로 다른 타입의 객체를 넣습니다.
//        pushMultiple(stack, new List[]{integers});
//
//        // 형변환 오류가 발생할 수 있는 pop() 메서드를 호출합니다.
//        while (!stack.isEmpty()) {
//            System.out.println(stack.pop().toUpperCase());
//        }
//    }
//
//    // 제네릭 스택에 서로 다른 타입의 객체를 넣는 메서드
//    private static <E> void pushMultiple(Stack<E> stack, List<E>... lists) {
//        for (List<E> list : lists) {
//            for (E item : list) {
//                stack.push(item);
//            }
//        }
//    }
}
