package org.example;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerApp {
    public static void main(String[] args) {
        try {
            EmployeeServiceImpl service = new EmployeeServiceImpl();

            System.setProperty("java.rmi.server.hostname", "192.168.1.5");
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("EmployeeService", service);

            System.out.println("EmployeeService bound to RMI registry.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
