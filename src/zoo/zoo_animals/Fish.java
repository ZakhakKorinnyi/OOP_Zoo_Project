package zoo.zoo_animals;

// Клас Риб
public abstract class Fish extends Vertebrate {
    protected String waterType; // Прісна чи морська

    public Fish(String name, int age, Gender gender, String waterType) {
        super(name, age, gender);
        this.waterType = waterType;
    }

    public abstract void swim();
}