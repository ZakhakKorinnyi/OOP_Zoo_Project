package zoo.zoo_animals;

public class Frog extends Amphibian {
    public Frog(String name, int age, Gender gender) {
        super(name, age, gender);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " квакає: Ква-ква!");
    }

    @Override
    public void play() {
        System.out.println(getName() + " стрибає по листях.");
    }
}