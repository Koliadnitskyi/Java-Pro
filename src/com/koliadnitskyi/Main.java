package com.koliadnitskyi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final String popularWordsStr = "10 most popular words that have more than 2 characters: ";
    private static final String numberOfUniqueWordsStr = ". Number of unique words: ";
    private static final String reEntryStr = "Enter a book name or type End to stop working:";

    public static void main(String[] args) {
        Scanner bookName = new Scanner(System.in);
        System.out.println(reEntryStr);
        while (true) {
            String reading = bookName.nextLine();
            File path = new File(reading);
            if (reading.equals("End!")) {
                System.out.println("Application completed its work.");
                break;
            } else {
                if (path.exists()) {
                    try {
                        List<Map.Entry<String, Integer>> popularWord = BookParser.gettingPopularWord(String.valueOf(path));
                        int numberOfUniqueWords = BookParser.uniuqueWordCounter(String.valueOf(path));
                        System.out.println(popularWordsStr + popularWord + numberOfUniqueWordsStr + numberOfUniqueWords + "\n" + reEntryStr);
                        BookParser.writingToFile(popularWordsStr + popularWord + numberOfUniqueWordsStr + numberOfUniqueWords, "Statistics " + path);
                    } catch (FileNotFoundException e) {
                        System.out.println("There was a problem reading the file: " + path);
                    }
                } else {
                    System.out.println("There is no such book. " + reEntryStr);
                }
            }
        }
        bookName.close();
    }
}
