package ss12_map_tree.practice.distinguish_between_hashmap_and_hashset.controller;

import ss12_map_tree.practice.distinguish_between_hashmap_and_hashset.model.Student;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MainController {
    public static void main(String[] args) {
        Student student1 = new Student("wot",3,"Home");
        Student student2 = new Student("hez",4,"Home");
        Student student3 = new Student("foo",5,"Home");

        Map<Integer, Student> hashMap = new HashMap<>();

        hashMap.put(1, student1);
        hashMap.put(2, student2);
        hashMap.put(3, student3);

        Set<Integer> set = hashMap.keySet();

        for (Integer item : set) {
            System.out.printf("%s - %s", item, hashMap.get(item));
        }
//        ------------------------------------------------------------
        Student student4 = new Student("bar",6,"Home");
        Student student5 = new Student("ski",7,"Home");
        Student student6 = new Student("tus",8,"Home");

        Set<Student> students = new HashSet<>();

        students.add(student4);
        students.add(student5);
        students.add(student6);

        for (Student student : students) {
            System.out.println(student.toString());
        }

    }
}
