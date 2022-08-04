package ss4_oop.practice.rectangle_class;

public class Rectangle {
    double width,height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return (width + height) * 2;
    }

    public String display() {
        return "Rectangle{width = " + width + "; height = " + height + "}";
    }

}
