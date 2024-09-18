package com.ardakkan.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(int id) {
        super("Author not found with ID: " + id);
    }
    
    public AuthorNotFoundException(String s) {
        super("Author not found with Name: " + s);
    }
}
