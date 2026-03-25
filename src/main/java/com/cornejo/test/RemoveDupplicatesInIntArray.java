package com.cornejo.test;

import java.util.Arrays;

public class RemoveDupplicatesInIntArray {

    public static int removeDuplicates(int[] nums) {
        int pos = 0;
        int current = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (pos == 0 || nums[i] > current) {
                nums[pos++] = nums[i];
                current = nums[i];
                count++;
            }
        }
        for (int i = count; i < nums.length; i++) {
            nums[i] = -200;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] array = new int[]{0, 0, 1, 1, 2, 5, 30, 30};

        System.out.println(Arrays.toString(array));
        int k = removeDuplicates(array);

        System.out.println(k);
        System.out.println(Arrays.toString(array));

    }

}
