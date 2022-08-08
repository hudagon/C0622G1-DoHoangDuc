package ss6_inheritance.exercise.class_2d_and_class_3d.controller;

import ss6_inheritance.exercise.class_2d_and_class_3d.models.Point2D;
import ss6_inheritance.exercise.class_2d_and_class_3d.models.Point3D;

public class mainController {
    public static void main(String[] args) {
        Point2D object1 = new Point2D(9.8f,2.4f);
        System.out.println(object1.toString());

        Point3D object2 = new Point3D(9.8f,2.6f,7.7f);
        System.out.println(object2.toString());
    }

}
