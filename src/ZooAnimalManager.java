import java.util.ArrayList;
import java.util.List;

public class ZooAnimalManager {

    private List<Animal> animals;

    public ZooAnimalManager() {
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        this.animals.add(animal);
        System.out.println(animal.getName() + " був(ла) доданий(а) до колекції тварин.");
    }

    public void makeAllAnimalsMakeSound() {
        System.out.println("----- Зоопарк прокидається! Тварини починають шуміти: -----");
        for (Animal animal : animals) {
            animal.makeSound();
        }
    }
}