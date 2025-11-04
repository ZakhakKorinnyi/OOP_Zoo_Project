package zoo.zoo_animals;

import zoo_exceptions.EnclosureViolationException;
import zoo_exceptions.DuplicateEntityException;

import java.util.ArrayList;
import java.util.List;

public class Enclosure {

    private String name;
    private String biome; // Наприклад, "Савана", "Джунглі"
    private List<Animal> animals;

    private final int MAX_CAPACITY = 3;

    public Enclosure(String name, String biome) {
        this.name = name;
        this.biome = biome;
        this.animals = new ArrayList<>();
    }

    /**
     * Метод для додавання тварини у вольєр з перевірками.
     * Використовує 'instanceof' для перевірки біологічного класу (DIP).
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

        // 3. ПЕРЕВІРКА ВІДПОВІДНОСТІ БІОМУ (DIP та OCP)

        // Перевіряємо, до якого АБСТРАКТНОГО КЛАСУ належить тварина

        // Рептилії (Crocodile) - вимагають водного біому
        if (animal instanceof Reptile && !this.biome.contains("Вод")) {
            throw new EnclosureViolationException("Плазуни (Reptile) не можуть бути поселені у біом: " + this.biome);
        }

        // Риби (Pike) - вимагають водного біому
        if (animal instanceof Fish && !this.biome.contains("Вод")) {
            throw new EnclosureViolationException("Риби (Fish) не можуть бути поселені у біом: " + this.biome);
        }

        // Птахи (Hummingbird) - не можуть жити в сухій Савані
        if (animal instanceof Bird && this.biome.contains("Савана")) {
            throw new EnclosureViolationException("Птахи (Bird) не можуть жити у біомі: " + this.biome);
        }

        // Ссавці (Mammal) - не можуть жити у Водному вольєрі
        if (animal instanceof Mammal && this.biome.contains("Вод")) {
            throw new EnclosureViolationException("Ссавці (Mammal) не можуть бути поселені у Водний біом.");
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
                // Виводимо також Phylum
                System.out.println("   - " + animal.getName() + " (" + animal.getClass().getSimpleName() + " - " + animal.getPhylum() + ")");
            }
        }
    }
    public String getName() {
        return name;
    }
}