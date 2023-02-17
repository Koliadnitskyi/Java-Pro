package com.koliadnitskyi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final String popularWordsStr = "10 самых популярных слов которые имеют больше 2 символов: ";
    private static final String numberOfUniqueWordsStr = ". Количество уникальных слов: ";
    private static final String reEntryStr = "Введите имя книги или введите End для прекращения работы:";

    public static void main(String[] args) {
        Scanner bookName = new Scanner(System.in);
        System.out.println(reEntryStr);
        for (; ; ) {
            String reading = bookName.nextLine();
            File path = new File(reading);
            if (reading.equals("End")) {
                System.out.println("Работа приложения окончена.");
                break;
            } else {
                if (path.exists()) {
                    try {
                        List<Map.Entry<String, Integer>> popularWord = BookMethods.gettingPopularWord(String.valueOf(path));
                        int numberOfUniqueWords = BookMethods.gettingNumberOfUniqueWords(String.valueOf(path));
                        System.out.println(popularWordsStr + popularWord + numberOfUniqueWordsStr + numberOfUniqueWords + "\n" + reEntryStr);
                        BookMethods.writingToFile(popularWordsStr + popularWord + numberOfUniqueWordsStr + numberOfUniqueWords, "Statistics " + path);
                    } catch (FileNotFoundException e) {
                        System.out.println("Возникла проблема с чтением файла: " + path);
                    }
                } else {
                    System.out.println("Такой книги нет. " + reEntryStr);
                }
            }
        }
        bookName.close();
    }
}
