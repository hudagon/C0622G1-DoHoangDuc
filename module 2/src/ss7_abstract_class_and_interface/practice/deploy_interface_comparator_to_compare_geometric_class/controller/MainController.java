package ss7_abstract_class_and_interface.practice.deploy_interface_comparator_to_compare_geometric_class.controller;

import ss6_inheritance.practice.demo.system_of_geometric_objects.models.Circle;
import ss7_abstract_class_and_interface.practice.deploy_interface_comparator_to_compare_geometric_class.models.CircleComparator;

import java.util.Arrays;

public class MainController {
    public static void main(String[] args) {
        Circle[] circles = new Circle[3];

        circles[0] = new Circle(3.6);
        circles[1] = new Circle();
        circles[2] = new Circle(3.5, "indigo", false);

        System.out.println("Pre-sorted");
        for (Circle circle : circles) {
            System.out.println(circle.toString());
        }

        System.out.println("Sorted");
        Arrays.sort(circles);

        for (Circle circle : circles) {
            System.out.println(circle.toString());
        }
    }
}
