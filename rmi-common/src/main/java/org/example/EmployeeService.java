package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface EmployeeService extends Remote {
    boolean addEmployee(Employee employee) throws RemoteException;
    Employee getEmployee(int id) throws RemoteException;
    List<Employee> getAllEmployees() throws RemoteException;
}
