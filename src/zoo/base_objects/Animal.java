package zoo.base_objects;

import zoo.enums.Gender;
import zoo_exceptions.InvalidDataException;
import zoo.patterns_strategy.FeedingStrategy; // ДОДАНО ІМПОРТ ДЛЯ СТРАТЕГІЇ

// Абстрактний клас zoo.base_objects.Animal, який буде базовим для всіх конкретних тварин
public abstract class Animal {

    // Приватні поля для інкапсуляції
    private String name;
    private int age;
    private Gender gender;
    private boolean isHealthy;

    // ДОДАНО: Поле для біологічного типу (Хребетні/Безхребетні)
    protected String phylum;

    // ДОДАНО: Контекст для шаблону Стратегія
    private FeedingStrategy feedingStrategy;

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

    // ДОДАНО: Геттер для нового поля phylum
    public String getPhylum() {
        return phylum;
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

    // ЗМІНА: Старий метод eat() тепер публічний інтерфейс, що делегує виконання Стратегії
    public void eat() {
        performFeed();
    }

    // ДОДАНО: Метод, який викликається конкретною Стратегією для виконання базової дії
    public void performEat() {
        System.out.println(getName() + " приймає їжу (базовий метод).");
    }

    // ДОДАНО: Публічний метод для встановлення Стратегії
    public void setFeedingStrategy(FeedingStrategy strategy) {
        this.feedingStrategy = strategy;
    }

    // ДОДАНО: Публічний метод, який делегує виконання Стратегії
    public void performFeed() {
        if (feedingStrategy == null) {
            System.out.println(getName() + " не має визначеної стратегії годування!");
            return;
        }
        this.feedingStrategy.feed(this);
    }


    // Метод виведення інформації про об'єкт
    @Override
    public String toString() {
        return "Тварина: " + name + " (Тип: " + phylum + "), Вік: " + age + ", Стать: " + gender + ", Здорова: " + isHealthy;
    }
}