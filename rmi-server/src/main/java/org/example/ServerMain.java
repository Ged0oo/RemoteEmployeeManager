import org.example.EmployeeServiceImpl;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.net.InetAddress;

public class ServerMain {
    public static void main(String[] args) {
        try {
            String host = InetAddress.getLocalHost().getHostAddress();
            System.setProperty("java.rmi.server.hostname", host); 

            EmployeeServiceImpl service = new EmployeeServiceImpl();

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("EmployeeService", service);

            System.out.println("RMI Server is running at " + host);

            synchronized (ServerMain.class) {
                ServerMain.class.wait();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
