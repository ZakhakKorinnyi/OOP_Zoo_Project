package zoo.zoo_animals;

import zoo.abstract_hierarchy.Insect;
import zoo.enums.Gender;

public class Butterfly extends Insect {

    public Butterfly(String name, int age, Gender gender) {
        super(name, age, gender);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " не видає звуків.");
    }

    @Override
    public void play() {
        locomotion();
    }

    // Реалізація абстрактного методу з Insect
    @Override
    public void locomotion() {
        System.out.println(getName() + " тихо літає між квітами.");
    }
}