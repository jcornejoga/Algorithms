package com.cornejo.test.algorithm;

import java.util.Arrays;

public class MoveZerosToEndOfArray {

    public static void moveZerosToEnd(int[] array) {

        int j = array.length - 1; // last place of the array

        for (int i = 0; i < array.length; i++) {
            if (i < j) {
                if (array[i] == 0) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                    j--;
                }
            }
        }
    }

    public static void moveZerosToEndKeepOrder(int[] array) {
        int pos = -1;

        for (int i=0; i<array.length; i++) {
            //System.out.println(Arrays.toString(array));
            if (pos == -1 && array[i] == 0) {
                pos = i;
            } else if (pos >= 0 && array[i] > 0) {
                array[pos] = array[i];
                array[i] = 0;
                pos++;
            }
        }

    }

    public static void moveZerosToEndKeepOrder_c(int[] array) {

        int pos = 0;

        for (int i=0; i<array.length; i++) {
            if (array[i] != 0) {
                array[pos++] = array[i];
            }
        }

        for (int i=pos; i<array.length; i++) {
            array[i] = 0;
        }
    }

    public static void main(String[] args) {
        //int[] array = {0, 3, 4, 5, 2, 0, 9, 0, 0, 1};
        int[] array = {1, 0, 3, 4, 0, 67, 9, 0, 1, 1, 0, 0, 0, 5, 2, 0, 9, 0, 0, 1};

        System.out.println(Arrays.toString(array));

        //moveZerosToEnd(array);

        //System.out.println(Arrays.toString(array));

        //moveZerosToEndKeepOrder(array);

        //System.out.println(Arrays.toString(array));

        moveZerosToEndKeepOrder_c(array);

        System.out.println(Arrays.toString(array));


    }
}
