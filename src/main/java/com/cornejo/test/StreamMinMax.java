package com.cornejo.test;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamMinMax {

    public static void main(String[] args) {
        // First we use a comparator manually
        Optional<String> o = Stream.of("Word", "Birdo", "Pig").max((s1, s2) -> s1.length() - s2.length());

        System.out.println(o); 

        // Now using Comparator.comparing
        o = Stream.of("Word", "Birdo", "Pig").max(Comparator.comparing(String::length));

        System.out.println(o);

        // Comparing integers
        Optional<Integer> oi = Stream.of(1, 2, 100, -18, -3).min((i1, i2) -> i1 - i2);

        System.out.println(oi);

        // Using Comparator.comparing
        oi = Stream.of(1, 2, 100, -18, -3).min(Comparator.comparing(Integer::valueOf));

        System.out.println(oi);
    }
}
