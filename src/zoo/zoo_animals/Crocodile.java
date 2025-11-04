package zoo.zoo_animals;

// ЗМІНА: extends Reptile
public class Crocodile extends Reptile {

    // Специфічне для крокодила поле: довжина в метрах
    private double lengthInMeters;

    // Конструктор, який тепер викликає конструктор Reptile
    public Crocodile(String name, int age, Gender gender, double lengthInMeters) {
        // ВИКЛИК Reptile:
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
        // Викликаємо метод, успадкований від Reptile
        regulateTemperature();
    }

    // Перевизначення методу toString()
    @Override
    public String toString() {
        return "Crocodile{" +
                "lengthInMeters=" + lengthInMeters +
                "}";
    }
}