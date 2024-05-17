import company.models.Manager;
import company.models.Worker;
import company.abstracts.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Worker worker1 = new Worker("Aleksandra Wójcik", 5300, 1, "2024-05-17", "Worker");
        Worker worker2 = new Worker("Adam Nowak", 4200, 2, "2022-11-01", "Worker");
        Worker worker3 = new Worker("Kamil Kowalski", 3200, 2, "2019-04-01", "Worker");
        Worker worker4 = new Worker("Oliwia Roza", 5100, 4, "2023-05-01", "Worker");
        Manager manager1 = new Manager("Kuba Wilk", 2700, 3, "2003-01-01", "Manager");
        Manager manager2 = new Manager("Jan Kowalski", 3000, 2, "2005-06-01", "Manager");

        List<Employee> employees = new ArrayList<>();
        employees.add(worker1);
        employees.add(worker2);
        employees.add(worker3);
        employees.add(worker4);
        employees.add(manager1);
        employees.add(manager2);


        double totalSalary = employees.stream().mapToDouble(Employee::getSalary).sum();
        System.out.println("Całkowita pensja wszystkich pracowników: " + totalSalary);

   
        double totalManagerSalary = employees.stream()
                .filter(employee -> employee instanceof Manager)
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.println("Całkowita pensja wszystkich Managerów: " + totalManagerSalary);

        
        double totalWorkerSalary = employees.stream()
                .filter(employee -> employee instanceof Worker)
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.println("Całkowita pensja wszystkich Workerów: " + totalWorkerSalary);

    
        Map<Integer, List<Employee>> idMap = new HashMap<>();
        for (Employee employee : employees) {
            idMap.computeIfAbsent(employee.hashCode(), k -> new ArrayList<>()).add(employee);
        }

        idMap.entrySet().stream()
                .filter(entry -> entry.getValue().size() > 1)
                .forEach(entry -> {
                    System.out.println("Employees with the same ID: ");
                    entry.getValue().forEach(employee -> {
                        System.out.println("- " + employee.getName() + " (ID: " + employee.hashCode() +
                                ", Position: " + employee.getPosition() + ", Hire date: " + employee.getHireDate() +
                                ", Salary: " + employee.getSalary() + ")");
                    });
                });
    }
}