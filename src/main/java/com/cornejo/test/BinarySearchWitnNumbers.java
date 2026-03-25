package com.cornejo.test;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BinarySearchWitnNumbers {

    public static void main(String[] args) {
        int[] numbers = createIntArray(100, 5);
        int toFind = 103;

        System.out.println(Arrays.toString(numbers));

        System.out.println("to find int " + toFind + " " + findClosest(numbers, toFind));
    }

    public static int findClosest(int[] numbers, int toFind) {
        int bottom = 0, top = numbers.length - 1;
        int mid = top / 2;

        while(bottom < top) {
            if (numbers[mid] == toFind) {
                return toFind;
            } else if (numbers[mid] < mid) {
                top = mid - 1;
            } else {
                bottom = mid + 1;
            }
            mid = (bottom + top) / 2;
        }

        int diffTop = Math.abs(numbers[top] - toFind);
        int diffBottom = Math.abs(numbers[bottom] - toFind);

        return diffTop < diffBottom ? numbers[top] : numbers[bottom];
    }

    public static int[] createIntArray(int size, int step) {
        int[] array = new int[size];
        IntStream.range(0, size).forEach(index -> {

        });
        return array;
    }
}
