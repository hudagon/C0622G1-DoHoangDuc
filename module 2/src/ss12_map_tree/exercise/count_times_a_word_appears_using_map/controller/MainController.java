package ss12_map_tree.exercise.count_times_a_word_appears_using_map.controller;

import java.util.*;

public class MainController {
    public static void main(String[] args) {
        String str = "heLlo worlDs hello Biden Biden Airblades";
        String[] arrStr = str.split(" ");
        Integer value;
        String word;
        Map<String, Integer> map = new TreeMap<>();

        for (String s : arrStr) {
            word = s.toUpperCase();
            if (map.containsKey(word)) {
                value = map.get(word);
                map.remove(word);
                map.put(word, value + 1);
            } else {
                map.put(word, 1);
            }
        }

        Set<String> set = map.keySet();
        for (String item : set) {
            System.out.printf("%s - %s\n", item, map.get(item));
        }

    }
}
