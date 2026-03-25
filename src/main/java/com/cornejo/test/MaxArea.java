package com.cornejo.test;

import java.util.Arrays;

public class MaxArea {
    public static int maxArea(int[] height) {

        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;
        int currentArea = 0;

        while(j > i) {
            int heightLeft = height[i];
            int heightRight = height[j];
            int distance = j - i;

            System.out.println("----i " + i + "----j " + j + "----------");
            System.out.println("heightRight " + heightRight);
            System.out.println("heightLeft " + heightLeft);
            System.out.println("distance " + distance);


            if (heightLeft > heightRight) {
                currentArea = distance * heightRight;
                System.out.println("moving right");
                j--;
            } else {
                currentArea = distance * heightLeft;
                i++;
                System.out.println("moving left");
            }
            System.out.println("currentArea " + currentArea);
            System.out.println("------------------");

            maxArea = Math.max(maxArea, currentArea);

        }

        return maxArea;

    }

    public static void main(String[] args) {
        int[] height = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println("heights " + Arrays.toString(height));
        System.out.println("max area " + maxArea(height));


    }
}
