package zoo.employees;

import zoo.zoo_animals.Animal;
import zoo.zoo_animals.Employee;

// Клас zoo.employees.Zookeeper успадковує від zoo.zoo_animals.Employee
public class Zookeeper extends Employee {

    public Zookeeper(String name, double salary) {
        super(name, salary);
    }

    // Перевизначення методу performJob() для функцій саме доглядача тварин
    @Override
    public void performJob() {
        System.out.println(getName() + " годує тварин і прибирає вольєри.");
    }

    // Специфічний для доглядача метод
    public void feedAnimal(Animal animal) {
        System.out.println(getName() + " годує тварину " + animal.getName() + ".");
        animal.eat();
    }
}
