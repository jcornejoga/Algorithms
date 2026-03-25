package com.cornejo.test;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class BinarySearchWithDates {

    public static void main(String[] args) {
        LocalDateTime start = LocalDate.of(2025, Month.SEPTEMBER, 1).atStartOfDay();
        LocalDateTime end = start.plusHours(13);
        //LocalDateTime target = start.plusHours(3).plusMinutes(2);
        LocalDateTime target = start.minusMinutes(1);

        log.info("start {} end {} target {}", start, end, target);

        List<LocalDateTime> localDateTimeList = getDateTimeList(start, end, 5);

        var closest = findClosest(localDateTimeList, target);

        log.info("closest found: " + closest);


    }

    public static LocalDateTime findClosest(List<LocalDateTime> dateTimeList, LocalDateTime target) {
        int low = 0, high = dateTimeList.size() -1;

        while (low <= high) {
            int mid = (high + low) / 2;
            var midElement = dateTimeList.get(mid);

            log.info("target {}, low {} mid {}, high {}", target, dateTimeList.get(low), midElement, dateTimeList.get(high));

            if (midElement.equals(target)) {
                return midElement;
            } else if (target.isBefore(midElement)) {
                high = mid - 1;
                log.info("target {} is before {} high decreases {}", target, midElement, high);
            } else {
                low = mid + 1;
                log.info("target {} is after {} low increases {}", target, midElement, low);
            }
        }
        LocalDateTime before = high >= 0 ? dateTimeList.get(high) : null;
        LocalDateTime after = low < dateTimeList.size() ? dateTimeList.get(low) : null;

        if (before == null) return after;
        if (after == null) return before;

        long diffBefore = Math.abs(ChronoUnit.MILLIS.between(before, target));
        long diffAfter = Math.abs(ChronoUnit.MILLIS.between(after, target));

        return (diffBefore <= diffAfter) ? before : after;
    }

    private static List<LocalDateTime> getDateTimeList(LocalDateTime start, LocalDateTime end, int step) {
        List<LocalDateTime> dateTimeList = new ArrayList<>();

        LocalDateTime localDateTime = start;

        while (localDateTime.isBefore(end)) {
            dateTimeList.add(localDateTime);
            localDateTime = localDateTime.plusMinutes(step);
        }

        return dateTimeList;

    }
}
