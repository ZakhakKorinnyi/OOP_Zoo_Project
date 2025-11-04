package zoo.employees;

import zoo.base_objects.Animal;
import zoo.base_objects.Employee;
import zoo_exceptions.AnimalCareException; // Імпорт для Checked Exception

// Клас zoo.employees.Veterinarian успадковує від zoo.base_objects.Employee
public class Veterinarian extends Employee {

    public Veterinarian(String name, double salary) {
        super(name, salary);
    }

    // Перевизначення методу performJob() відповідно до завдань ветеринара
    @Override
    public void performJob() {
        System.out.println(getName() + " проводить огляд здоров'я тварин.");
    }

    /**
     * Специфічний для ветеринара метод лікування тварини.
     * @param animal Тварина для лікування.
     * @throws AnimalCareException Якщо тварина здорова і лікування не потрібне (Checked Exception).
     */
    // Оголошуємо Checked Exception у сигнатурі методу
    public void healAnimal(Animal animal) throws AnimalCareException {
        if (animal.isHealthy()) {
            // Кидаємо виняток, якщо тварина здорова
            throw new AnimalCareException(animal.getName() + " здорова. Лікування не потрібне.");
        } else {
            System.out.println(getName() + " лікує " + animal.getName() + ".");
            animal.treat();
        }
    }
}