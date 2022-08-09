package ss7_abstract_class_and_interface.practice.class_animal_and_interface_edible.controller;

import ss7_abstract_class_and_interface.practice.class_animal_and_interface_edible.models.animal.Chicken;
import ss7_abstract_class_and_interface.practice.class_animal_and_interface_edible.models.animal.Tiger;

public class MainController {
    public static void main(String[] args) {
        Tiger tiger1 = new Tiger();
        Chicken chicken1 = new Chicken();

        System.out.println(tiger1.makeNoise());
        System.out.println(chicken1.makeNoise());
        System.out.println(chicken1.Fly());
    }
}
