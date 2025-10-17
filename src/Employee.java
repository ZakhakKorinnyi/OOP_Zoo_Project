import java.util.UUID;

// Абстрактний клас, що є базовим для всіх працівників
public abstract class Employee {

    private String name;
    private final String employeeId; // Використання final для того щоб ідентифікатор був незмінний
    private double salary;
    private EmployeeStatus status; // Використання перерахування Enum

    // Конструктор
    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.employeeId = UUID.randomUUID().toString(); // Унікальний ID,що генерується автоматично
        this.status = EmployeeStatus.ACTIVE; // За замовчуванням працівник активний
    }

    // Абстрактний метод, де демонструється поліморфізм
    public abstract void performJob();

    // Методи, що є загальними для всіх працівників
    public void receiveSalary() {
        System.out.println(name + " отримав(ла) зарплату в розмірі " + salary + ".");
    }

    public void takeVacation() {
        this.status = EmployeeStatus.ON_VACATION;
        System.out.println(name + " пішов(ла) у відпустку.");
    }

    // Геттери для доступу до приватних полів
    public String getName() {
        return name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public EmployeeStatus getStatus() {
        return status;
    }
}