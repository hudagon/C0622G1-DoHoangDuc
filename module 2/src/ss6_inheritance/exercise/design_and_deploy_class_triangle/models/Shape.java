package ss6_inheritance.exercise.design_and_deploy_class_triangle.models;

public class Shape {
    private String color;

    public Shape() {
        this.color = "green";
    }

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return "A Shape with color of " + this.color;
    }
}
