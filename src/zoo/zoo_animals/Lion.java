package zoo.zoo_animals;

// Клас zoo.zoo_animals.Lion, який успадковує від абстрактного класу zoo.zoo_animals.Animal
public class Lion extends Animal {

    // Поле, специфічне для лева: розмір прайду
    private int prideSize;

    // Конструктор, який викликає конструктор батьківського класу zoo.zoo_animals.Animal
    public Lion(String name, int age, Gender gender, int prideSize) {
        super(name, age, gender);
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