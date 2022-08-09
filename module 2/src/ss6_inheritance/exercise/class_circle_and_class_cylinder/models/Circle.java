package ss6_inheritance.exercise.class_circle_and_class_cylinder.models;

import ss7_abstract_class_and_interface.practice.deploy_interface_comparable_for_geometric_class.models.ComparableCircle;

public abstract class Circle {
    private double radius;
    private String color;

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public Circle() {

    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return radius * 2 * Math.PI;
    }

    @Override
    public String toString() {
        return "A Circle that has the radius of " + radius + " and the color of " + color;
    }

    public abstract int CompareTo(ComparableCircle o);
}
