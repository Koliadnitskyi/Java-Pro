package com.koliadnitskyi;

public class Verification {
    public boolean languageControl(String hello) {
        String[] uniqueSymbolsOfRussianLanguage = {"ё", "ы"};
        boolean tmp = false;
        for (String symbol : uniqueSymbolsOfRussianLanguage) {
            if (hello.contains(symbol)) {
                tmp = true;
                break;
            }
        }
        return tmp;
    }
}

