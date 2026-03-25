package com.cornejo.test.algorithm;

import java.util.Arrays;

public class ReverseIntArrayInPlace {

    public static void main(String[] args) {
        //int[] array = {82, 34, 45, 2};
        int[] array = {82, 34, 3, 45, 2};


        System.out.println(Arrays.toString(array));

        reverse(array);

        System.out.println(Arrays.toString(array));

        reverse_1(array);

        System.out.println(Arrays.toString(array));
    }

    public static void reverse(int[] array) {

        int mid = array.length / 2;

        for (int i = 0; i < mid; i++) {
            int temp = array[i];
            array[i] = array[array.length - (1 + i)];
            array[array.length - (1 + i)] = temp;
        }

    }

    public static void reverse_1(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            left++;
            right--;
        }
    }
}
