package com.cornejo.test;

public class IntegerPalindrome {
    public static boolean isPalindrome(int x) {
        int reverse = 0;
        int xcopy = x;

        while (xcopy > 0) {
            reverse = (reverse * 10) + (xcopy % 10);
            xcopy = xcopy / 10;
        }

        return x == reverse;

    }

    public static void main(String[] args) {
        int palindrome = 113112;

        System.out.println("number " + palindrome + " is palindrome? " + isPalindrome(palindrome));
    }
}
