# RemoteEmployeeManager

A modular Java RMI-based system for managing employee records remotely with support for login, role-based access, and CRUD operations. This project is built using Maven and includes three modules: `rmi-common`, `rmi-server`, and `rmi-client`.

---

## Project Structure

```
RemoteEmployeeManager/
├── rmi-common/
│   └── Contains shared interfaces, models, and utility classes.
│
├── rmi-server/
│   └── Contains server implementation and entry point (`ServerApp`).
│
├── rmi-client/
│   └── Contains client logic and interactive CLI (`App`).
│
├── run-server.sh
├── run-client.sh
└── README.md
```

---

## Features

- Remote Method Invocation (RMI)
- Employee login & role-based access (admin/user)
- CRUD operations on employee data
- Modular Maven setup
- Platform-independent CLI client

---

## Requirements

- Java 17 or higher
- Maven 3.x
- Localhost or LAN for RMI registry

---

## Build Instructions

From the root directory:

```bash
mvn clean install
```

This will compile and build all three modules (`rmi-common`, `rmi-server`, `rmi-client`) and install the jars into your local Maven repository.

---

## Running the Application

### 1. Start the RMI Server

```bash
./run-server.sh
```

This launches the server on `localhost` (127.0.0.1) and binds the `EmployeeService` to the RMI registry.

### 2. Start the RMI Client

```bash
./run-client.sh
```

This will prompt the user for a username and password, validate it via the server, and then provide options to manage employees.

---

## Default Login Credentials

| Username | Password | Role  |
|----------|----------|-------|
| admin    | admin    | ADMIN |
| user     | user     | USER  |

---

## CRUD Operations

- List all employees
- Fetch employee by ID
- Add employee (admin only)
- Update employee (admin only)
- Delete employee (admin only)

---

## Example Interaction

```bash
Username: admin
Password: admin
Login successful! Role: ADMIN

Options:
1. Get All Employees
2. Get Employee by ID
3. Add Employee
4. Update Employee
5. Delete Employee
6. Exit
Choice: 1
Employee{id=1, name='John Doe'}
```

---

## Shell Scripts

### `run-server.sh`
```bash
#!/bin/bash
cd "$(dirname "$0")"
java -cp "rmi-server/target/rmi-server-1.0-SNAPSHOT.jar:rmi-common/target/rmi-common-1.0-SNAPSHOT.jar" org.example.ServerApp
```

### `run-client.sh`
```bash
#!/bin/bash
cd "$(dirname "$0")"
java -cp "rmi-client/target/rmi-client-1.0-SNAPSHOT.jar:rmi-common/target/rmi-common-1.0-SNAPSHOT.jar" org.example.App
```

---

## Testing

Unit tests are included under the `rmi-common`, `rmi-server`, and `rmi-client` modules and run automatically via:

```bash
mvn test
```

---

## Notes

- The server binds to `127.0.0.1` for localhost testing. To use over LAN, replace it with the machine’s IP.
- Ensure port `1099` is open in firewall if running over LAN.

