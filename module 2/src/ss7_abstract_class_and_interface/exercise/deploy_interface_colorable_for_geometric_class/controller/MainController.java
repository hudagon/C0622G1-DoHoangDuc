package ss7_abstract_class_and_interface.exercise.deploy_interface_colorable_for_geometric_class.controller;

import ss7_abstract_class_and_interface.exercise.deploy_interface_colorable_for_geometric_class.models.Circle;
import ss7_abstract_class_and_interface.exercise.deploy_interface_colorable_for_geometric_class.models.Rectangle;
import ss7_abstract_class_and_interface.exercise.deploy_interface_colorable_for_geometric_class.models.Shape;
import ss7_abstract_class_and_interface.exercise.deploy_interface_colorable_for_geometric_class.models.Square;
import ss7_abstract_class_and_interface.exercise.deploy_interface_colorable_for_geometric_class.models._interface.Colorable;

public class MainController {
    public static void main(String[] args) {
        Shape rect = new Rectangle(3, 7);
        Shape circle = new Circle(4);
        Shape square = new Square(4);
        Shape[] shapes = new Shape[] {rect, square, circle};

        for(Shape shape : shapes) {
            if(shape instanceof Colorable) {
                System.out.println(((Colorable) shape).howToColor());
            } else {
                System.out.println(shape.getArea());
            }
        }

    }
}
