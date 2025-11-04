package zoo.abstract_hierarchy;

import zoo.enums.Gender;

// Клас Земноводних
public abstract class Amphibian extends Vertebrate {

    public Amphibian(String name, int age, Gender gender) {
        super(name, age, gender);
    }

    public void absorbWater() {
        System.out.println(getName() + " вбирає воду через шкіру.");
    }
}