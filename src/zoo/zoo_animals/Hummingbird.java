package zoo.zoo_animals;

// Клас zoo.zoo_animals.Hummingbird, який успадковує від абстрактного класу zoo.zoo_animals.Animal
public class Hummingbird extends Animal {

    // Специфічне для колібрі поле: швидкість польоту
    private int flightSpeed;

    // Конструктор, який викликає конструктор батьківського класу
    public Hummingbird(String name, int age, Gender gender, int flightSpeed) {
        super(name, age, gender);
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

    // Додатковий метод,що специфічний для колібрі
    public void fly() {
        System.out.println(getName() + " летить зі швидкістю " + flightSpeed + " км/год.");
    }
}