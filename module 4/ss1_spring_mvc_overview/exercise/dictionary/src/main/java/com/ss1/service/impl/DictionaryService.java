package com.ss1.service.impl;


import com.ss1.service.IDictionaryService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService {
    static Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("orange", "cam");
        dictionary.put("apple", "táo");
        dictionary.put("mango", "xoài");
        dictionary.put("watermelon", "dưa hấu");
        dictionary.put("pineapple", "dứa");
    }


    @Override
    public String lookUp(String word) {
        String wordFound = "Not found!";

        for (String x : dictionary.keySet()) {
            if (x.equals(word)) {
                wordFound = dictionary.get(x);
            }
        }

        return wordFound;
    }
}
