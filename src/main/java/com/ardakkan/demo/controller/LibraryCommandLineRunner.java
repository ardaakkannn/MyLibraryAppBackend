package com.ardakkan.demo.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ardakkan.demo.entities.Author;
import com.ardakkan.demo.entities.Book;
import com.ardakkan.demo.entities.Customer;
import com.ardakkan.demo.entities.Orders;
import com.ardakkan.demo.repositories.AuthorJpaRepo;
import com.ardakkan.demo.repositories.BookJpaRepo;
import com.ardakkan.demo.repositories.CustomerJpaRepo;
import com.ardakkan.demo.repositories.OrdersJpaRepo;

@Configuration
public class LibraryCommandLineRunner implements CommandLineRunner {

    @Autowired
    private AuthorJpaRepo authorRepo;

    @Autowired
    private BookJpaRepo bookRepo;

    @Autowired
    private CustomerJpaRepo customerRepo;

    @Autowired
    private OrdersJpaRepo ordersRepo;

    @Override
    public void run(String... args) throws Exception {
        // Authors
        Author author1 = new Author(null, "George Orwell", null);
        Author author2 = new Author(null, "J.K. Rowling", null);
        Author author3 = new Author(null, "J.R.R. Tolkien", null);
        authorRepo.saveAll(Arrays.asList(author1, author2, author3));

        // Books (with prices)
        Book book1 = new Book(1, "1984", LocalDate.of(1949, 6, 8), "Dystopian", 10, BigDecimal.valueOf(27.99), author1);
        Book book2 = new Book(2, "Animal Farm", LocalDate.of(1945, 8, 17), "Satire", 8, BigDecimal.valueOf(19.99), author1);
        Book book3 = new Book(3, "Harry Potter and the Philosopher's Stone", LocalDate.of(1997, 6, 26), "Fantasy", 20, BigDecimal.valueOf(25.99), author2);
        Book book4 = new Book(4, "Harry Potter and the Chamber of Secrets", LocalDate.of(1998, 7, 2), "Fantasy", 15, BigDecimal.valueOf(22.99), author2);
        Book book5 = new Book(5, "The Hobbit", LocalDate.of(1937, 9, 21), "Fantasy", 12, BigDecimal.valueOf(30.99), author3);
        Book book6 = new Book(6, "The Lord of the Rings", LocalDate.of(1954, 7, 29), "Fantasy", 18, BigDecimal.valueOf(35.99), author3);
        bookRepo.saveAll(Arrays.asList(book1, book2, book3, book4, book5, book6));

        // Customers
        Customer customer1 = new Customer(null, "Alice", "alice@example.com", null);
        Customer customer2 = new Customer(null, "Bob", "bob@example.com", null);
        Customer customer3 = new Customer(null, "Charlie", "charlie@example.com", null);
        customerRepo.saveAll(Arrays.asList(customer1, customer2, customer3));

        // Orders (order total calculated from book prices)
        Orders order1 = new Orders(null, customer1, Arrays.asList(book1, book3), book1.getPrice().add(book3.getPrice()), LocalDateTime.of(2024, 1, 15, 10, 30));
        Orders order2 = new Orders(null, customer2, Arrays.asList(book2, book4), book2.getPrice().add(book4.getPrice()), LocalDateTime.of(2024, 2, 5, 15, 45));
        Orders order3 = new Orders(null, customer3, Arrays.asList(book5, book6), book5.getPrice().add(book6.getPrice()), LocalDateTime.of(2024, 3, 20, 8, 0));
        Orders order4 = new Orders(null, customer1, Arrays.asList(book4), book4.getPrice(), LocalDateTime.of(2024, 4, 10, 12, 15));
        Orders order5 = new Orders(null, customer2, Arrays.asList(book1, book5), book1.getPrice().add(book5.getPrice()), LocalDateTime.of(2024, 5, 25, 14, 30));
        Orders order6 = new Orders(null, customer3, Arrays.asList(book3, book6), book3.getPrice().add(book6.getPrice()), LocalDateTime.of(2024, 6, 8, 9, 0));
        ordersRepo.saveAll(Arrays.asList(order1, order2, order3, order4, order5, order6));
    }
}
