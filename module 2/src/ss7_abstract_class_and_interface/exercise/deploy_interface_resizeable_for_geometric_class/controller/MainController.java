package ss7_abstract_class_and_interface.exercise.deploy_interface_resizeable_for_geometric_class.controller;

import ss7_abstract_class_and_interface.exercise.deploy_interface_resizeable_for_geometric_class.models.Circle;
import ss7_abstract_class_and_interface.exercise.deploy_interface_resizeable_for_geometric_class.models.Rectangle;
import ss7_abstract_class_and_interface.exercise.deploy_interface_resizeable_for_geometric_class.models.Shape;
import ss7_abstract_class_and_interface.exercise.deploy_interface_resizeable_for_geometric_class.models.Square;

public class MainController {
    public static void main(String[] args) {
        double random = Math.random() * 100 + 1;
        Shape[] shapes = new Shape[3];

        shapes[0] = new Circle(3,"Green",true);
        shapes[1] = new Rectangle(4,5);
        shapes[2] = new Square(3.5,"Red",true);

        System.out.println("Area of each shape Pre-ChangeSize");
        for (Shape item : shapes) {
            System.out.println(item.getArea());
        }

        System.out.println("Area of each shape After increasing size by " + random + "%");
        for (Shape value : shapes) {
            if (value instanceof Square) {
                value.resize(random);
            } else if (value instanceof Rectangle) {
                value.resize(random);
            } else {
                value.resize(random);
            }
        }
        for (Shape shape : shapes) {
            System.out.println(shape.getArea());
        }
    }
}
