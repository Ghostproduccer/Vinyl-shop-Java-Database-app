# VinylShop Java Database Application

## Description
The developed program is a Java application that interacts with a MySQL database and performs read and write operations on XML files. It is designed to manage data related to a vinyl store, providing functionalities through an interactive menu.

## Main Features
### Table Query:
Allows the user to query records from tables in the database, such as users, vinyl, orders, and order details. Selects the desired table and displays the information stored in it.

### Place an Order:
Enables the user to place an order for vinyl records.

### Modify Vinyl Price:
Allows the modification of the price of a selected vinyl. After querying a vinyl, the user has the option to modify its price if desired.

### Insert Vinyl from XML:
Facilitates the loading of new vinyl records from an XML file. The user provides the XML file's name, and the application inserts the new records into the database.

### Backup Vinyl to XML:
Offers the option to create a backup of all vinyl records in an XML file. The user decides whether to perform the backup, and a new XML file is generated with updated vinyl information.

## Development and Code Structure
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
