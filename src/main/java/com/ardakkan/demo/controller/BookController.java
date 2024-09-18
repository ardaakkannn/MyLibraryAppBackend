package com.ardakkan.demo.controller;

import com.ardakkan.demo.DTOS.BookDTO;
import com.ardakkan.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // Retrieve all books
    @GetMapping
    public List<BookDTO> retrieveAllBooks() {
        return bookService.findAllBooks();
    }

    // Find book by ID
    @GetMapping("/{id}")
    public BookDTO findBookById(@PathVariable int id) {
        return bookService.findBookById(id);
    }

    // Update book by id
    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable int id, @RequestBody BookDTO bookDTO) {
        BookDTO updatedBook = bookService.updateBook(id, bookDTO);
        return ResponseEntity.ok(updatedBook);
    }

    // Delete book
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }

    // Book Stock update 
    @PutMapping("/{id}/stock/{newStock}")
    public ResponseEntity<BookDTO> updateStock(@PathVariable int id, @PathVariable int newStock) {
        BookDTO updatedBook = bookService.updateStock(id, newStock);
        return ResponseEntity.ok(updatedBook);
    }

    // Retrieve books by genres
    @GetMapping("/genres/{genre_name}")
    public List<BookDTO> getBooksByGenre(@PathVariable String genre_name) {
        return bookService.getBooksByGenre(genre_name);
    }

    // Retrieve top selling books
    @GetMapping("/top-sellers")
    public ResponseEntity<List<BookDTO>> getTopSellingBooks() {
        List<BookDTO> topSellingBooks = bookService.getTopSellingBooks();
        return ResponseEntity.ok(topSellingBooks);
    }
}

