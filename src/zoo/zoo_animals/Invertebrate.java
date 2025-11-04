package zoo.zoo_animals;

// Базовий клас для безхребетних тварин
public abstract class Invertebrate extends Animal {

    public Invertebrate(String name, int age, Gender gender) {
        super(name, age, gender);
        this.phylum = "Безхребетні"; // Встановлюємо тип
    }

    // Приклад методу для безхребетних
    public void moveWithoutSpine() {
        System.out.println(getName() + " пересувається без допомоги хребта.");
    }
}