package ss7_abstract_class_and_interface.practice.class_animal_and_interface_edible.controller;

import ss7_abstract_class_and_interface.practice.class_animal_and_interface_edible.models.animal.Chicken;
import ss7_abstract_class_and_interface.practice.class_animal_and_interface_edible.models.fruit.Apple;
import ss7_abstract_class_and_interface.practice.class_animal_and_interface_edible.models.fruit.Fruit;
import ss7_abstract_class_and_interface.practice.class_animal_and_interface_edible.models.fruit.Orange;

public class PrimaryContronller {
    public static void main(String[] args) {
        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Orange();
        fruits[1] = new Apple();

        for (Fruit fruit : fruits) {
            System.out.println(fruit.howToEat());
        }

        Chicken chicken1 = new Chicken();
        System.out.println(chicken1.howToEat());
    }
}
