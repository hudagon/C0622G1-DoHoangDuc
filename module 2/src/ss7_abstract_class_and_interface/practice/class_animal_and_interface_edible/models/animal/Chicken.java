package ss7_abstract_class_and_interface.practice.class_animal_and_interface_edible.models.animal;

import ss7_abstract_class_and_interface.practice.class_animal_and_interface_edible.models.edible.Edible;
import ss7_abstract_class_and_interface.practice.class_animal_and_interface_edible.models.fly.Fly;

public class Chicken extends Animal implements Edible, Fly {
    @Override
    public String makeNoise() {
        return "Chicken: Cooko Cookooo!";
    }

    @Override
    public String howToEat() {
        return "You can fry the chicken";
    }

    @Override
    public String Fly() {
        return "Gà bay bằng cách vỗ cánh";
    }
}
