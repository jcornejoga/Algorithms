package com.cornejo.test;

public class BinaryAddition {

    public static String addBinary(String a, String b) {
        String longer = a.length() >= b.length() ? a : b;
        String shorter = a.length() < b.length() ? a : b;
        boolean carry = false;
        int shorterPos = shorter.length() - 1;
        String result = "";

        for (int i = longer.length() - 1; i >= 0; i--) {
            //System.out.println("i " + i);
            //System.out.println("longer length " + longer.length());
            char first = longer.charAt(i);
            char second = shorterPos >= 0 ? shorter.charAt(shorterPos--) : '0';
            if (first == '1' && second == '1') {
                if (carry) {
                    result = '1' + result;
                } else {
                    result = '0' + result;
                    carry = true;
                }
            } else if (first == '0' && second == '0') {
                if (carry) {
                    result = '1' + result;
                } else {
                    result = '0' + result;
                }
                carry = false;
            } else {
                if (carry) {
                    result = '0' + result;
                } else {
                    result = '1' + result;
                }
            }
        }
        if (carry) {
            result = '1' + result;
        }
        return result;
    }

    public static String addBinary2(String a, String b) {
        String longer = a.length() >= b.length() ? a : b;
        String shorter = a.length() < b.length() ? a : b;
        boolean carry = false;
        int shorterPos = shorter.length() - 1;
        String result = "";

        for (int i = longer.length() - 1; i >= 0; i--) {
            int first = longer.charAt(i) == '1' ? 1 : 0;
            int second = shorterPos >= 0 ? shorter.charAt(shorterPos--) == '1' ? 1 : 0 : 0;

            int sum = first + second + (carry ? 1 : 0);
            int value = sum % 2;
            carry = sum / 2 == 1;
            result = value == 1 ? '1' + result : '0' + result;
        }
        if (carry) {
            result = '1' + result;
        }
        return result;
    }

    public static String addBinary3(String a, String b) {
        int idxA = a.length() - 1;
        int idxB = b.length() - 1;
        boolean carry = false;
        //String result = "";
        StringBuilder result = new StringBuilder();

        while (idxA >= 0 || idxB >= 0) {
            //int digitInA = idxA >= 0 ? a.charAt(idxA--) == '1' ? 1 : 0 : 0;
            //int digitInB = idxB >= 0 ? b.charAt(idxB--) == '1' ? 1 : 0 : 0;
            int digitInA = idxA >= 0 ? a.charAt(idxA--) - '0' : 0;
            int digitInB = idxB >= 0 ? b.charAt(idxB--) - '0' : 0;

            int sum = digitInA + digitInB;
            if (carry) {
                sum++;
            }
            int value = sum % 2;
            carry = sum / 2 == 1;
            //result = value + result;
            result.append(value);
        }
        if (carry) {
            //result = '1' + result;
            result.append("1");
        }
        //return result;
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "111";
        String b = "111";

        System.out.println("a = '" + a + " ' b = '" + b + "' result = '" + addBinary3(a, b) + "'");
    }
}
