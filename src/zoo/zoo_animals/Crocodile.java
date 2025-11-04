package zoo.zoo_animals;

// Клас zoo.zoo_animals.Crocodile, який успадковує від абстрактного класу zoo.zoo_animals.Animal
public class Crocodile extends Animal {

    // Специфічне для крокодила поле: довжина в метрах
    private double lengthInMeters;

    // Конструктор, який викликає конструктор батьківського класу
    public Crocodile(String name, int age, Gender gender, double lengthInMeters) {
        super(name, age, gender);
        this.lengthInMeters = lengthInMeters;
    }

    // Перевизначення абстрактного методу makeSound() відповідно до особливостей крокодилу
    @Override
    public void makeSound() {
        System.out.println(getName() + " видає низький рев.");
    }

    // Перевизначення абстрактного методу play() відповідно до крокодилу
    @Override
    public void play() {
        System.out.println(getName() + " повільно рухається по воді.");
    }

    // Додатковий метод, специфічний для крокодилів
    public void baskInSun() {
        System.out.println(getName() + " гріється на сонці.");
    }

    @Override
    public String toString() {
        return "Crocodile{" +
                "lengthInMeters=" + lengthInMeters +
                '}';
    }

    public Object toString(String prefix) {
        return "Crocodile{" +
                "lengthInMeters=" + lengthInMeters +
                '}';
    }
}