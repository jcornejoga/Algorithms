package com.cornejo.test.algorithm;

import java.util.Arrays;

public class FindMissingNumberInSequence {

    public static int findMissingNumberInSequence(int[] array) {
        int n = array.length + 1;

        for (int i = 1; i <= n; i++) {
            boolean found = false;
            for (int num: array) {
                if (i == num) {
                    System.out.println("found " + i);
                    found = true;
                    break;
                }
            }
            if (!found) {
                return i;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        int[] array = {3, 2, 1, 6, 7, 5};
        System.out.println(Arrays.toString(array));

        System.out.println("missing " + findMissingNumberInSequence(array));
    }
}
