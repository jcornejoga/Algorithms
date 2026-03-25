package com.cornejo.test.algorithm;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = {2, 4, 9, 1, 6, 8, 3, 7, 5};

        quickSort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));
    }


    private static void quickSort(int[] array, int start, int end) {

        //System.out.println(Arrays.toString(array));

        if (end < start) return;

        int pivot = partition(array, start, end);

        quickSort(array, start, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    private static int partition(int[] array, int start, int end) {

        int i = start - 1;

        for (int j=start; j <= end; j++) {
            if (array[j] < array[end]) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        i++;
        int temp = array[end];
        array[end] = array[i];
        array[i] = temp;

        return i;
    }
}
