package ss6_inheritance.exercise.class_circle_and_class_cylinder.controller;

import ss6_inheritance.exercise.class_circle_and_class_cylinder.models.Circle;
import ss6_inheritance.exercise.class_circle_and_class_cylinder.models.Cylinder;

public class mainController {
    public static void main(String[] args) {
        Circle cirlce1 = new Circle(2,"green");
        System.out.println("this is " + cirlce1.toString());

        Cylinder cylinder1 = new Cylinder(2,"red", 3);
        System.out.println(cylinder1.toString());
    }
}
