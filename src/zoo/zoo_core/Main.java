package zoo.zoo_core;

import zoo.employees.Veterinarian;
import zoo.employees.Zookeeper;
import zoo.zoo_animals.Animal;
import zoo.zoo_animals.Enclosure;
import zoo.zoo_animals.Gender;
import zoo.zoo_animals.Visitor;
import zoo.zoo_patterns.AnimalFactory;

public class Main {
    public static void main(String[] args) {

        // Отримується єдиний екземпляр Зоопарку за допомогою Singleton
        Zoo zoo = Zoo.getInstance();

        // Створюються вольєри
        Enclosure lionEnclosure = new Enclosure("Вольєр для левів", "Савана");
        Enclosure birdEnclosure = new Enclosure("Пташник", "Тропіки");
        Enclosure crocodileEnclosure = new Enclosure("Водосховище для крокодилів", "Річковий");

        // Створюються об'єкти тварин за допомогою Фабрики
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

        // Створюються та наймаються працівників
        Zookeeper john = new Zookeeper("Віктор", 12200.0);
        Veterinarian mary = new Veterinarian("Артем", 18000.0);

        // Менеджер працівників
        zoo.getEmployeeManager().hireEmployee(john);
        zoo.getEmployeeManager().hireEmployee(mary); // Виклик через менеджер

        // 8. Створюються та додаються відвідувачів
        Visitor visitor1 = new Visitor("Вікторія", 20, Gender.FEMALE);
        Visitor visitor2 = new Visitor("Петро", 21, Gender.MALE);

        // Менеджер відвідувачів
        zoo.getVisitorManager().addVisitor(visitor1);
        zoo.getVisitorManager().addVisitor(visitor2);

        System.out.println();

        // Менеджер працівників використовується для щоденної роботи
        zoo.getEmployeeManager().runDailyRoutine();

        System.out.println();

        // 9. Приклади взаємодії
        john.feedAnimal(simba);
        mary.healAnimal(simba);

        System.out.println();

        visitor1.buyTicket();
        visitor1.watchAnimal(croc);


    }
}