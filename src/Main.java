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

        // Додаються тварин у відповідні вольєри (Агрегація)
        lionEnclosure.addAnimal(simba);
        birdEnclosure.addAnimal(humming);
        crocodileEnclosure.addAnimal(croc);

        // 5. Додаються вольєри до зоопарку
        zoo.addEnclosure(lionEnclosure);
        zoo.addEnclosure(birdEnclosure);
        zoo.addEnclosure(crocodileEnclosure);

        System.out.println();

        // 6. Демонстрація GRASP "Інформаційний експерт" та Агрегації
        zoo.listAllEnclosures();

        // 7. Створюються та наймаюються працівники
        Zookeeper john = new Zookeeper("Віктор", 12200.0);
        Veterinarian mary = new Veterinarian("Артем", 18000.0);
        zoo.hireEmployee(john);
        zoo.hireEmployee(mary);

        // 8. Створюються та додаються відвідувачі
        Visitor visitor1 = new Visitor("Вікторія", 20, Gender.FEMALE);
        Visitor visitor2 = new Visitor("Петро", 21, Gender.MALE);
        zoo.addVisitor(visitor1);
        zoo.addVisitor(visitor2);

        System.out.println();

        // 9. Демонстрація поліморфізму працівників
        zoo.runDailyRoutine();

        System.out.println();

        // 10. Приклади взаємодії
        john.feedAnimal(simba);
        mary.healAnimal(simba);

        System.out.println();

        visitor1.buyTicket();
        visitor1.watchAnimal(croc);



    }
}