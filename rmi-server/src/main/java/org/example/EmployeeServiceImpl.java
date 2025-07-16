package org.example;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class EmployeeServiceImpl extends UnicastRemoteObject implements EmployeeService {

    private final Map<Integer, Employee> db = new HashMap<>();
    private final Map<String, String> users = new HashMap<>();
    private final Map<String, String> roles = new HashMap<>();

    public EmployeeServiceImpl() throws RemoteException {
        db.put(1, new Employee(1, "Ali"));
        db.put(2, new Employee(2, "Nagy"));

        users.put("admin", "admin123");
        users.put("user", "user123");

        roles.put("admin", "admin");
        roles.put("user", "viewer");
    }

    @Override
    public boolean addEmployee(Employee e, String username) {
        if (!isAdmin(username)) return false;
        if (!db.containsKey(e.getId())) {
            db.put(e.getId(), e);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateEmployee(Employee e, String username) {
        if (!isAdmin(username)) return false;
        if (db.containsKey(e.getId())) {
            db.put(e.getId(), e);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteEmployee(int id, String username) {
        if (!isAdmin(username)) return false;
        return db.remove(id) != null;
    }

    @Override
    public Employee getEmployee(int id) {
        return db.get(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(db.values());
    }

    @Override
    public boolean login(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }

    @Override
    public String getUserRole(String username) {
        return roles.getOrDefault(username, "guest");
    }

    private boolean isAdmin(String username) {
        return "admin".equals(roles.get(username));
    }
}
