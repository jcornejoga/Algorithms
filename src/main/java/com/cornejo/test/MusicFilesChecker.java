package com.cornejo.test;

import java.util.Set;

public class MusicFilesChecker {

    private final static String firstFile = "/home/jcornejo/code/scripts/mp3-resample/file_names_drive.txt";
    private final static String secondFile = "/home/jcornejo/code/scripts/mp3-resample/file_names_lap.txt";

    public static void main(String[] args) {
        Set<String> firstFileContents = MyFileReader.getFileContents(firstFile);
        Set<String> secondFileContents = MyFileReader.getFileContents(secondFile);



        for(String file: firstFileContents) {
            if(!secondFileContents.contains(file)) {
                System.out.println("file doesn't exist in both libraries " + file);
            }
        }

    }
}
