# Console-Based Banking Management System

A Maven-based console banking application developed using Java and MySQL. The system follows a layered architecture and implements the DAO (Data Access Object) design pattern to efficiently manage customer accounts and banking transactions.

## 🚀 Key Features
- Create and manage customer accounts  
- Deposit and withdraw funds  
- Track transaction history  
- Maintain customer records  
- JDBC-based database integration  
- Structured modular backend design  

## 🏗 Architecture
The project follows a multi-layered architecture:
- **Model Layer** – Account, Customer, Transaction entities  
- **DAO Layer** – Database operations  
- **Service Layer** – Business logic  
- **Configuration Layer** – Database connection handling  
- **Main Application** – Console-based user interface  

## 🛠 Technologies
Java • MySQL • JDBC • Maven • OOP • DAO Pattern  

## 🗂 Project Structure

```text
com.bankapp
│
├── config
│   └── DBConnection.java        # Database configuration
│
├── model
│   ├── Account.java
│   ├── Customer.java
│   └── Transaction.java         # Entity classes
│
├── dao
│   ├── AccountDAO.java
│   ├── AccountDAOImpl.java      # DAO interfaces & implementations
│   └── ...
│
├── service
│   └── AccountService.java      # Business logic layer
│
└── MainApp.java                 # Application entry point
```

## ▶ How to Run
1. Configure MySQL database  
2. Update credentials in `DBConnection.java`  
3. Run `MainApp.java`  

This project demonstrates backend development fundamentals including layered architecture, database integration, and modular design principles.
