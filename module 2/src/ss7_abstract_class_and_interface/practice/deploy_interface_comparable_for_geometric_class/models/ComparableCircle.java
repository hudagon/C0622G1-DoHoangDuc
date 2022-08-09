package ss7_abstract_class_and_interface.practice.deploy_interface_comparable_for_geometric_class.models;

import ss6_inheritance.practice.demo.system_of_geometric_objects.models.Circle;

public class ComparableCircle extends Circle implements Comparable<Circle> {
    public ComparableCircle() {}

    public ComparableCircle(double radius, String color, boolean filled) {
        super(radius, color, filled);
    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle(double radius, String color) {
        super(radius, color);
    }

    @Override
    public int compareTo(Circle o) {
        if (getRadius() > o.getRadius()) return 1;
        else if (getRadius() < o.getRadius()) return -1;
        else return 1;
    }
}
