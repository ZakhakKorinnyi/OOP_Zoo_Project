package zoo.zoo_animals;

// Клас Членистоногих (павуки, раки, скорпіони)
public abstract class Arthropod extends Invertebrate {
    protected int legCount;

    public Arthropod(String name, int age, Gender gender, int legCount) {
        super(name, age, gender);
        this.legCount = legCount;
    }

    public void shedExoskeleton() {
        System.out.println(getName() + " скидає свій екзоскелет.");
    }
}