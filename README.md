# Event Scheduling System

The Event Scheduling System is an automated arrangement system for various halls based on different inputs. It provides a platform for administrators and Heads of Departments (HoDs) to manage and schedule events efficiently.

## Features

•	User authentication: Both administrators and HoDs can register and log in to the system.

•	Role-based access: Access to system features is granted based on user roles.

•	Event submission: HoDs can submit event details, including event name, topic, date, time, and duration.

•	Event approval: Administrators can review and approve event requests from HoDs.

•	Hall allocation: Administrators can assign halls to approved events.

•	Event tracking: Users can track the status of their event requests.



## Technologies Used

•	Java: Programming language used for the backend development.

•	MySQL: Database management system for storing user and event data.

•	Swing: Java GUI toolkit for building the user interface.

•	GitHub: Version control system for code collaboration and project management.





## Getting Started

1. Clone the repository:



```shell
git clone https://github.com/ananthudev/Event-Scheduling-System.git

```
1.	Set up the database:

    •	Create a MySQL database named ess.

    •	Import the provided SQL script (ess.sql) into the database to create the necessary tables.

2.	Configure the database connection:

    •	Open the Connector/AdminAllReq.java file.

    •	Modify the connection URL, username, and password in the getConnection() method to match your MySQL configuration.

3.	Build and run the application:

    •	Use an IDE like Eclipse or IntelliJ to import the project.

    •	Build and run the AdminAllReq.java file to start the application.



## Project Structure

The project follows a standard Java project structure. Here are the main directories and files:

•	Connector: Contains the Java source files for the application.

•	image: Holds images used in the user interface.

•	ess.sql: SQL script for creating the necessary database tables.

•	README.md: This file provides an overview of the project.



## License

[MIT](https://github.com/ananthudev/Event-Scheduling-System/blob/d34d98dfabdef11a7237f3cb16fd4380c24abd71/LICENSE)
