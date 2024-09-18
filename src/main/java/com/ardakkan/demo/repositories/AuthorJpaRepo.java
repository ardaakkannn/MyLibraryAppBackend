package com.ardakkan.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ardakkan.demo.entities.Author;

public interface AuthorJpaRepo extends JpaRepository<Author, Integer>{
	List<Author> findByName(String name);
}
