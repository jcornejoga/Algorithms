package com.cornejo.test;

import java.util.List;

public class DaysStreak {

    public static int findMaxStreak(List<String> days) {
        int count = 0;
        int maxStreak = 0;

        for (String day: days) {
            if (day.contains("N")) {
                if (count > maxStreak) {
                    maxStreak = count;
                }
                count = 0;
            } else {
                count++;
            }
        }
        if (count > maxStreak) {
            maxStreak = count;
        }
        return maxStreak;
    }

    public static void main(String[] args) {
        List<String> days = List.of("YYY", "YYY", "YYY", "YYY", "YNN", "YYN", "YYY", "YYY", "YYY", "YYN", "YYY");

        System.out.println("days " + days);
        System.out.println(findMaxStreak(days));
    }
}
