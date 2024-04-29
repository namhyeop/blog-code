package com.example.blogcode.effectiveJava.item33.super_token.weak;

import com.example.blogcode.effectiveJava.item33.super_token.example.Favorites;
import com.example.blogcode.effectiveJava.item33.super_token.supertype.TypeRef;
import java.util.ArrayList;
import java.util.List;

public class SuperTypeWeakPoint {
    static Favorites f = new Favorites();

    static <T> List<T> favoriteList() {
        TypeRef<List<T>> ref = new TypeRef<>() {};
        System.out.println(ref.getType()); //1.favoriteStringList, favoriteIntegerList 둘 다 ref.getType()이 List<T>를 반환

        List<T> result = f.get(ref); //2.favoriteIntegerList를 반환할때 List<Integer>를 기대하지만 List<T>를 반환함.
        if (result == null) {
            result = new ArrayList<T>();
            f.put(ref, result);
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> favoriteStringList = favoriteList();

        List<Integer> favoriteIntegerList = favoriteList();
        favoriteIntegerList.add(1);

        //3.favoriteStringList, favoriteIntegerList 둘 다 같은 객체를 바라보기 때문에 castType 오류 발생
        for (String s : favoriteStringList) System.out.println(s);
    }
}
