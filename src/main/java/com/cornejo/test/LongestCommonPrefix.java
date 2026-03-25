package com.cornejo.test;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();
        boolean valid = true;

        for (int i = 0; i < strs[0].length(); i++) {
            Character current = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != current) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                prefix.append(current);
            } else {
                break;
            }
        }

        return prefix.toString();
    }

    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public static String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        //String[] strs = new String[] {"ab", "a"};
        String[] strs = new String[] {"flowered", "flow", "flowhtaaaaa"};

        System.out.println("Words " + Arrays.toString(strs));

        System.out.println("Prefix: " + longestCommonPrefix2(strs));
    }
}
