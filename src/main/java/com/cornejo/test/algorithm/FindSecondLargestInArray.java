package com.cornejo.test.algorithm;

import java.util.Arrays;

public class FindSecondLargestInArray {

    public static void main(String[] args) {
        //int[] array = {300, 299, 5, 3, 2, 1, 11, 15};
        //int[] array = {298, 299, 5, 3, 2, 1, 11, 15};
        //int[] array = {2, 1, 500, 32, 2, 1, 11, 15};
        //int[] array = {1, 4, 5, 3, 2, 1, 11, 15};
        int[] array = {1, 4, 5, 3, 2, 1, 23, 15};
        //int[] array = {3, 12, 3, 5, 8, 2, 1, 11, 15};
        //int[] array = {120, 300, 3, 5, 8, 2, 1, 11, 15};
        //int[] array = {300, 3, 5, 804, 2, 1, 11, 15};


        System.out.println(Arrays.toString(array));

        System.out.println("largest " + findLargest(array));

        System.out.println("second largest " + findSecondLargest(array));
    }

    public static int findLargest(int[] array) {
        int largest = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > largest) {
                largest = array[i];
            }
        }

        return largest;
    }

    public static int findSecondLargest(int[] array) {
        int largest = array[0];
        int secondLargest = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] > largest) {
                secondLargest = largest;
                largest = array[i];
            } else if (array[i] > secondLargest) {
                secondLargest = array[i];
            }
        }

        return secondLargest;
    }
}
