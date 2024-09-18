package com.ardakkan.demo.DTOS;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class OrderDTO {

    private Long id;
    private Long customerId;
    private List<Integer> bookIds; // Just storing ID's of books 
    private BigDecimal totalPrice;
    private LocalDateTime orderDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public List<Integer> getBookIds() {
		return bookIds;
	}
	
	public void setBookIds(List<Integer> bookIds) {
		this.bookIds = bookIds;
	}
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
	public OrderDTO(Long id, Long customerId, List<Integer> bookIds, BigDecimal totalPrice, LocalDateTime orderDate) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.bookIds = bookIds;
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
	}
	public OrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

   
}

