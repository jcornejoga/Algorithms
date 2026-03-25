package com.cornejo.test;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public static List<List<Integer>> getCombinations(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    public static void backtrack(int start, int n, int k, List<Integer> current, List<List<Integer>> result) {

        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= n; i++) {
            current.add(i);
            backtrack(i+1, n, k, current, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 1;

        System.out.println(getCombinations(n, k));

    }
}
