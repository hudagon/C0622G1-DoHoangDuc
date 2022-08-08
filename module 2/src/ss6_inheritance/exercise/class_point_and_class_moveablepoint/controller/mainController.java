package ss6_inheritance.exercise.class_point_and_class_moveablepoint.controller;

import ss6_inheritance.exercise.class_point_and_class_moveablepoint.models.MoveablePoint;
import ss6_inheritance.exercise.class_point_and_class_moveablepoint.models.Point;

public class mainController {
    public static void main(String[] args) {
        Point object1 = new Point(5.5f,6.7f);
        System.out.println(object1.toString());

        MoveablePoint object2 = new MoveablePoint(5.5f,6.7f, 777,888);
        System.out.println(object2.toString());
        object2.move();
        System.out.println(object2.toString());
    }
}
