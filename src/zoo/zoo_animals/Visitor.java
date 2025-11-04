package zoo.zoo_animals;

public class Visitor {

    private String name;
    private int age;
    private Gender gender; // Використання раніше створеного Enum
    private boolean hasTicket;

    public Visitor(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.hasTicket = false; // Відвідувач за замовчуванням не має квитка
    }

    // Метод для покупки квитка
    public void buyTicket() {
        this.hasTicket = true;
        System.out.println(name + " купив(ла) квиток.");
    }

    // Метод для перегляду тварини
    public void watchAnimal(Animal animal) {
        if (hasTicket) {
            System.out.println(name + " спостерігає за " + animal.getName() + ".");
        } else {
            System.out.println(name + " не може увійти, бо не має квитка.");
        }
    }

    // Геттери для інкапсуляції
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean hasTicket() {
        return hasTicket;
    }
}