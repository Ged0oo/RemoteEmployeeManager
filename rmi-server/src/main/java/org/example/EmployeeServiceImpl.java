package org.example;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class EmployeeServiceImpl extends UnicastRemoteObject implements EmployeeService {
    private final Map<Integer, Employee> db = new HashMap<>();

    public EmployeeServiceImpl() throws RemoteException {
        super();
        db.put(1, new Employee(1, "Ali"));
        db.put(2, new Employee(2, "Nagy"));
    }

    @Override
    public boolean addEmployee(Employee e) {
        if (!db.containsKey(e.getId())) {
            db.put(e.getId(), e);
            return true;
        }
        return false;
    }

    @Override
    public Employee getEmployee(int id) {
        return db.get(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(db.values());
    }
}
