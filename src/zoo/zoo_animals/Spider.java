package zoo.zoo_animals;

import zoo.abstract_hierarchy.Arthropod;
import zoo.enums.Gender;

public class Spider extends Arthropod {

    // Павук має 8 ніг.
    public Spider(String name, int age, Gender gender) {
        super(name, age, gender, 8);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " тихенько шарудить.");
    }

    @Override
    public void play() {
        System.out.println(getName() + " плете павутину.");
    }

    // Реалізуємо метод, успадкований від Invertebrate
    @Override
    public void moveWithoutSpine() {
        System.out.println(getName() + " швидко перебігає на " + legCount + " ногах.");
    }
}