package org.example;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class App {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            EmployeeService service = (EmployeeService) registry.lookup("EmployeeService");

            System.out.println("All Employees:");
            List<Employee> list = service.getAllEmployees();
            for (Employee e : list) {
                System.out.println(e);
            }

            System.out.println("\nAdding new employee:");
            boolean added = service.addEmployee(new Employee(3, "Mona"));
            System.out.println("Added: " + added);

            System.out.println("\nAfter addition:");
            service.getAllEmployees().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
