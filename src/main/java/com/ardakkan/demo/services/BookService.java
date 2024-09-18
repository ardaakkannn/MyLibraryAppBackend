package com.ardakkan.demo.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ardakkan.demo.DTOS.BookDTO;
import com.ardakkan.demo.entities.Author;
import com.ardakkan.demo.entities.Book;
import com.ardakkan.demo.exceptions.AuthorNotFoundException;
import com.ardakkan.demo.exceptions.BookNotFoundException;
import com.ardakkan.demo.repositories.AuthorJpaRepo;
import com.ardakkan.demo.repositories.BookJpaRepo;

@Service
public class BookService {
    private final BookJpaRepo bookRepo;
    private final AuthorJpaRepo authorRepo;

    @Autowired
    public BookService(BookJpaRepo bookRepo, AuthorJpaRepo authorRepo) {
        this.bookRepo = bookRepo;
        this.authorRepo = authorRepo;
    }

    public List<BookDTO> findAllBooks() {
        return bookRepo.findAll().stream()
                .map(book -> new BookDTO(book.getId(), book.getName(), book.getAuthor().getName(), book.getGenre(),book.getPrice(), book.getStock()))
                .collect(Collectors.toList());
    }

    public BookDTO findBookById(int id) {
        return bookRepo.findById(id)
                .map(book -> new BookDTO(book.getId(), book.getName(), book.getAuthor().getName(), book.getGenre(),book.getPrice(), book.getStock()))
                .orElseThrow(() -> new BookNotFoundException(id));
    }

    public BookDTO createBook(int authorId, BookDTO bookDTO) {
        Author author = authorRepo.findById(authorId)
                .orElseThrow(() -> new AuthorNotFoundException(authorId));

        Book book = new Book();
        book.setName(bookDTO.getName());
        book.setAuthor(author);
        book.setGenre(bookDTO.getGenre());
        book.setStock(bookDTO.getStock());

        Book savedBook = bookRepo.save(book);
        return new BookDTO(savedBook.getId(), savedBook.getName(), author.getName(), savedBook.getGenre(),savedBook.getPrice(), savedBook.getStock());
    }

    public void deleteBook(int id) {
        if (bookRepo.existsById(id)) {
            bookRepo.deleteById(id);
        } else {
            throw new BookNotFoundException(id);
        }
    }

    public BookDTO updateBook(int id, BookDTO bookDTO) {
        Book book = bookRepo.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        book.setName(bookDTO.getName());
        book.setGenre(bookDTO.getGenre());
        book.setStock(bookDTO.getStock());
        book.setPrice(bookDTO.getPrice());
        Book updatedBook = bookRepo.save(book);
        return new BookDTO(updatedBook.getId(), updatedBook.getName(), updatedBook.getAuthor().getName(), updatedBook.getGenre(),updatedBook.getPrice(), updatedBook.getStock());
    }
 // Stock update
    public BookDTO updateStock(int id, int newStock) {
        Book book = bookRepo.findById(id)
                .orElseThrow(() -> new BookNotFoundException(id));
        book.setStock(newStock);
        Book updatedBook = bookRepo.save(book);
        return new BookDTO(updatedBook.getId(), updatedBook.getName(), updatedBook.getAuthor().getName(), updatedBook.getGenre(),updatedBook.getPrice(), updatedBook.getStock());
    }

    // Get book by author names
    public List<BookDTO> getBooksByAuthorName(String authorName) {
        List<Book> books = bookRepo.findByAuthorName(authorName);
        if (books.isEmpty()) {
            throw new AuthorNotFoundException(authorName);
        }
        return books.stream()
                .map(book -> new BookDTO(book.getId(), book.getName(), book.getAuthor().getName(), book.getGenre(),book.getPrice(), book.getStock()))
                .collect(Collectors.toList());
    }

    // Get book by author ID
    public List<BookDTO> getBooksByAuthorId(int authorId) {
        Author author = authorRepo.findById(authorId)
                .orElseThrow(() -> new AuthorNotFoundException(authorId));
        return author.getBooks().stream()
                .map(book -> new BookDTO(book.getId(), book.getName(), author.getName(), book.getGenre(),book.getPrice(), book.getStock()))
                .collect(Collectors.toList());
    }

    // Get top selling books
    public List<BookDTO> getTopSellingBooks() {
        LocalDateTime threeMonthsAgo = LocalDateTime.now().minusMonths(3);
        List<Book> topSellingBooks = bookRepo.findTopSellingBooks(threeMonthsAgo);
        if (topSellingBooks.isEmpty()) {
            throw new BookNotFoundException("Top selling books not found");
        }
        return topSellingBooks.stream()
                .map(book -> new BookDTO(book.getId(), book.getName(), book.getAuthor().getName(), book.getGenre(),book.getPrice(), book.getStock()))
                .collect(Collectors.toList());
    }

    // Get books by genres
    public List<BookDTO> getBooksByGenre(String genreName) {
        List<Book> books = bookRepo.findByGenre(genreName);
        if (books.isEmpty()) {
            throw new BookNotFoundException(genreName);
        }
        return books.stream()
                .map(book -> new BookDTO(book.getId(), book.getName(), book.getAuthor().getName(), book.getGenre(),book.getPrice(), book.getStock()))
                .collect(Collectors.toList());
    }
    
}
