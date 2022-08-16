package ss12_map_tree.practice.sort_using_comparable_comparator.controller;

import ss12_map_tree.practice.distinguish_between_hashmap_and_hashset.model.Student;
import ss12_map_tree.practice.sort_using_comparable_comparator.model.AgeComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainController {
    public static void main(String[] args) {
        Student student = new Student("Kien", 30, "HT");
        Student student1 = new Student("Nam", 26, "HN");
        Student student2 = new Student("Anh", 38, "HT" );
        Student student3 = new Student("Tung", 38, "HT" );

        List<Student> lists = new ArrayList<Student>();
        lists.add(student);
        lists.add(student1);
        lists.add(student2);
        lists.add(student3);
        for(Student st : lists){
            System.out.println(st.toString());
        }

        AgeComparator ageComparator = new AgeComparator();
        System.out.println("So sanh theo tuoi:");
        for(Student st : lists){
            System.out.println(st.toString());
        }
    }
}
