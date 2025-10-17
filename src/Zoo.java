import java.util.ArrayList;
import java.util.List;

public class Zoo {

    // Приватне статичне поле, що містить єдиний екземпляр (тобто Singleton)
    private static Zoo instance;

    // Оголошення всіх колекцій
    private List<Animal> animals;
    private List<Employee> employees;
    private List<Visitor> visitors;
    private List<Enclosure> enclosures;


    // Приватний коструктор, де ви проходить ініціалізація усіх колекцій (через сінгелтон)
    private Zoo() {
        this.animals = new ArrayList<>();
        this.employees = new ArrayList<>(); // Додано
        this.visitors = new ArrayList<>(); // Додано
        this.enclosures = new ArrayList<>(); // Додано
    }

    // Публічний статичний метод для отримання єдиного екземпляра
    public static Zoo getInstance() {
        if (instance == null) {
            instance = new Zoo();
        }
        return instance;
    }

    // Методи для керування тваринами
    public void addAnimal(Animal animal) {
        this.animals.add(animal);
        System.out.println(animal.getName() + " був(ла) доданий(а) до зоопарку.");
    }

    public void makeAllAnimalsMakeSound() {
        System.out.println("----- Зоопарк прокидається! Тварини починають гомоніти: -----");
        for (Animal animal : animals) {
            animal.makeSound();
        }
    }

    // Методи для керування працівниками
    public void hireEmployee(Employee employee) {
        this.employees.add(employee);
        System.out.println(employee.getName() + " був(ла) найнятий(а) в зоопарк.");
    }

    public void runDailyRoutine() {
        System.out.println("\n----- Починається щоденна робота зоопарку! -----");
        for (Employee employee : employees) {
            employee.performJob();
        }
    }

    // Методи для керування відвідувачами
    public void addVisitor(Visitor visitor) {
        this.visitors.add(visitor);
        System.out.println(visitor.getName() + " прибув(ла) до зоопарку.");
    }

    // Методи для керування вольєрами
    public void addEnclosure(Enclosure enclosure) {
        this.enclosures.add(enclosure);
        // Тут може знадобитися getEnclosure, якщо ти не реалізував Enclosure.java
        System.out.println("Вольєр '" + enclosure.getName() + "' був доданий до зоопарку.");
    }

    public void listAllEnclosures() {
        System.out.println("\n----- Список вольєрів у зоопарку: -----");
        for (Enclosure enclosure : enclosures) {
            enclosure.listAnimals(); // Викликаємо метод у класі Enclosure
        }
    }
}