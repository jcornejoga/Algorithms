package com.cornejo.test;

public class MethodObjectParam {
    public static void main(String[] args) {
        String word = "hello";
        System.out.println(word);
        changeString(word);
        System.out.println(word); 

    }

    public static void changeString(String s) {
        s = "world";
    }
}
