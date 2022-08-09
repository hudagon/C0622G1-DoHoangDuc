package ss7_abstract_class_and_interface.exercise.deploy_interface_resizeable_for_geometric_class.models;

public class Square extends Rectangle {
    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return super.getWidth();
    }

    public void setSide(double width) {
        super.setWidth(width);
    }

    @Override
    public double getArea() {
        return super.getArea();
    }

    @Override
    public double getPerimeter() {
        return super.getPerimeter();
    }

    @Override
    public void resize(double percentage) {
        super.resize(percentage);
    }

    @Override
    public String toString() {
        return "A Square with Side="
                + getSide()
                + ", which is a subclass of "
                + super.toString();
    }
}
