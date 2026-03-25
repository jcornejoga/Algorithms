package com.cornejo.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int longest = 0;

        for (int i = 0; i < s.length(); i++) {
            char startChar = s.charAt(i);
            List<Character> chars = new ArrayList<>();
            chars.add(startChar);
            for (int j = i + 1; j < s.length(); j++) {
                char currChar = s.charAt(j);
                if (!chars.contains(currChar)) {
                    chars.add(currChar);
                } else {
                    break;
                }
            }
            System.out.println(chars);
            if (chars.size() > longest) {
                longest = chars.size();
            }
        }

        return longest;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int left = 0;
        int max = 0;
        Set<Character> chars = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);
            while (chars.contains(currentChar)) {
                char leftChar = s.charAt(left);
                chars.remove(leftChar);
                left++;
            }
            chars.add(currentChar);
            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";

        System.out.println("string: '" + s + "'" + " longest substring length: " + lengthOfLongestSubstring2(s));
    }
}
