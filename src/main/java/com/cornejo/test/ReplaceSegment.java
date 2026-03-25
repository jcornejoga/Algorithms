package com.cornejo.test;

import java.util.regex.Pattern;

public class ReplaceSegment {
    public static void main(String[] args) {
        String path = "CO/home/user/documents/work/report.txt";
        int positionToReplace = 3; // 1-based index
        String replacement = "downloads";
        String prefix = "CO/";
        String escapedPrefix = Pattern.quote(prefix);

        // Build regex dynamically: match up to the nth slash group
        String regex = "^" + escapedPrefix + "((?:[^/]+/){"+ (positionToReplace - 1) +"})[^/]+";

        // Replace the nth segment
        String result = path.replaceAll(regex, prefix +  "$1" + replacement);

        System.out.println(result); // 👉 home/user/downloads/work/report.txt
    }
}
