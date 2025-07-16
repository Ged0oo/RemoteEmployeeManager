package org.example;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        try {
            String serverIp = "127.0.0.1";
            Registry registry = LocateRegistry.getRegistry(serverIp, 1099);
            EmployeeService service = (EmployeeService) registry.lookup("EmployeeService");
            Scanner scanner = new Scanner(System.in);

            System.out.print("Username: ");
            String username = scanner.nextLine();

            System.out.print("Password: ");
            String password = scanner.nextLine();

            if (!service.login(username, password)) {
                System.out.println("Login failed.");
                return;
            }

            String role = service.getUserRole(username);
            System.out.println("Login successful! Role: " + role);

            while (true) {
                System.out.println("\nOptions:");
                System.out.println("1. Get All Employees");
                System.out.println("2. Get Employee by ID");
                System.out.println("3. Add Employee");
                System.out.println("4. Update Employee");
                System.out.println("5. Delete Employee");
                System.out.println("6. Exit");
                System.out.print("Choice: ");
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1 -> {
                        List<Employee> list = service.getAllEmployees();
                        list.forEach(System.out::println);
                    }
                    case 2 -> {
                        System.out.print("Enter ID: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        System.out.println(service.getEmployee(id));
                    }
                    case 3 -> {
                        System.out.print("Enter ID: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        boolean added = service.addEmployee(new Employee(id, name), username);
                        System.out.println("Added: " + added);
                    }
                    case 4 -> {
                        System.out.print("Enter ID: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter New Name: ");
                        String name = scanner.nextLine();
                        boolean updated = service.updateEmployee(new Employee(id, name), username);
                        System.out.println("Updated: " + updated);
                    }
                    case 5 -> {
                        System.out.print("Enter ID to delete: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        boolean deleted = service.deleteEmployee(id, username);
                        System.out.println("Deleted: " + deleted);
                    }
                    case 6 -> {
                        System.out.println("Bye!");
                        return;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
