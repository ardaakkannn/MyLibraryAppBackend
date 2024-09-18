package com.ardakkan.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ardakkan.demo.DTOS.AuthorDTO;
import com.ardakkan.demo.entities.Author;
import com.ardakkan.demo.entities.Book;
import com.ardakkan.demo.exceptions.AuthorNotFoundException;
import com.ardakkan.demo.repositories.AuthorJpaRepo;

@Service
public class AuthorService {
    private final AuthorJpaRepo authorRepo;

    @Autowired
    public AuthorService(AuthorJpaRepo authorRepo) {
        this.authorRepo = authorRepo;
    }

    public List<AuthorDTO> findAllAuthors() {
        return authorRepo.findAll().stream()
                .map(author -> new AuthorDTO(author.getId(), author.getName(), author.getBooks().stream()
                        .map(Book::getName).collect(Collectors.toList())))
                .collect(Collectors.toList());
    }

    public AuthorDTO findAuthorById(int id) {
        return authorRepo.findById(id)
                .map(author -> new AuthorDTO(author.getId(), author.getName(), author.getBooks().stream()
                        .map(Book::getName).collect(Collectors.toList())))
                .orElseThrow(() -> new AuthorNotFoundException(id));
    }

    public AuthorDTO createAuthor(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setName(authorDTO.getName());
        // Books can be added to authors later, here we just adding authors
        Author savedAuthor = authorRepo.save(author);
        return new AuthorDTO(savedAuthor.getId(), savedAuthor.getName(), new ArrayList<>());
    }

    public void deleteAuthor(int id) {
        if (authorRepo.existsById(id)) {
            authorRepo.deleteById(id);
        } else {
            throw new AuthorNotFoundException(id);
        }
    }

    public AuthorDTO updateAuthor(int id, AuthorDTO authorDTO) {
        Author author = authorRepo.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException(id));
        author.setName(authorDTO.getName());
        Author updatedAuthor = authorRepo.save(author);
        return new AuthorDTO(updatedAuthor.getId(), updatedAuthor.getName(), new ArrayList<>());
    }
}

