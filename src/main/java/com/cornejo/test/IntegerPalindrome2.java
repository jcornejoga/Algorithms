package com.cornejo.test;

import java.util.Map;

public class IntegerPalindrome2 {

    // 101
    public static boolean isPalindrome(int num) {
        int result = 0;
        int copy = num;

        while (copy > 0) {
            //int newDigit = copy % 10;
            //result *= 10;
            //result += newDigit;

            result = (copy % 10) + (result * 10);

            copy /= 10;
        }

        System.out.println("reverse " + result);

        return num == result;
    }

    public static void main(String[] args) {
        int p = 3101014;

        System.out.println("number " + p + " is palindrome? " + isPalindrome(p));
    }
}
