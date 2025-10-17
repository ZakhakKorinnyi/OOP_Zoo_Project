public class Main {
    public static void main(String[] args) {

        // Створюємо об'єкти Zoo (тимчасово, поки не реалізовано Singleton)
        Zoo zoo = new Zoo();

        // Створюємо об'єкти тварин за допомогою Фабрики (AnimalFactory)
        System.out.println("----- Створення об'єктів за допомогою так званої Фабрики -----");

        // Створюємо Лева. Зверни увагу: останній параметр 10 (int) – це prideSize.
        Animal simba = AnimalFactory.createAnimal("lion", "Сімба", 7, Gender.MALE, 16);

        // Створюємо Колібрі. Останній параметр 60 (int) – це flightSpeed.
        Animal humming = AnimalFactory.createAnimal("hummingbird", "Вжик", 1, Gender.FEMALE, 57);

        // Створюємо Крокодила. Останній параметр 4.5 (double) – це lengthInMeters.
        Animal croc = AnimalFactory.createAnimal("crocodile", "Зубастик", 18, Gender.MALE, 4.8);

        System.out.println("-------------------------------------------------");

        // Додаються тварин до зоопарку
        zoo.addAnimal(simba);
        zoo.addAnimal(humming);
        zoo.addAnimal(croc);

        System.out.println();

        // Демонстрація поліморфізму
        zoo.makeAllAnimalsMakeSound();

        System.out.println();

        // Демонстрація специфічних методів, створених завдяки Наслідуванню
        ((Lion)simba).hunt(); // Приведення типу (cast), бо метод hunt() специфічний для Lion
        ((Hummingbird)humming).fly(); // Аналогічно
        ((Crocodile)croc).baskInSun(); // Аналогічно

    }
}