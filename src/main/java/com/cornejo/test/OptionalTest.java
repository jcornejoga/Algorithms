package com.cornejo.test;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {
        Optional<String> name = Optional.of ("Jose");

        String value = name.orElseGet(() -> {
           System.out.println("Value is null");
           return null;
        });

        System.out.println("value " + value);
    }
}
