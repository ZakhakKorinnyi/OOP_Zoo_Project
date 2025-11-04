package zoo.zoo_animals;

// Клас Комах
public abstract class Insect extends Invertebrate {

    public Insect(String name, int age, Gender gender) {
        super(name, age, gender);
    }

    // Специфічний метод: вміння літати/повзати
    public abstract void locomotion();
}