package com.cornejo.test.udemy.s1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.*;

public class Assignment2 {

    public static void main(String[] args) {
        //staticMR();
        //boundMR();
        //unbooundMR();
        constructorMR();
    }

    public static void staticMR() {
        List<Integer> integerList = Arrays.asList(1, 2, 7, 4, 5);

        Consumer<List<Integer>> sortConsumer = l -> Collections.sort(l);

        System.out.println("original list " + integerList);
        sortConsumer.accept(integerList);
        System.out.println("sorted " + integerList);

        integerList = Arrays.asList(1, 2, 7, 4, 5);

        sortConsumer = Collections::sort;

        System.out.println("original list using MR " + integerList);
        sortConsumer.accept(integerList);
        System.out.println("sorted using MR " + integerList);
    }

    public static void boundMR() {
        String text = "Mr. Joe Bloggs";
        String prefix = "Mr.";

        Predicate<String> stringPredicate = t -> text.startsWith(t);

        System.out.println("the text " + text + " starts with " + prefix + stringPredicate.test(prefix));
        prefix = "Ms.";
        System.out.println("the text " + text + " starts with " + prefix + stringPredicate.test(prefix));

        prefix = "Mr.";
        stringPredicate = text::startsWith;

        System.out.println("the text " + text + " starts with " + prefix + stringPredicate.test(prefix));
        prefix = "Ms.";
        System.out.println("the text " + text + " starts with " + prefix + stringPredicate.test(prefix));


    }

    public static void unbooundMR() {

        //a-c
        Predicate<String> isEmptyPredicate = s -> s.isEmpty();

        System.out.println("String '' is empty? " + isEmptyPredicate.test(""));
        System.out.println("String 'xyz' is empty? " + isEmptyPredicate.test("xyz"));
        //d-e
        isEmptyPredicate = String::isEmpty;

        System.out.println("String '' is empty? " + isEmptyPredicate.test(""));
        System.out.println("String 'xyz' is empty? " + isEmptyPredicate.test("xyz"));

        //f
        BiPredicate<String, String> startsWithPredicate = (s, p) -> s.startsWith(p);
        String text = "Mr. Joe Bloggs";
        String prefix = "Mr.";
        System.out.println("text " + text + " starts with " + prefix + " " + startsWithPredicate.test(text, prefix));
        prefix = "Ms.";
        System.out.println("text " + text + " starts with " + prefix + " " + startsWithPredicate.test(text, prefix));

        //g-h
        startsWithPredicate = String::startsWith;
        prefix = "Mr.";
        System.out.println("text " + text + " starts with " + prefix + " " + startsWithPredicate.test(text, prefix));
        prefix = "Ms.";
        System.out.println("text " + text + " starts with " + prefix + " " + startsWithPredicate.test(text, prefix));

    }

    public static void constructorMR() {
        //a-e
        Supplier<List<String>> listSupplier = () -> new ArrayList<String>();

        List<String> myList = listSupplier.get();
        myList.add("Lambda");
        System.out.println(myList);

        listSupplier = ArrayList::new; // Supplier T get() so java knows it needs to use the constructor with no arguments

        myList = listSupplier.get();
        myList.add("Method reference");
        System.out.println(myList);

        //f
        Function<Integer, ArrayList<String>> listFunction = size -> new ArrayList<String>(size);

        myList = listFunction.apply(10);
        myList.add("Lambda with size of 10");
        System.out.println(myList);

        listFunction = ArrayList::new; // Function R apply(T t) so java knows it should use the constructor with one argument

        myList = listFunction.apply(10);
        myList.add("Method reference with size of 10");
        System.out.println(myList);

    }
}
