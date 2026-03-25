package com.cornejo.test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Lambdas {

    public static void main(String[] args) {
        //Lambdas.Consumers();
        //Lambdas.example1();
        concurrentMap();
    }

    public static void concurrentMap() {
        Map<Integer, List<String>> cm = new ConcurrentHashMap<>();
        cm.put(1, new ArrayList<>());
        cm.put(2, new ArrayList<>());

        cm.computeIfPresent(1, (k, v) -> {v.add("item 1"); return v;});
        cm.computeIfAbsent(2, k -> {System.out.println("k - " + k);return new ArrayList<>();}).add("item 2");
        System.out.println(cm.toString());


    }

    public static void Consumers() {

        List<String> listOfStrings = new ArrayList<String>();

        Consumer<String> c = s -> System.out.println(s);

        listOfStrings = Arrays.asList("Anna", "Julia", "Roberta");

        listOfStrings.forEach(c);

        Map<String, String> mapOfStrings = new HashMap<String, String>();

        BiConsumer<String, String> bc = (key, value) -> mapOfStrings.put(key, value);

        bc.accept("Key", "value");
        bc.accept("Key2", "Value2");
        bc.accept("Key3", "Value3");

        System.out.println(mapOfStrings);
    }

    public static void example1() {
        List<String> names = Arrays.asList("Anna", "Paula", "Bertha", "Samantha", "Denise");

        List<String> upper = names.stream().map(String::toUpperCase).toList();

        Function<List<String>, List<String>> toUpperFunction = l -> l.stream().map(String::toUpperCase).toList();

        List<String> upper2 = toUpperFunction.apply(names);

        System.out.println(upper);

        System.out.println(upper2);

        // Filter odd and even numbers

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 7, 8, 9, 10, 12, 15, 19, 34, 56, 58);

        List<Integer> oddNumbers = numbers.stream().filter(n -> n % 2 == 0).toList();

        List<Integer> evenNumbers = numbers.stream().filter(n -> n % 2 != 0).toList();

        System.out.println("odd: " + oddNumbers);
        System.out.println("even: " + evenNumbers);

        // Sort alphabetically

        List<String> sortedNames = names.stream().sorted((s1, s2) -> s1.compareToIgnoreCase(s2)).toList();

        System.out.println(sortedNames);

    }

    public static void finalTest() {
        int x = 12;

        Predicate<String> p = s -> {
            //x = 11;

            return s.isEmpty() && x % 2 == 0;
        };

        //x++;

        p.test("String");

    }
}
