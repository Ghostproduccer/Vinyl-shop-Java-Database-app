# VinylShop Java Database Application

## Description
The developed program is a Java application that interacts with a MySQL database and performs read and write operations on XML files. It is designed to manage data related to a vinyl store, providing functionalities through an interactive menu.

## Code Structure
### DAO Package:
Contains classes related to data access. The DAO interfaces and their implementations are located here to interact with the database.

### Model Package:
Here are the classes representing the entities of the database. They contain attributes and methods related to the database entities.

### Util Package:
Contains utility classes shared across different parts of the application. It includes the DatabaseConnection class, responsible for managing the connection to the database using DataSource, as well as the XMLConversion class, related to conversion between XML and objects.

### Main Package:
This package contains the main class of the application, which is used for testing and verifying the program's functionality. It also contains the TiendaBrunoBBDD class, which acts as an intermediary between the user interface and database operations.

With this package structure, the code is organized clearly and modularly, making it easier to maintain and understand. Additionally, it follows an object-oriented design approach, where each component has a specific responsibility.

## Dependencies
- Java SE Development Kit (JDK)
- MySQL Server
- JDBC Driver for MySQL
- JAXB (Java Architecture for XML Binding)
