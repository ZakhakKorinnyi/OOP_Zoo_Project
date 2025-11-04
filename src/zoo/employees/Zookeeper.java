package zoo.employees;

import zoo.zoo_animals.Animal;
import zoo.zoo_animals.Employee;
import zoo_exceptions.AnimalCareException; // Імпорт для Checked Exception

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

    /**
     * Специфічний для доглядача метод годування тварини.
     * @param animal Тварина для годування.
     * @throws AnimalCareException Якщо тварина нездорова і годування заборонено (Checked Exception).
     */
    // Оголошуємо Checked Exception у сигнатурі методу
    public void feedAnimal(Animal animal) throws AnimalCareException {
        if (!animal.isHealthy()) {
            // Кидаємо виняток, якщо тварина хвора
            throw new AnimalCareException(getName() + " не може годувати " + animal.getName() +
                    ", оскільки вона нездорова. Потрібна консультація ветеринара.");
        }

        System.out.println(getName() + " годує тварину " + animal.getName() + ".");
        animal.eat();
    }
}