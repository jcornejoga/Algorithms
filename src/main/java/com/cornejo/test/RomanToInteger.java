package com.cornejo.test;

import java.util.Map;

public class RomanToInteger {

    public static final Map<String, Integer> romanNumberIntValues =
            Map.of("I", 1, "V", 5, "X", 10, "L", 50, "C", 100, "D", 500, "M", 1000);

    public static int convertRomanToInt(String s) {
        int result = 0;
        int prev = 0;
        int current = 0;
        for (int i = 0; i < s.length(); i++) {
            current = romanNumberIntValues.get(String.valueOf(s.charAt(i)));
            if (prev != 0 && prev < current) {
                result += current - (2 * prev);
            } else {
                result += current;
            }
            prev = current;
        }


        return result;
    }

    public static void main(String[] args) {
        String romanNumber = "CCXLVIII";
        romanNumber = "CMXCVIII";
        romanNumber = "MCMXCIV";

        int integerEquivalent = convertRomanToInt(romanNumber);

        System.out.println("Roman: " + romanNumber + " integer: " + integerEquivalent);
    }
}
