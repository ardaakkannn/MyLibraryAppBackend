package com.ardakkan.demo.DTOS;

import java.util.List;

public class AuthorDTO {
    private int id;
    private String name;
    private List<String> books; // Books of author 

    
    public AuthorDTO() {}

        public AuthorDTO(int id, String name, List<String> books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getBooks() {
        return books;
    }

    public void setBooks(List<String> books) {
        this.books = books;
    }
}

