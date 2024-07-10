# 📅 Event Scheduling System

The Event Scheduling System is an automated arrangement system for various halls based on different inputs. It provides a platform for administrators and Heads of Departments (HoDs) to manage and schedule events efficiently.

## ✨ Features

- 🔐 **User Authentication**: Both administrators and HoDs can register and log in to the system.
- 👥 **Role-Based Access**: Access to system features is granted based on user roles.
- 📅 **Event Submission**: HoDs can submit event details, including event name, topic, date, time, and duration.
- ✅ **Event Approval**: Administrators can review and approve event requests from HoDs.
- 🏛️ **Hall Allocation**: Administrators can assign halls to approved events.
- 🔍 **Event Tracking**: Users can track the status of their event requests.

## 🛠️ Technologies Used

- ![Java](https://img.shields.io/badge/-Java-007396?logo=java&logoColor=white&style=flat) Java: Programming language used for the backend development.
- ![MySQL](https://img.shields.io/badge/-MySQL-4479A1?logo=mysql&logoColor=white&style=flat) MySQL: Database management system for storing user and event data.
- ![Swing](https://img.shields.io/badge/-Swing-007396?logo=java&logoColor=white&style=flat) Swing: Java GUI toolkit for building the user interface.
- ![GitHub](https://img.shields.io/badge/-GitHub-181717?logo=github&logoColor=white&style=flat) GitHub: Version control system for code collaboration and project management.

## 🏁 Getting Started

1. Clone the repository:

    ```shell
    git clone https://github.com/ananthudev/Event-Scheduling-System.git
    ```

2. Set up the database:
    - Create a MySQL database named `ess`.
    - Import the provided SQL script (`ess.sql`) into the database to create the necessary tables.

3. Configure the database connection:
    - Open the `Connector/AdminAllReq.java` file.
    - Modify the connection URL, username, and password in the `getConnection()` method to match your MySQL configuration.

4. Build and run the application:
    - Use an IDE like Eclipse or IntelliJ to import the project.
    - Build and run the `AdminAllReq.java` file to start the application.

## 📂 Project Structure

The project follows a standard Java project structure. Here are the main directories and files:

- 📁 **Connector**: Contains the Java source files for the application.
- 📁 **image**: Holds images used in the user interface.
- 📄 **ess.sql**: SQL script for creating the necessary database tables.
- 📜 **README.md**: This file provides an overview of the project.

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](https://github.com/ananthudev/Event-Scheduling-System/blob/d34d98dfabdef11a7237f3cb16fd4380c24abd71/LICENSE) file for details.

---

![Footer](https://via.placeholder.com/1200x200.png?text=Thank+You+for+Visiting!)
