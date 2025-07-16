# RemoteEmployeeManager

A Java RMI-based system to manage employee records remotely. This project is split into three Maven modules:

- `rmi-common`: Contains shared interfaces and data classes.
- `rmi-server`: The RMI server which exposes remote methods for employee management.
- `rmi-client`: A client application that connects to the RMI server and performs operations.

## Project Structure

```
RemoteEmployeeManager/
│
├── rmi-common/        # Shared interfaces and models
├── rmi-server/        # RMI server implementation
├── rmi-client/        # Client application
└── pom.xml            # Parent POM for multi-module build
```

## Features

- Add, list, and manage employees remotely
- Modular Maven-based structure
- RMI communication over IP (not just localhost)

## Build Instructions

```bash
# Build all modules
mvn clean install
```

## Running the System

### 1. Start the Server

```bash
export RMI_SERVER_IP=192.168.1.100   # Replace with actual IP
java -cp rmi-server/target/rmi-server-1.0-SNAPSHOT.jar:rmi-common/target/rmi-common-1.0-SNAPSHOT.jar org.example.ServerMain
```

### 2. Run the Client

```bash
java -cp rmi-client/target/rmi-client-1.0-SNAPSHOT.jar:rmi-common/target/rmi-common-1.0-SNAPSHOT.jar org.example.App
```

## Exposing over Network

In `ServerMain.java`, the RMI server is bound to the machine IP using:

```java
System.setProperty("java.rmi.server.hostname", "192.168.1.100");
```

The client must use the same IP in:

```java
LocateRegistry.getRegistry("192.168.1.100", 1099);
```

## Sample Output

```
All Employees:
Employee{id=1, name='Ali'}
Employee{id=2, name='Nagy'}

Adding new employee:
Added: true

After addition:
Employee{id=1, name='Ali'}
Employee{id=2, name='Nagy'}
Employee{id=3, name='Mona'}
```
