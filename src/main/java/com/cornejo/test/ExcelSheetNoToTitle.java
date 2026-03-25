package com.cornejo.test;

import java.util.HashMap;
import java.util.Map;

public class ExcelSheetNoToTitle {

    public static void main(String[] args) {
        int sheetNumber = 701;

        System.out.println("Number: " + sheetNumber + " title: " + convertToTitle(sheetNumber));

        sheetNumber = 1;

        System.out.println("Number: " + sheetNumber + " title: " + convertToTitle(sheetNumber));

        sheetNumber = 1;

        System.out.println("Number: " + sheetNumber + " title: " + convertToTitle(sheetNumber));
    }

    public static String convertToTitle(int columnNumber) {
        String letters = "";
        int copy = columnNumber;
        Map<Integer, Character> numberLetterMap = getNumberLetterMap();

        while (copy > 0) {
            int res = (--copy) % 26;
            char currChar = numberLetterMap.get(res);
            letters = String.valueOf(currChar) + letters;
            copy /= 26;
        }

        return letters;

    }

    public static Map<Integer, Character> getNumberLetterMap() {
        Map<Integer, Character> map = new HashMap<>();
        map.put(0, 'A');
        map.put(1, 'B');
        map.put(2, 'C');
        map.put(3, 'D');
        map.put(4, 'E');
        map.put(5, 'F');
        map.put(6, 'G');
        map.put(7, 'H');
        map.put(8, 'I');
        map.put(9, 'J');
        map.put(10, 'K');
        map.put(11, 'L');
        map.put(12, 'M');
        map.put(13, 'N');
        map.put(14, 'O');
        map.put(15, 'P');
        map.put(16, 'Q');
        map.put(17, 'R');
        map.put(18, 'S');
        map.put(19, 'T');
        map.put(20, 'U');
        map.put(21, 'V');
        map.put(22, 'W');
        map.put(23, 'X');
        map.put(24, 'Y');
        map.put(25, 'Z');

        return map;
    }
}
