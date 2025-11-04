package zoo.zoo_core;

import zoo.employees.Veterinarian;
import zoo.employees.Zookeeper;
import zoo.zoo_animals.Animal;
import zoo.zoo_animals.Enclosure;
import zoo.zoo_animals.Gender;
import zoo.zoo_animals.Visitor;
import zoo.zoo_patterns.AnimalFactory;
// Додані імпорти для Checked Exceptions, які тепер потрібно обробляти:
import zoo_exceptions.PermissionDeniedException;
import zoo_exceptions.AnimalCareException;

public class Main {
    public static void main(String[] args) {

        // Отримується єдиний екземпляр Зоопарку за допомогою Singleton
        Zoo zoo = Zoo.getInstance();

        // Створюються вольєри
        Enclosure lionEnclosure = new Enclosure("Вольєр для левів", "Савана");
        Enclosure birdEnclosure = new Enclosure("Пташник", "Тропіки");
        Enclosure crocodileEnclosure = new Enclosure("Водосховище для крокодилів", "Водний"); // Змінено біом на "Водний" для Croc

        // Створюються об'єкти тварин за допомогою Фабрики (ТВОЇ ДАНІ)
        Animal simba = AnimalFactory.createAnimal("lion", "Сімба", 7, Gender.MALE, 16);
        Animal humming = AnimalFactory.createAnimal("hummingbird", "Вжик", 1, Gender.FEMALE, 57);
        Animal croc = AnimalFactory.createAnimal("crocodile", "Зубастик", 18, Gender.MALE, 4.8);

        // Додаються тварин у вольєри (Агрегація)
        lionEnclosure.addAnimal(simba);
        birdEnclosure.addAnimal(humming);
        crocodileEnclosure.addAnimal(croc);

        // Додаються вольєри до зоопарку
        zoo.addEnclosure(lionEnclosure);
        zoo.addEnclosure(birdEnclosure);
        zoo.addEnclosure(crocodileEnclosure);

        System.out.println();

        // Демонстрація GRASP "Інформаційний експерт" та Агрегації
        zoo.listAllEnclosures();

        // Створюються та наймаються працівників (ТВОЇ ДАНІ)
        Zookeeper john = new Zookeeper("Віктор", 12200.0);
        Veterinarian mary = new Veterinarian("Артем", 18000.0);

        // Менеджер працівників
        zoo.getEmployeeManager().hireEmployee(john);
        zoo.getEmployeeManager().hireEmployee(mary); // Виклик через менеджер

        // 8. Створюються та додаються відвідувачів (ТВОЇ ДАНІ)
        Visitor visitor1 = new Visitor("Вікторія", 20, Gender.FEMALE); // Купить квиток
        Visitor visitor2 = new Visitor("Петро", 21, Gender.MALE); // Не купить квиток

        // Менеджер відвідувачів
        zoo.getVisitorManager().addVisitor(visitor1);
        zoo.getVisitorManager().addVisitor(visitor2);

        System.out.println();

        // Менеджер працівників використовується для щоденної роботи
        zoo.getEmployeeManager().runDailyRoutine();

        // 9. Приклади взаємодії з обробкою Checked Exceptions
        System.out.println("\n----- Приклади взаємодії та обробка винятків -----");

        // --- СЦЕНАРІЙ 1: Доглядач (AnimalCareException) ---
        simba.getSick(); // Імітуємо хворобу Сімби
        System.out.println(simba.getName() + " почувається зле.");

        try {
            // Невдалий виклик: Віктор не може годувати хвору Сімбу (викидає виняток)
            john.feedAnimal(simba);
        } catch (AnimalCareException e) {
            System.err.println("[ОБРОБЛЕНО] Помилка догляду: " + e.getMessage());
        }

        try {
            // Успішний виклик: Артем лікує хвору Сімбу
            mary.healAnimal(simba);
            // Якщо викликати mary.healAnimal(simba) ще раз, він викине виняток
        } catch (AnimalCareException e) {
            System.err.println("[ОБРОБЛЕНО] Помилка догляду: " + e.getMessage());
        }

        // --- СЦЕНАРІЙ 2: Відвідувачі (PermissionDeniedException) ---
        System.out.println();
        visitor1.buyTicket(); // Купує квиток

        try {
            // Успішний виклик: Вікторія має квиток
            visitor1.watchAnimal(croc);
        } catch (PermissionDeniedException e) {
            System.err.println("[ОБРОБЛЕНО] Помилка доступу: " + e.getMessage());
        }

        try {
            // Невдалий виклик: Петро не має квитка (викидає виняток)
            visitor2.watchAnimal(simba);
        } catch (PermissionDeniedException e) {
            // Обов'язкова обробка винятку
            System.err.println("[ОБРОБЛЕНО] Помилка доступу: " + e.getMessage());
        }

        System.out.println("\n----- Програма завершила роботу, обробивши всі винятки. -----");
    }
}