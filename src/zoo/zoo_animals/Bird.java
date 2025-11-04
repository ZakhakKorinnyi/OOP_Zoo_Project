package zoo.zoo_animals;

// Клас Птахів
public abstract class Bird extends Vertebrate {
    protected double wingSpanCm;

    public Bird(String name, int age, Gender gender, double wingSpanCm) {
        super(name, age, gender);
        this.wingSpanCm = wingSpanCm;
    }

    public abstract void fly();
}