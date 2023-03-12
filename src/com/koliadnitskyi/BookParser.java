package com.koliadnitskyi;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BookParser {

    private static Stream<String> gettingWords(String path) throws FileNotFoundException {
        return new BufferedReader(new FileReader(path))
                .lines()
                .map(x -> x.split(" "))
                .flatMap(Arrays::stream)
                .map(s -> s.replaceAll("[!\"#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~]", ""))
                .map(String::toLowerCase);
    }

    private static List<String> gettingAllUniqueWords(String path) throws FileNotFoundException {
        return gettingWords(path)
                .distinct()
                .filter(s -> s.length() > 2)
                .toList();
    }

    private static List<String> gettingAllWords(String path) throws FileNotFoundException {
        return gettingWords(path)
                .filter(s -> s.length() > 2)
                .toList();
    }

    private static Map<String, Integer> count(String path) throws FileNotFoundException {
        int counter = 0;
        Map<String, Integer> popularWords = new HashMap<>();

        for (String allUniqueWords : gettingAllUniqueWords(path)) {
            for (String allWords : gettingAllWords(path)) {
                if (allUniqueWords.equals(allWords)) {
                    counter++;
                }
            }
            popularWords.put(allUniqueWords, counter);
            counter = 0;
        }
        return popularWords;
    }

    public static List<Map.Entry<String, Integer>> gettingPopularWord(String path) throws FileNotFoundException {
        return count(path)
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(10)
                .collect(Collectors.toList());
    }

    public static int uniuqueWordCounter(String path) throws FileNotFoundException {
        return (int) gettingWords(path)
                .distinct()
                .count();
    }

    public static void writingToFile(String data, String name) {
        try (PrintWriter savingStatisticalData = new PrintWriter(name)) {
            savingStatisticalData.println(data);
        } catch (FileNotFoundException e) {
            System.out.println("There was a problem writing data to a file");
        }
    }
}
