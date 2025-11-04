package zoo.zoo_animals;

// Клас Плазунів, успадковується від Vertebrate
public abstract class Reptile extends Vertebrate {

    public Reptile(String name, int age, Gender gender) {
        super(name, age, gender); // Викликаємо конструктор Vertebrate
    }

    // Специфічний метод для плазунів
    public void regulateTemperature() {
        System.out.println(getName() + " регулює температуру, гріючись на сонці.");
    }
}