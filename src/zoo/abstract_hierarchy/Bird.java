package zoo.abstract_hierarchy;

import zoo.enums.Gender;

// Клас Птахів
public abstract class Bird extends Vertebrate {
    protected double wingSpanCm;

    public Bird(String name, int age, Gender gender, double wingSpanCm) {
        super(name, age, gender);
        this.wingSpanCm = wingSpanCm;
    }

    public abstract void fly();
}