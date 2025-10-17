import java.util.ArrayList;
import java.util.List;

public class Zoo {

    // Реалізація шаблону Одинак (Singleton)
    private static Zoo instance;

    // Колекції тепер замінені на менеджери (SRP та Low Coupling)
    private ZooAnimalManager animalManager;
    private ZooEmployeeManager employeeManager;
    private ZooVisitorManager visitorManager;

    // Вольєри залишаються тут, оскільки Zoo керує фізичною структурою
    private List<Enclosure> enclosures;

    // Ініціалізація менеджерів (теж сінгелтон тут працює)
    private Zoo() {
        this.animalManager = new ZooAnimalManager();
        this.employeeManager = new ZooEmployeeManager();
        this.visitorManager = new ZooVisitorManager();
        this.enclosures = new ArrayList<>();
    }

    // Публічний статичний метод для отримання єдиного екземпляра
    public static Zoo getInstance() {
        if (instance == null) {
            instance = new Zoo();
        }
        return instance;
    }

    // 4. Публічні ГЕТТЕРИ для доступу до менеджерів
    // Тепер увесь функціонал викликається через ці геттери
    public ZooAnimalManager getAnimalManager() {
        return animalManager;
    }

    public ZooEmployeeManager getEmployeeManager() {
        return employeeManager;
    }

    public ZooVisitorManager getVisitorManager() {
        return visitorManager;
    }

    // 5. Методи для керування вольєрами (залишаються, оскільки це структурний елемент Zoo)
    public void addEnclosure(Enclosure enclosure) {
        this.enclosures.add(enclosure);
        System.out.println("Вольєр '" + enclosure.getName() + "' був доданий до зоопарку.");
    }

    public void listAllEnclosures() {
        System.out.println("\n----- Список вольєрів у зоопарку: -----");
        for (Enclosure enclosure : enclosures) {
            enclosure.listAnimals();
        }
    }


}