package ss6_inheritance.exercise.class_circle_and_class_cylinder.controller;

import ss6_inheritance.exercise.class_circle_and_class_cylinder.models.Circle;
import ss6_inheritance.exercise.class_circle_and_class_cylinder.models.Cylinder;
import ss7_abstract_class_and_interface.practice.deploy_interface_comparable_for_geometric_class.models.ComparableCircle;

public class MainController {
    public static void main(String[] args) {
        Circle cirlce1 = new Circle(2, "green") {
            @Override
            public int CompareTo(ComparableCircle o) {
                return 0;
            }
        };
        System.out.println("This is " + cirlce1.toString());

        Cylinder cylinder1 = new Cylinder(2,"red", 3);
        System.out.println("This is " + cylinder1.toString());
    }
}
