# MyLibraryAppBackend

MyLibraryAppBackend is a backend system for managing a library, built using Spring Boot. It allows users to manage authors, books, and customer orders through RESTful APIs.

## Features

- Manage Authors, Books, and Orders using CRUD operations (Create, Read, Update, Delete).
- Customers can create orders, purchase books, and view existing orders.
- Book stock management.
- List top-selling books.

## Technologies Used

- **Java 17**: Programming language.
- **Spring Boot**: Backend framework.
- **H2 Database**: In-memory database used for persistence.
- **Spring Data JPA (Hibernate)**: For database interaction.
- **Maven**: For project management and build.
- **Postman**: For API testing.

## How to Set Up

### 1. Clone the repository
Clone the project to your local machine:
```bash
git clone https://github.com/ardaakkannn/MyLibraryAppBackend.git

### 2. Import the project into your IDE
Open your preferred IDE (IntelliJ IDEA, Eclipse, etc.) and import the project.  
Ensure Maven dependencies are downloaded.

### 3. Run the application
To run the application, execute the following command from the terminal or IDE:
```bash
mvn spring-boot:run
