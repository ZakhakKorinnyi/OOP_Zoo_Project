package zoo.zoo_managers;

import zoo.zoo_animals.Employee;

import java.util.ArrayList;
import java.util.List;

public class ZooEmployeeManager {

    private List<Employee> employees;

    public ZooEmployeeManager() {
        this.employees = new ArrayList<>();
    }

    public void hireEmployee(Employee employee) {
        this.employees.add(employee);
        System.out.println(employee.getName() + " був(ла) найнятий(а) в зоопарк.");
    }

    public void runDailyRoutine() {
        System.out.println("\n----- Починається щоденна робота зоопарку! -----");
        for (Employee employee : employees) {
            employee.performJob();
        }
    }
}