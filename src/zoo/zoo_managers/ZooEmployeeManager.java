package zoo.zoo_managers;

import zoo.base_objects.Employee; // Виправлений імпорт для Employee (вважаємо, що він у zoo_entities)
import zoo_exceptions.DuplicateEntityException;
import zoo_exceptions.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class ZooEmployeeManager {

    private List<Employee> employees;

    public ZooEmployeeManager() {
        this.employees = new ArrayList<>();
    }

    /**
     * Найм працівника, перевіряючи на дублікати за ID.
     * @param employee Об'єкт працівника.
     */
    public void hireEmployee(Employee employee) {
        // Інтеграція Unchecked Exception: DuplicateEntityException
        if (employees.stream().anyMatch(e -> e.getEmployeeId().equals(employee.getEmployeeId()))) {
            throw new DuplicateEntityException("Працівник з ID " + employee.getEmployeeId() + " вже існує. Найм неможливий.");
        }

        this.employees.add(employee);
        System.out.println(employee.getName() + " був(ла) найнятий(а) в зоопарк.");
    }

    /**
     * Знаходить працівника за унікальним ID.
     * @param id Унікальний ідентифікатор працівника.
     * @return Об'єкт Employee.
     * @throws EntityNotFoundException Якщо працівника не знайдено (Checked Exception).
     */
    public Employee findEmployeeById(String id) throws EntityNotFoundException {
        // Інтеграція Checked Exception: EntityNotFoundException
        return employees.stream()
                .filter(e -> e.getEmployeeId().equals(id))
                .findFirst()
                .orElseThrow(() -> new EntityNotFoundException("Працівника з ID '" + id + "' не знайдено."));
    }

    public void runDailyRoutine() {
        System.out.println("\n----- Починається щоденна робота зоопарку! -----");
        for (Employee employee : employees) {
            employee.performJob();
        }
    }
}