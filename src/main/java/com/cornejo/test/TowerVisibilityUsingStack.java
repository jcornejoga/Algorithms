package com.cornejo.test;

import java.util.Arrays;
import java.util.Stack;

public class TowerVisibilityUsingStack {

    public static int[] visibleTowers(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        // Compute visibility to the right
        computeRightVisibility(heights, right);

        // Compute visibility to the left
         computeLeftVisibility(heights, left);

        // Combine results
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = left[i] + right[i];
        }

        return result;
    }

    private static void computeRightVisibility(int[] heights, int[] right) {
        Stack<Integer> stack = new Stack<>();

        for (int i = heights.length - 1; i >= 0; i--) {
            int current = heights[i];
            int visible = 0;

            // Pop all shorter towers
            while (!stack.isEmpty() && stack.peek() < current) {
                stack.pop();
                visible++;
            }

            // If there is a blocking tower, count it
            if (!stack.isEmpty()) {
                visible++;
            }

            right[i] = visible;

            // Push current tower height
            stack.push(current);
        }
    }

    private static void computeLeftVisibility(int[] heights, int[] left) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            int current = heights[i];
            int visible = 0;

            // Pop all shorter towers
            while (!stack.isEmpty() && stack.peek() < current) {
                stack.pop();
                visible++;
            }

            // If there is a blocking tower, count it
            if (!stack.isEmpty()) {
                visible++;
            }

            left[i] = visible;

            // Push current tower height
            stack.push(current);
        }
    }

    // ---------- Example usage ----------
    public static void main(String[] args) {
        //int[] towers = {10, 3, 7, 4, 12, 2};
        //int[] towers = {1, 10, 20, 30, 40, 50};
        int [] towers = {1, 3, 5, 4, 2, 7};
        int[] result = visibleTowers(towers);

        System.out.println("towers " + Arrays.toString(towers) + " visibility " + Arrays.toString(result));
        // Output should be: 4 2 4 2 5 1
    }
}

