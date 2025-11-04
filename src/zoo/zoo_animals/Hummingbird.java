package zoo.zoo_animals;

import zoo.abstract_hierarchy.Bird;
import zoo.enums.Gender;

// ЗМІНА: extends Bird
public class Hummingbird extends Bird {

    // Специфічне для колібрі поле: швидкість польоту
    private int flightSpeed;

    // Конструктор, який тепер викликає конструктор Bird
    public Hummingbird(String name, int age, Gender gender, int flightSpeed) {
        // ВИКЛИК Bird:
        // 12.0 - приклад розмаху крил (wingSpanCm), необхідний для конструктора Bird
        super(name, age, gender, 12.0);
        this.flightSpeed = flightSpeed;
    }

    // Перевизначення абстрактного методу makeSound() для коліблірі та її особливостей
    @Override
    public void makeSound() {
        System.out.println(getName() + " цвірінькає.");
    }

    // Перевизначення абстрактного методу play() для колібрі та її особливостей
    @Override
    public void play() {
        System.out.println(getName() + " грається, літаючи над квітами.");
    }

    // Додатковий метод, що специфічний для колібрі, який реалізує абстрактний fly() з Bird
    @Override // Додано @Override, оскільки fly() тепер абстрактний у Bird
    public void fly() {
        System.out.println(getName() + " летить зі швидкістю " + flightSpeed + " км/год.");
    }
}