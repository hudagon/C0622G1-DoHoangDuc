package ss7_abstract_class_and_interface.exercise.deploy_interface_colorable_for_geometric_class.models;

import ss7_abstract_class_and_interface.exercise.deploy_interface_colorable_for_geometric_class.models._interface.Colorable;

public class Square extends Rectangle implements Colorable {
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
    public String howToColor() {
        return "Color all four sides";
    }

    @Override
    public String toString() {
        return "A Square with Side="
                + getSide()
                + ", which is a subclass of "
                + super.toString();
    }
}
