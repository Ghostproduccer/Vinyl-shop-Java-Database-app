# VinylShop Java Database Application

## Description
The developed program is a Java application that interacts with a MySQL database and performs read and write operations on XML files. It is designed to manage data related to a vinyl store, providing functionalities through an interactive menu.

## Code Structure
### Main Class (Main):
Manages user interaction through an interactive menu. Invokes methods from the `TiendaBrunoBBDD` class to carry out selected operations.

### Database Class (`TiendaBrunoBBDD`):
Manages the connection to the MySQL database and provides CRUD operations. Uses JDBC to execute SQL queries and update the database.

### XML Conversion Class (`XMLConversion`):
Utilizes JAXB for conversion between Java objects and XML files. Provides methods for reading and writing data to and from XML files.

## Dependencies
- Java SE Development Kit (JDK)
- MySQL Server
- JDBC Driver for MySQL
- JAXB (Java Architecture for XML Binding)
