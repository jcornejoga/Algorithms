package com.cornejo.test;

public class IsPalindromeString {

    public static boolean isPalindrome2(String s) {
        int start = 0;
        int last = s.length() - 1;

        while (start < last) {
            char currStart = s.charAt(start);
            char currLast = s.charAt(last);
            if (!Character.isLetterOrDigit(currStart)) {
                start++;
            } else if (!Character.isLetterOrDigit(currLast)) {
                last--;
            } else {
                if (Character.toLowerCase(currStart) != Character.toLowerCase(currLast)) {
                    return false;
                }
                start++;
                last--;
            }
        }

        return true;

    }

    public static boolean isPalindrome(String s) {
        String word = s.toUpperCase().replaceAll("[^A-Z0-9]", "");

        if (word.length() == 1) {
            return true;
        }

        int mid = word.length() / 2;

        System.out.println("word " + word);

        System.out.println("mid " + mid);

        for (int i = 0; i < mid; i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";

        System.out.println("String '" + str + "' is palindrome? " + isPalindrome(str));
    }
}
