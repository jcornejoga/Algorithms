package com.cornejo.test.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindTwoNumbersInArray {

    public static int[] findTwoNumbers(int[] numbers, int target) {

        // Map which store the number in the array as a key and it's index in the array as the value
        Map<Integer, Integer> numbersAndIndexesMap = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];
            int complement = target - number;
            if (numbersAndIndexesMap.containsKey(complement)) {
                return new int[] {numbersAndIndexesMap.get(complement), i};
            }
            numbersAndIndexesMap.put(number, i);
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        int[] numbers = {3, 4, 12, 25, 34};
        int target = 46;

        int[] indexes = findTwoNumbers(numbers, target);

        System.out.println("Numbers array " + Arrays.toString(numbers) + " target " + target);
        System.out.println(Arrays.toString(indexes));

    }
}
