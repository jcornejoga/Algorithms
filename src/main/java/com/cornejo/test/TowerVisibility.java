package com.cornejo.test;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

public class TowerVisibility {

    public static List<Integer> getTowersVisibility(List<Integer> heights) {
        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < heights.size(); i++) {
            int towerHeight = heights.get(i);
            int count = 0;
            for (int j = i + 1; j < heights.size(); j++) {
                count++;
                if (heights.get(j) >= towerHeight) {
                    break;
                }
            }
            results.add(i, count);
        }

        for (int i = heights.size() - 1; i >= 0; i--) {
            int towerHeight = heights.get(i);
            int count = 0;
            for (int j = i - 1; j >= 0; j--) {
                count++;
                if (heights.get(j) >= towerHeight) {
                    break;
                }
            }
            results.set (i, results.get(i) + count);
        }

        return results;
    }

    public static int[] getTowersVisibility(int[] heights) {
        int results[] = new int[heights.length];
        Map<Pair<Integer, Integer>, Boolean> visibilityCache = new HashMap<>();

        for (int i = 0; i < heights.length; i++) {
            int visibleCount = 0;
            for (int j = i + 1; j < heights.length; j++) {
                boolean visible = false;
                if (areTwoTowersVisible(i, j, heights)) {
                    visibleCount++;
                    visible = true;
                } else {
                    //break;
                }
                visibilityCache.put(new ImmutablePair<>(i, j), visible);
            }
            results[i] = visibleCount;
        }

        for (int i = heights.length - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (visibilityCache.get(new ImmutablePair<>(j, i))) {
                    results[i]++;
                }
            }
        }

        return results;
    }

    public static boolean areTwoTowersVisible(int idxTwrOne, int idxTwrTwo, int[] heights) {
        int twrOne = heights[idxTwrOne];
        int twrTwo = heights[idxTwrTwo];

        for (int i = idxTwrOne + 1; i < idxTwrTwo; i++) {
            int currentTwr = heights[i];
            if (currentTwr >= twrOne || currentTwr >= twrTwo) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        //List<Integer> heights = List.of(10, 3, 7, 4, 12, 2);
        //List<Integer> heights = List.of(1, 10, 20, 30, 40, 50);
        //int[] heights = new int[] {10, 3, 7, 4, 12, 2};
        int[] heights = new int[] {1, 3, 5, 4, 2, 7};

        //System.out.println(heights);
        //System.out.println(getTowersVisibility(heights));

        System.out.println(Arrays.toString(heights));
        System.out.println(Arrays.toString(getTowersVisibility(heights)));

    }
}
