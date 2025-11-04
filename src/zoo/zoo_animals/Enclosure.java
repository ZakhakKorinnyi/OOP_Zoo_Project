package zoo.zoo_animals;

import java.util.ArrayList;
import java.util.List;

public class Enclosure {

    private String name;
    private String biome; // Наприклад, "Савана", "Джунглі"
    private List<Animal> animals;

    public Enclosure(String name, String biome) {
        this.name = name;
        this.biome = biome;
        this.animals = new ArrayList<>();
    }

    // Метод для додавання тварини у вольєр
    public void addAnimal(Animal animal) {
        this.animals.add(animal);
        System.out.println(animal.getName() + " був(ла) доданий(а) до вольєру " + name + ".");
    }

    // Метод для виведення списку тварин у вольєрі
    // Демонстрація принципу "Інформаційний експерт"
    public void listAnimals() {
        System.out.println("Тварини у вольєрі " + name + " (" + biome + "):");
        if (animals.isEmpty()) {
            System.out.println("   (Пусто)");
        } else {
            for (Animal animal : animals) {
                System.out.println("   - " + animal.getName() + " (" + animal.getClass().getSimpleName() + ")");
            }
        }
    }
    public String getName() {
        return name;
    }
}