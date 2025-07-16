package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface EmployeeService extends Remote {
    boolean addEmployee(Employee emp, String username) throws RemoteException;
    boolean updateEmployee(Employee emp, String username) throws RemoteException;
    boolean deleteEmployee(int id, String username) throws RemoteException;
    Employee getEmployee(int id) throws RemoteException;
    List<Employee> getAllEmployees() throws RemoteException;
    boolean login(String username, String password) throws RemoteException;
    String getUserRole(String username) throws RemoteException;
}
