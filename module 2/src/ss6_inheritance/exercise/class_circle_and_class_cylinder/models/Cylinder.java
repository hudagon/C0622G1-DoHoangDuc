package ss6_inheritance.exercise.class_circle_and_class_cylinder.models;

import ss7_abstract_class_and_interface.practice.deploy_interface_comparable_for_geometric_class.models.ComparableCircle;

public class Cylinder extends Circle {
    private double height;

    public Cylinder(double height, String color, double radius) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return super.getArea() * this.height;
    }

    @Override
    public String toString() {
        return "A Cylinder, which is a subclass of the " + super.toString() + " and has the volume of " + getVolume();
    }

    @Override
    public int CompareTo(ComparableCircle o) {
        return 0;
    }
}
