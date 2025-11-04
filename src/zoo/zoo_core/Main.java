package zoo.zoo_core;

import zoo.employees.Veterinarian;
import zoo.employees.Zookeeper;
import zoo.zoo_animals.Animal;
import zoo.zoo_animals.Enclosure;
import zoo.zoo_animals.Gender;
import zoo.zoo_animals.Visitor;
import zoo.zoo_patterns.AnimalFactory;
import zoo_exceptions.PermissionDeniedException;
import zoo_exceptions.AnimalCareException;

public class Main {
    public static void main(String[] args) {

        // Отримується єдиний екземпляр Зоопарку за допомогою Singleton
        Zoo zoo = Zoo.getInstance();

        // 1. Створення вольєрів (ДОДАНО ВОЛЬЄРИ ДЛЯ БЕЗХРЕБЕТНИХ)
        Enclosure lionEnclosure = new Enclosure("Вольєр для левів", "Савана");
        Enclosure birdEnclosure = new Enclosure("Пташник", "Тропіки");
        Enclosure crocodileEnclosure = new Enclosure("Водосховище для крокодилів", "Водний");
        Enclosure frogPond = new Enclosure("Ставок для жаб", "Водно-болотний");
        Enclosure pikeTank = new Enclosure("Акваріум для щук", "Водний");

        // НОВІ ВОЛЬЄРИ ДЛЯ БЕЗХРЕБЕТНИХ
        Enclosure insectarium = new Enclosure("Інсектаріум", "Сухий");
        Enclosure butterflyGarden = new Enclosure("Сад метеликів", "Тропіки");

        // 2. Створення об'єктів тварин за допомогою Фабрики (ТВОЇ ДАНІ ТА НОВІ ТИПИ)
        Animal simba = AnimalFactory.createAnimal("lion", "Сімба", 7, Gender.MALE, 16);
        Animal humming = AnimalFactory.createAnimal("hummingbird", "Вжик", 1, Gender.FEMALE, 57);
        Animal croc = AnimalFactory.createAnimal("crocodile", "Зубастик", 18, Gender.MALE, 4.8);
        Animal kermit = AnimalFactory.createAnimal("frog", "Квак", 1, Gender.MALE);
        Animal jaws = AnimalFactory.createAnimal("pike", "Доррі", 3, Gender.FEMALE);

        // НОВІ БЕЗХРЕБЕТНІ
        Animal spidey = AnimalFactory.createAnimal("spider", "Восьминіг", 1, Gender.FEMALE);
        Animal monarch = AnimalFactory.createAnimal("butterfly", "Веселка", 0, Gender.FEMALE); // Вік 0 для комах

        // 3. Додаються тварини у вольєри (Агрегація)
        lionEnclosure.addAnimal(simba);
        birdEnclosure.addAnimal(humming);
        crocodileEnclosure.addAnimal(croc);
        frogPond.addAnimal(kermit);
        pikeTank.addAnimal(jaws);

        // ДОДАВАННЯ БЕЗХРЕБЕТНИХ
        insectarium.addAnimal(spidey);
        butterflyGarden.addAnimal(monarch);

        // 4. Додаються вольєри до зоопарку
        zoo.addEnclosure(lionEnclosure);
        zoo.addEnclosure(birdEnclosure);
        zoo.addEnclosure(crocodileEnclosure);
        zoo.addEnclosure(frogPond);
        zoo.addEnclosure(pikeTank);

        // ДОДАВАННЯ НОВИХ ВОЛЬЄРІВ
        zoo.addEnclosure(insectarium);
        zoo.addEnclosure(butterflyGarden);

        System.out.println();

        // Демонстрація GRASP "Інформаційний експерт" та Агрегації
        zoo.listAllEnclosures();

        // Створюються та наймаються працівників (ТВОЇ ДАНІ)
        Zookeeper john = new Zookeeper("Віктор", 12200.0);
        Veterinarian mary = new Veterinarian("Артем", 18000.0);

        // Менеджер працівників
        zoo.getEmployeeManager().hireEmployee(john);
        zoo.getEmployeeManager().hireEmployee(mary);

        // 8. Створюються та додаються відвідувачів (ТВОЇ ДАНІ)
        Visitor visitor1 = new Visitor("Вікторія", 20, Gender.FEMALE);
        Visitor visitor2 = new Visitor("Петро", 21, Gender.MALE);

        // Менеджер відвідувачів
        zoo.getVisitorManager().addVisitor(visitor1);
        zoo.getVisitorManager().addVisitor(visitor2);

        System.out.println();

        // Менеджер працівників використовується для щоденної роботи
        zoo.getEmployeeManager().runDailyRoutine();

        // 9. Приклади взаємодії з обробкою Checked Exceptions
        System.out.println("\n----- Приклади взаємодії та обробка винятків -----");

        // --- СЦЕНАРІЙ 1: Доглядач (AnimalCareException) ---
        simba.getSick();
        System.out.println(simba.getName() + " почувається зле.");

        try {
            john.feedAnimal(simba);
        } catch (AnimalCareException e) {
            System.err.println("[ОБРОБЛЕНО] Помилка догляду: " + e.getMessage());
        }

        try {
            mary.healAnimal(simba);
        } catch (AnimalCareException e) {
            System.err.println("[ОБРОБЛЕНО] Помилка догляду: " + e.getMessage());
        }

        // --- СЦЕНАРІЙ 2: Відвідувачі (PermissionDeniedException) ---
        System.out.println();
        visitor1.buyTicket();

        try {
            visitor1.watchAnimal(croc);
        } catch (PermissionDeniedException e) {
            System.err.println("[ОБРОБЛЕНО] Помилка доступу: " + e.getMessage());
        }

        try {
            visitor2.watchAnimal(simba);
        } catch (PermissionDeniedException e) {
            System.err.println("[ОБРОБЛЕНО] Помилка доступу: " + e.getMessage());
        }

        System.out.println("\n----- Програма завершила роботу, обробивши всі винятки. -----");
    }
}