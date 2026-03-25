package com.cornejo.test.algorithm;

import java.util.Arrays;

public class RemoveDupsInArray {
    public static int removeDuplicates(int[] arr) {
        int n = arr.length;

        int j = 0; // last of unique element

        for (int i = 0; i < n; i++) { // loop over each element in the array
            boolean isDup = false;

            for (int k = 0; k < j; k++) {
                if (arr[i] == arr[k]) {
                    isDup = true;
                    break;
                }
            }

            if (!isDup) {
                arr[j++] = arr[i];
            }

        }

        return j;

    }

    public static void main(String[] args) {
        int[] arr = {4, 2, 9, 2, 3, 4, 1};
        System.out.println(Arrays.toString(arr));
        int newLength = removeDuplicates(arr);
        System.out.println(Arrays.toString(Arrays.copyOf(arr, newLength)));
    }
}
