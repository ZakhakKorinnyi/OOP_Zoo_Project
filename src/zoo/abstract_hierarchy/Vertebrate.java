package zoo.abstract_hierarchy;

import zoo.base_objects.Animal;
import zoo.enums.Gender;

// Базовий клас для хребетних тварин
public abstract class Vertebrate extends Animal {

    public Vertebrate(String name, int age, Gender gender) {
        super(name, age, gender);
        this.phylum = "Хребетні"; // Встановлюємо тип
    }

    // Можна додати загальний метод для хребетних
    public void moveSpine() {
        System.out.println(getName() + " використовує хребет для руху.");
    }
}