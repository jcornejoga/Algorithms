package com.cornejo.test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMap {

    public static void main(String[] args) {
        // Example of how to create a map using streams, the map will contain the string as the key and its length as the value
        Map<String, Integer> m = Stream.of("cake", "biscuits", "tart")
                .collect(Collectors.toMap(
                        s -> s,
                        s -> s.length()
                ));

        System.out.println(m);

        // The opposite as previous
        Map<Integer, String> m1 = Stream.of("cake", "biscuits", "tart")
                .collect(Collectors.toMap(
                        s -> s.length(),
                        s -> s,
                        (s1, s2) -> s1 + "," + s2
                ));

        System.out.println(m1);

        // Below is an example of using groupingBy collectors method
        Map<Integer, List<String>> groupedByLength = Stream.of("Tom", "Tom", "Gabriel", "Ale", "Jose")
                .collect(Collectors.groupingBy(s -> s.length()));

        System.out.println(groupedByLength);

    }
}
