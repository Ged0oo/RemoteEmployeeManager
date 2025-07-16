package org.example;
import org.example.EmployeeServiceImpl;
import org.example.EmployeeService;
import org.example.Employee;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerMain {
    public static void main(String[] args) {
        try {
            EmployeeServiceImpl service = new EmployeeServiceImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("EmployeeService", service);
            System.out.println("RMI Server is running...");

            // Prevent the main thread from exiting
            synchronized (ServerMain.class) {
                ServerMain.class.wait(); // waits forever
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
