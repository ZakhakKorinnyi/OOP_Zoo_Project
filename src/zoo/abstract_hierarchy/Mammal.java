package zoo.abstract_hierarchy;

import zoo.enums.Gender;

// Клас Ссавців, успадковується від Vertebrate
public abstract class Mammal extends Vertebrate {

    protected double gestationPeriodWeeks;

    public Mammal(String name, int age, Gender gender, double gestationPeriodWeeks) {
        super(name, age, gender); // Викликаємо конструктор Vertebrate
        this.gestationPeriodWeeks = gestationPeriodWeeks;
    }

    // Специфічний метод для ссавців
    public void giveBirth() {
        System.out.println(getName() + " народжує дитинча.");
    }
}