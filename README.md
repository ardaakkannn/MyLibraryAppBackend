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
```

### 2. Import the project into your IDE
Open your preferred IDE (IntelliJ IDEA, Eclipse, etc.) and import the project.  
Ensure Maven dependencies are downloaded.

### 3. Run the application
To run the application, execute the following command from the terminal or IDE:
```bash
mvn spring-boot:run
```
### 4. Access the H2 Database Console
You can access the H2 database at:

```bash

http://localhost:8080/h2-console
```
- JDBC URL: jdbc:h2:mem:testdb
- Username: sa
- Password: (Leave blank)

### API Endpoints
#### Authors
- GET /api/authors: Retrieve all authors.
- GET /api/authors/{id}: Retrieve a specific author by ID.
- POST /api/authors: Add a new author.
##### Request Body Example:
```bash
{
  "name": "J.K. Rowling"
}
```
- PUT /api/authors/{id}: Update an existing author by ID.
##### Request Body Example:
```bash
{
  "name": "George Orwell"
}
```
- DELETE /api/authors/{id}: Delete an author by ID.
#### Books
- GET /api/books: Retrieve all books.
- GET /api/books/{id}: Retrieve a specific book by ID.
- POST /api/authors/{authorId}/books: Add a new book for a specific author.
##### Request Body Example:
```bash
{
  "name": "1984",
  "publishedDate": "1949-06-08",
  "genre": "Dystopian",
  "stock": 10,
  "price": 25.99
}
```
- PUT /api/books/{id}: Update an existing book by ID.
##### Request Body Example:
```bash
{
  "name": "Animal Farm",
  "publishedDate": "1945-08-17",
  "genre": "Satire",
  "stock": 15,
  "price": 19.99
}
```
- DELETE /api/books/{id}: Delete a book by ID.
- GET /api/books/top-sellers: Get the top-selling books.
- GET /api/books/genres/{genre}: Retrieve books by genre.
#### Orders
- GET /api/orders: Retrieve all orders.
- GET /api/orders/{id}: Retrieve a specific order by ID.
- POST /api/orders: Create a new order.
##### Request Body Example:
```bash
{
  "customerId": 1,
  "bookIds": [1, 2],
  "orderDate": "2024-01-15T10:30:00"
}
```
- PUT /api/orders/{id}: Update an existing order by ID.
##### Request Body Example:
```bash
{
  "customerId": 1,
  "bookIds": [1, 3],
  "orderDate": "2024-01-15T10:30:00"
}
```
- DELETE /api/orders/{id}: Delete an order by ID.
