package com.ardakkan.demo.repositories;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ardakkan.demo.entities.Book;
import org.springframework.data.domain.Pageable;


public interface BookJpaRepo extends JpaRepository <Book, Integer>{
	

	List<Book> findByAuthorName(String authorName);
	Optional<List<Book>> findByName(String name);
	List<Book> findByGenre(String genreName);
	@Query(value = "SELECT b.* FROM Book b JOIN Orders o ON b.id = o.book_Id WHERE o.order_Date >= :threeMonthsAgo GROUP BY b.id ORDER BY SUM(o.quantity) DESC LIMIT 5", nativeQuery = true)
	List<Book> findTopSellingBooks(LocalDateTime threeMonthsAgo);

}
