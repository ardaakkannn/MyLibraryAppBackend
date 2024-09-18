package com.ardakkan.demo.controller;

import com.ardakkan.demo.DTOS.AuthorDTO;
import com.ardakkan.demo.DTOS.BookDTO;
import com.ardakkan.demo.services.AuthorService;
import com.ardakkan.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;
    private final BookService bookService;

    @Autowired
    public AuthorController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    // Retrieve all authors
    @GetMapping
    public List<AuthorDTO> retrieveAllAuthors() {
        return authorService.findAllAuthors();
    }

    // Find author by ID
    @GetMapping("/{id}")
    public AuthorDTO findAuthorById(@PathVariable int id) {
        return authorService.findAuthorById(id);
    }

    // Add author
    @PostMapping
    public ResponseEntity<AuthorDTO> createAuthor(@RequestBody AuthorDTO authorDTO) {
        AuthorDTO savedAuthor = authorService.createAuthor(authorDTO);
        return ResponseEntity.ok(savedAuthor);
    }

    // Update Author
    @PutMapping("/{id}")
    public ResponseEntity<AuthorDTO> updateAuthor(@PathVariable int id, @RequestBody AuthorDTO authorDTO) {
        AuthorDTO updatedAuthor = authorService.updateAuthor(id, authorDTO);
        return ResponseEntity.ok(updatedAuthor);
    }

    // Delete author
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable int id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.ok().build();
    }

    // Add book to author 
    @PostMapping("/{authorId}/books")
    public ResponseEntity<BookDTO> createBook(@PathVariable int authorId, @RequestBody BookDTO bookDTO) {
        BookDTO savedBook = bookService.createBook(authorId, bookDTO);
        return ResponseEntity.ok(savedBook);
    }

    // Retrieve books by author name
    @GetMapping("/name/{authorName}/books")
    public List<BookDTO> getBooksByAuthorName(@PathVariable String authorName) {
        return bookService.getBooksByAuthorName(authorName);
    }

    // Retrieve books by author ID
    @GetMapping("/{authorId}/books")
    public List<BookDTO> getBooksByAuthorId(@PathVariable int authorId) {
        return bookService.getBooksByAuthorId(authorId);
    }
}

