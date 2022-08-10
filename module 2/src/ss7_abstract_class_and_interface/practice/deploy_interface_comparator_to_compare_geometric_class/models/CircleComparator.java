package ss7_abstract_class_and_interface.practice.deploy_interface_comparator_to_compare_geometric_class.models;

import ss6_inheritance.practice.demo.system_of_geometric_objects.models.Circle;

import java.util.Comparator;


public class CircleComparator implements Comparator<Circle> {
    @Override
    public int compare(Circle c1, Circle c2) {
        if (c1.getRadius() > c2.getRadius()) return 1;
        else if (c1.getRadius() < c2.getRadius()) return -1;
        else return 0;
    }
}