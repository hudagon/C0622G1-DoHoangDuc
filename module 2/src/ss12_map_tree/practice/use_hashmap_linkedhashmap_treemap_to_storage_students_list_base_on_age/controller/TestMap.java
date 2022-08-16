package ss12_map_tree.practice.use_hashmap_linkedhashmap_treemap_to_storage_students_list_base_on_age.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestMap {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();

        hashMap.put("foo", 1);
        hashMap.put("bar", 2);
        hashMap.put("wot", 3);
        hashMap.put("hez", 4);
        hashMap.put("tus", 5);
        hashMap.put("ski", 6);

        System.out.println("Display entries in HashMap");
        System.out.println(hashMap + "\n");
//        -----------------------------------------------
        Map<String, Integer> treeMap = new TreeMap<>(hashMap);
        System.out.println("Display entries in descending order of key");
        System.out.println(treeMap);
//        -----------------------------------------------
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(treeMap);
        System.out.println("\nThe age for " + "wot is " + linkedHashMap.get("wot"));
    }
}
