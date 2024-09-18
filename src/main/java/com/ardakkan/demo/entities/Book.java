package com.ardakkan.demo.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(
		nullable= false
	)
	private String name;
	
	private LocalDate publishedDate;
	
	private String genre;
	
	private int stock;
	
	private BigDecimal price;
	 
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "author_id")
	
	@JsonIgnore
	private Author author;
	

	public Book() {
		
	}

	public Book(int id, String name, LocalDate publishedDate, String genre, int stock, BigDecimal price, Author author) {
		super();
		this.id = id;
		this.name = name;
		this.publishedDate = publishedDate;
		this.genre = genre;
		this.stock = stock;
		this.price = price;
		this.author = author;
	}







	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", publishedDate=" + publishedDate + ", genre=" + genre
				+ ", stock=" + stock + ", price=" + price + ", author=" + author + "]";
	}







	public BigDecimal getPrice() {
		return price;
	}







	public void setPrice(BigDecimal price) {
		this.price = price;
	}







	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate = publishedDate;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public LocalDate getPublishedDate() {
		return publishedDate;
	}

	public String getGenre() {
		return genre;
	}

	public int getStock() {
		return stock;
	}

	public Author getAuthor() {
		return author;
	}
	
		
	
	
}
