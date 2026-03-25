package com.cornejo.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CharCombinations {

    public static List<String> getCombinations(String s) {
        List<String> results = new ArrayList<>();

        for (int i=0; i<s.length(); i++) {
            String currentChar = String.valueOf(s.charAt(i));
            StringBuilder sb = new StringBuilder();
            sb.append(currentChar);
            results.add(currentChar);

            for (int j=i+1; j<s.length(); j++) {
                String nextChar = String.valueOf(s.charAt(j));
                sb.append(nextChar);
                if (!sb.toString().equals(currentChar + nextChar)) {
                    results.add(sb.toString());
                }
                results.add(currentChar + nextChar);
            }
        }
        Collections.sort(results);
        return results;
    }

    public static void main(String[] args) {
        //String s = "xyz";
        String s = "acebrd";

        System.out.println("String " + s);

        List<String> combinations = getCombinations(s);

        System.out.println("result " + combinations + " size " + combinations.size());
    }
}
