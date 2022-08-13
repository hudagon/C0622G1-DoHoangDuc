package ss10_dsa_list.exercise.deploy_methods_of_arraylist_arcording_to_the_library.controller;


import ss10_dsa_list.exercise.deploy_methods_of_arraylist_arcording_to_the_library.model.MyList;
import ss6_inheritance.practice.demo.Student;

public class MyListTest {
    public static void main(String[] args) {
        Student student1 = new Student("A");
        Student student2 = new Student("B");
        Student student3 = new Student("C");

        MyList<Student> studentArrayList = new MyList<>();

        studentArrayList.add(student1);
        studentArrayList.add(student2);
        studentArrayList.add(student3);

        for (int i = 0; i < studentArrayList.size(); i++) {
            System.out.println(studentArrayList.get(i));
        }

    }
}
