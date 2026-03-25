package com.cornejo.test;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TowerVisibility2 {

    public static int[] getTowersVisibility(int[] t) {
        int[] v = new int[t.length];
        Map<Pair<Integer, Integer>, Boolean> visibilityMap = new HashMap<>();

        for (int i = 0; i < t.length; i++) {
            int countVisible = 0;
            for (int j = i+1; j < t.length; j++) {
                boolean areTowersVisible = isTowerVisible(t, i, j);
                if (areTowersVisible) countVisible++;
                visibilityMap.put(new ImmutablePair<>(i, j), areTowersVisible);
            }
            v[i] = countVisible;
        }

        for (int i = t.length - 1; i >= 0; i--) {
            int countVisible = 0;
            for (int j = i-1; j >= 0; j--) {
                boolean areTowersVisible = visibilityMap.get(new ImmutablePair<>(j, i));
                if (areTowersVisible) countVisible++;
            }
            v[i] = v[i] + countVisible;
        }

        return v;

    }

    private static boolean isTowerVisible(int[] t, int start, int end) {
        int startLength = t[start];
        int endLength = t[end];

        int lowerTower = Math.min(startLength, endLength);

        for (int i = start + 1; i < end; i++) {
            if (t[i] >= lowerTower) {
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        int[] towersLength = new int[]{1, 3, 5, 4, 2, 7};
        System.out.println("towers length: [" + Arrays.toString(towersLength) + "] visibility [" + Arrays.toString(getTowersVisibility(towersLength)) + "]");
    }
}
