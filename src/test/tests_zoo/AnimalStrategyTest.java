package tests_zoo;

import org.junit.jupiter.api.Test;
import zoo.zoo_animals.Lion;
import zoo.zoo_animals.Pike;
import zoo.zoo_animals.Crocodile;
import zoo.base_objects.Enclosure;
import zoo.base_objects.Visitor;
import zoo.zoo_managers.ZooAnimalManager;

import zoo.enums.Gender; // Використовуємо вашу структуру
import zoo_exceptions.InvalidDataException;
import zoo_exceptions.EnclosureViolationException;
import zoo_exceptions.DuplicateEntityException;
import zoo_exceptions.EntityNotFoundException;
import zoo_exceptions.PermissionDeniedException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class AnimalStrategyTest {

    // Тест 1: Перевірка логіки Unchecked Exception (InvalidDataException)
    @Test
    void test_InvalidAgeThrowsException() {
        assertThrows(InvalidDataException.class, () -> {
            new Lion("Злий", -1, Gender.MALE, 1);
        });
    }

    // Тест 2: Перевірка ініціалізації Шаблону Стратегія
    @Test
    void test_LionHasFeedingStrategy() {
        Lion simba = new Lion("Сімба", 5, Gender.MALE, 10);
        assertNotNull(simba);
        simba.performFeed(); // Перевіряємо, що Стратегія викликається без помилок
    }

    // Тест 3: Перевірка Поліморфізму (Polymorphism)
    @Test
    void test_PolymorphicSoundCall() {
        Lion simba = new Lion("Сімба", 5, Gender.MALE, 10);
        Pike pike = new Pike("Доррі", 3, Gender.FEMALE);

        // Перевіряємо, що виклик різних реалізацій makeSound() можливий (не кидає помилок)
        assertDoesNotThrow(() -> simba.makeSound());
        assertDoesNotThrow(() -> pike.makeSound());
    }

    // Тест 4: Перевірка Enclosure Violation (Неуспішний сценарій - DIP/OCP)
    @Test
    void test_EnclosureBlocksMammalInAquaticBiome() {
        Enclosure pikeTank = new Enclosure("Акваріум для щук", "Водний");
        Lion simba = new Lion("Сімба", 7, Gender.MALE, 16);

        // Очікуємо EnclosureViolationException (Ссавець у Водному вольєрі)
        assertThrows(EnclosureViolationException.class, () -> {
            pikeTank.addAnimal(simba);
        });
    }

    // Тест 5: Перевірка Enclosure Success (Успішний сценарій - DIP/OCP)
    @Test
    void test_EnclosureAllowsReptileInAquaticBiome() {
        Enclosure crocodileEnclosure = new Enclosure("Водосховище", "Водний");
        Crocodile croc = new Crocodile("Зубастик", 18, Gender.MALE, 4.8);

        // Очікуємо, що додавання пройде успішно (не кидає винятку)
        assertDoesNotThrow(() -> {
            crocodileEnclosure.addAnimal(croc);
        });
    }

    // Тест 6: Перевірка Duplicate Entity (SRP)
    @Test
    void test_ManagerBlocksDuplicateAnimal() {
        ZooAnimalManager manager = new ZooAnimalManager();
        Lion simba1 = new Lion("Сімба", 7, Gender.MALE, 16);
        Lion simba2 = new Lion("Сімба", 5, Gender.FEMALE, 10); // Дублікат імені

        manager.addAnimal(simba1);

        // Очікуємо DuplicateEntityException (Unchecked)
        assertThrows(DuplicateEntityException.class, () -> {
            manager.addAnimal(simba2);
        });
    }

    // Тест 7: Перевірка Entity Not Found (Checked Exception)
    @Test
    void test_ManagerThrowsEntityNotFound() {
        ZooAnimalManager manager = new ZooAnimalManager();

        // Очікуємо EntityNotFoundException (Checked Exception)
        assertThrows(EntityNotFoundException.class, () -> {
            manager.findAnimalByName("Неіснуючий");
        });
    }

    // Тест 8: Перевірка Permission Denied (Checked Exception)
    @Test
    void test_VisitorThrowsPermissionDenied() {
        Visitor petro = new Visitor("Петро", 21, Gender.MALE);
        Lion simba = new Lion("Сімба", 7, Gender.MALE, 16);

        // Очікуємо PermissionDeniedException (Checked Exception)
        assertThrows(PermissionDeniedException.class, () -> {
            petro.watchAnimal(simba);
        });
    }
}