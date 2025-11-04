package zoo.zoo_animals;

import zoo_exceptions.EnclosureViolationException; // Імпорт для порушень правил
import zoo_exceptions.DuplicateEntityException; // Імпорт для дублікатів

import java.util.ArrayList;
import java.util.List;

public class Enclosure {

    private String name;
    private String biome; // Наприклад, "Савана", "Джунглі"
    private List<Animal> animals;

    // Встановлюємо максимальну місткість для прикладу
    private final int MAX_CAPACITY = 3;

    public Enclosure(String name, String biome) {
        this.name = name;
        this.biome = biome;
        this.animals = new ArrayList<>();
    }

    /**
     * Метод для додавання тварини у вольєр з перевірками.
     * @param animal Об'єкт тварини, який потрібно додати.
     */
    public void addAnimal(Animal animal) {

        // 1. Перевірка на дублікати (DuplicateEntityException)
        if (animals.stream().anyMatch(a -> a.getName().equals(animal.getName()))) {
            throw new DuplicateEntityException("Тварина з ім'ям " + animal.getName() + " вже знаходиться у вольєрі " + name + ".");
        }

        // 2. Перевірка на переповнення (EnclosureViolationException)
        if (animals.size() >= MAX_CAPACITY) {
            throw new EnclosureViolationException("Вольєр '" + name + "' (біом: " + biome + ") переповнений. Максимум: " + MAX_CAPACITY + " тварини.");
        }

        // 3. Перевірка на невідповідність біому (EnclosureViolationException)
        String species = animal.getClass().getSimpleName();

        // Приклад правила: Крокодили (Reptile) можуть жити лише у водному біомі
        if (species.equals("Crocodile") && !this.biome.contains("Вод")) {
            throw new EnclosureViolationException("Крокодил не може бути поселений у біом: " + this.biome);
        }

        // Приклад правила: Колібрі (Bird) не можуть жити в Савані
        if (species.equals("Hummingbird") && this.biome.contains("Савана")) {
            throw new EnclosureViolationException("Колібрі не може жити у біомі: " + this.biome);
        }

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