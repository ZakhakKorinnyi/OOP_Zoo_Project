package zoo.zoo_animals;

import zoo.abstract_hierarchy.Fish;
import zoo.enums.Gender;

public class Pike extends Fish {

    // Pike (Щука) завжди прісноводна.
    public Pike(String name, int age, Gender gender) {
        super(name, age, gender, "Прісна");
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " видає глухий удар хвостом.");
    }

    @Override
    public void play() {
        swim();
    }

    @Override
    public void swim() {
        System.out.println(getName() + " нерухомо завмерла у воді, очікуючи на здобич.");
    }
}