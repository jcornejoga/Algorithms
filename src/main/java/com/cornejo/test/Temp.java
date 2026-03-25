package com.cornejo.test;

public class Temp {

    public static String getLongestCommonPrefix(String[] words) {
        String prefix = words[0];

        for (int i = 1; i < words.length; i++) {
            while (words[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"flower", "flame", "flame"};

        System.out.println(getLongestCommonPrefix(words));
    }
}
