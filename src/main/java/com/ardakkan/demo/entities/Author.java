package com.ardakkan.demo.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Author {
	@Id
	@GeneratedValue
	private Integer id;
	
	private String name;
	
	@OneToMany(mappedBy="author", fetch = FetchType.LAZY)
	
	@JsonIgnore
	private List<Book> books;
	

	public Author() {
		
	}

	public Author(Integer id, String name, List<Book> books) {
		super();
		this.id = id;
		this.name = name;
		this.books = books;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", books=" + books + "]";
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Book> getBooks() {
		return books;
	}
	
	
	
	
	
}
