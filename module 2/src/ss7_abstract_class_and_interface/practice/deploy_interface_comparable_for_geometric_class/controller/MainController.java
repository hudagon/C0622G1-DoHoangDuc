package ss7_abstract_class_and_interface.practice.deploy_interface_comparable_for_geometric_class.controller;

import ss7_abstract_class_and_interface.practice.deploy_interface_comparable_for_geometric_class.models.ComparableCircle;

import java.util.Arrays;

public class MainController {
    public static void main(String[] args) {
        ComparableCircle[] circles = new ComparableCircle[3];
        circles[0] = new ComparableCircle(9,"Green",true);
        circles[1] = new ComparableCircle(1);
        circles[2] = new ComparableCircle(6,"Red");

        System.out.println("Pre-sorted");
        for (ComparableCircle circle : circles) {
            System.out.println(circle.toString());
        }

        Arrays.sort(circles);

        System.out.println("Sorted");
        for (ComparableCircle circle : circles) {
            System.out.println(circle.toString());
        }
    }
}
