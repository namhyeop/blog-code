package com.example.blogcode.effectiveJava.item33.super_token.example;

import com.example.blogcode.effectiveJava.item33.super_token.supertype.TypeRef;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Favorites {

    private final Map<TypeRef<?>, Object> favorites = new HashMap<>();

    public <T> void put(TypeRef<T> typeRef, T thing) {
        favorites.put(typeRef, thing);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(TypeRef<T> typeRref) {
        return (T)(favorites.get(typeRref));
    }

    public static void main(String[] args) {
        Favorites f = new Favorites();

        TypeRef<List<String>> stringTypeRef = new TypeRef<>() {};
        System.out.println(stringTypeRef.getType());

        TypeRef<List<Integer>> integerTypeRef = new TypeRef<>() {};
        System.out.println(integerTypeRef.getType());

        f.put(stringTypeRef, List.of("a", "b", "c"));
        f.put(integerTypeRef, List.of(1, 2, 3));
        f.get(stringTypeRef).forEach(System.out::println);
        f.get(integerTypeRef).forEach(System.out::println);
    }
}
