package com.ardakkan.demo.DTOS;

import java.math.BigDecimal;

public class BookDTO {
    private int id;
    private String name;
    private String authorName; 
    private String genre;
    private int stock;
    private BigDecimal price;
    
    public BookDTO() {}

    
    public BookDTO(int id, String name, String authorName, String genre,BigDecimal price, int stock) {
        this.id = id;
        this.name = name;
        this.authorName = authorName;
        this.genre = genre;
        this.stock = stock;
        this.price=price;
    }

    public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}

