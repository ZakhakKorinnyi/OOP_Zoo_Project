package zoo.zoo_animals;

import zoo.abstract_hierarchy.Mammal;
import zoo.enums.Gender;

// ЗМІНА: extends Mammal
public class Lion extends Mammal {

    // Поле, специфічне для лева: розмір прайду
    private int prideSize;

    // Конструктор, який тепер викликає конструктор Mammal
    public Lion(String name, int age, Gender gender, int prideSize) {
        // ВИКЛИК Mammal:
        // 15.0 - приклад періоду вагітності (gestationPeriodWeeks),
        // необхідний для конструктора Mammal
        super(name, age, gender, 15.0);
        this.prideSize = prideSize;
    }

    // Реалізація абстрактного методу makeSound() (тут також можна побачити принцип поліморфізму)
    @Override
    public void makeSound() {
        System.out.println(getName() + " ричить: Ррррр!");
    }

    // Реалізація абстрактного методу play()
    @Override
    public void play() {
        System.out.println(getName() + " грається з іншими членами прайду.");
    }

    // Додатковий метод, що створений спеціально для левів
    public void hunt() {
        System.out.println(getName() + " полює в складі прайду.");
    }

    // Геттер для prideSize
    public int getPrideSize() {
        return prideSize;
    }
}