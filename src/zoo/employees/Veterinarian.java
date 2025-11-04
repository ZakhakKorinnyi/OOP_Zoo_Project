package zoo.employees;

import zoo.zoo_animals.Animal;
import zoo.zoo_animals.Employee;

// Клас zoo.employees.Veterinarian успадковує від zoo.zoo_animals.Employee
public class Veterinarian extends Employee {

    public Veterinarian(String name, double salary) {
        super(name, salary);
    }

    // Перевизначення методу performJob() відповідно до завдань ветиринатра
    @Override
    public void performJob() {
        System.out.println(getName() + " проводить огляд здоров'я тварин.");
    }

    // Специфічний для ветеринара метод
    public void healAnimal(Animal animal) {
        if (!animal.isHealthy()) {
            System.out.println(getName() + " лікує " + animal.getName() + ".");
            animal.treat();
        } else {
            System.out.println(animal.getName() + " вже здорова, лікування не потрібне.");
        }
    }
}