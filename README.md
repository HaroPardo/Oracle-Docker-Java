# User Registration and Login System

A **Java-based user registration and login system** with Oracle Database integration, containerized with Docker for easy deployment.

---

## 🚀 Features

- User registration with secure password hashing (**SHA-256**)
- Login authentication against **Oracle Database**
- User profile dashboard after successful login
- Containerized Oracle Database using **Docker**
- Clean Java implementation with proper separation of concerns

---

## 🛠️ Technologies Used

- **Java** - Core application logic  
- **Oracle Database XE** - Database management  
- **Docker** - Containerization of Oracle Database  
- **JDBC** - Database connectivity  
- **Git** - Version control  

---

## 📋 Prerequisites

Before running this application, ensure you have the following installed:

- Java JDK 17 or higher  
- Docker  
- Git  
- Oracle JDBC Driver (**ojdbc11.jar**)  

---

## ⚙️ Installation & Setup

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/your-username/java-user-login-system.git
cd java-user-login-system

# Pull the Oracle XE image
docker pull gvenzl/oracle-xe

# Run the Oracle XE container
docker run -d --name oracle-xe \
  -p 1521:1521 -p 5500:5500 \
  -e ORACLE_PASSWORD=your_password \
  gvenzl/oracle-xe

Update the database connection details in util/DatabaseConnection.java:

private static final String URL = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
private static final String USER = "system";
private static final String PASSWORD = "your_password";

Create Database Table

CREATE TABLE Users (
    id NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR2(100) NOT NULL,
    email VARCHAR2(100) UNIQUE NOT NULL,
    password_hash VARCHAR2(100) NOT NULL
);
