package zoo.zoo_managers;

import zoo.abstract_hierarchy.Animal; // Виправлений імпорт для Animal
import zoo_exceptions.DuplicateEntityException; // Імпорт DuplicateEntityException
import zoo_exceptions.EntityNotFoundException; // Імпорт EntityNotFoundException

import java.util.ArrayList;
import java.util.List;

public class ZooAnimalManager {

    private List<Animal> animals;

    public ZooAnimalManager() {
        this.animals = new ArrayList<>();
    }

    /**
     * Додає тварину до колекції, перевіряючи на дублікати.
     * @param animal Об'єкт тварини.
     */
    public void addAnimal(Animal animal) {
        // Інтеграція Unchecked Exception: DuplicateEntityException
        if (animals.stream().anyMatch(a -> a.getName().equals(animal.getName()))) {
            throw new DuplicateEntityException("Тварина з ім'ям " + animal.getName() + " вже існує. Додавання неможливе.");
        }

        this.animals.add(animal);
        System.out.println(animal.getName() + " був(ла) доданий(а) до колекції тварин.");
    }

    /**
     * Знаходить тварину за ім'ям.
     * @param name Ім'я тварини.
     * @return Об'єкт Animal.
     * @throws EntityNotFoundException Якщо тварину не знайдено (Checked Exception).
     */
    public Animal findAnimalByName(String name) throws EntityNotFoundException {
        // Інтеграція Checked Exception: EntityNotFoundException
        return animals.stream()
                .filter(a -> a.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Тварину з ім'ям '" + name + "' не знайдено."));
    }

    public void makeAllAnimalsMakeSound() {
        System.out.println("----- Зоопарк прокидається! Тварини починають гомоніти: -----");
        for (Animal animal : animals) {
            animal.makeSound();
        }
    }
}