package zoo.zoo_animals;

import zoo_exceptions.InvalidDataException; // імпорт

// Абстрактний клас zoo.zoo_animals.Animal, який буде базовим для всіх конкретних тварин
public abstract class Animal {

    // Приватні поля для інкапсуляції
    private String name;
    private int age;
    private Gender gender;
    private boolean isHealthy;

    // Конструктор
    public Animal(String name, int age, Gender gender) {
        // Перевірка на некоректні дані
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidDataException("Ім'я тварини не може бути порожнім.");
        }
        if (age < 0) {
            throw new InvalidDataException("Вік тварини не може бути від'ємним.");
        }

        this.name = name;
        this.age = age;
        this.gender = gender;
        this.isHealthy = true; // За замовчуванням тварина здорова
    }

    // Абстрактні методи. Кожен підклас повинен буде їх реалізувати.
    public abstract void makeSound();
    public abstract void play();

    // Публічні методи (так звані "геттери") для доступу до полів - інкапсуляція
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public boolean isHealthy() {
        return isHealthy;
    }

    // Методи для зміни стану тварини
    public void getSick() {
        this.isHealthy = false;
        System.out.println(name + " захворів.");
    }

    public void treat() {
        this.isHealthy = true;
        System.out.println(name + " вилікувався.");
    }

    public void eat() {
        System.out.println(name + " їсть.");
    }

    // Метод виведення інформації про об'єкт
    @Override
    public String toString() {
        return "Тварина: " + name + ", Вік: " + age + ", Стать: " + gender + ", Здорова: " + isHealthy;
    }
}
