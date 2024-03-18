package com.example.blogcode.effectiveJava.item32.DoubleContainer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContainerAndDoubleContainerExample {

    public static void main(String[] args) {
        // 컨테이너 사용 예시
        Map<Integer, String> numberMap = new HashMap<>();
        numberMap.put(1, "One");
        numberMap.put(2, "Two");
        numberMap.put(3, "Three");
        System.out.println("Map: " + numberMap);
        System.out.println();

        //이중 컨테이너 예시
        Map<String, List<String>> fruitCategories = new HashMap<>();

        List<String> citrusFruits = new ArrayList<>();
        citrusFruits.add("Orange");
        citrusFruits.add("Lemon");
        citrusFruits.add("Grapefruit");

        List<String> tropicalFruits = new ArrayList<>();
        tropicalFruits.add("Pineapple");
        tropicalFruits.add("Mango");
        tropicalFruits.add("Papaya");

        fruitCategories.put("Citrus", citrusFruits);
        fruitCategories.put("Tropical", tropicalFruits);

        System.out.println("Fruit Categories: " + fruitCategories);
    }
}
