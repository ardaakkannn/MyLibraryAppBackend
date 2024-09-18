package com.ardakkan.demo.DTOS;

import java.util.List;

public class CustomerDTO {

    private Long id;
    private String name;
    private String email;
    private List<OrderDTO> orders;
    
   
    
	public CustomerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerDTO(Long id, String name, String email, List<OrderDTO> orders) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.orders = orders;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<OrderDTO> getOrders() {
		return orders;
	}
	public void setOrders(List<OrderDTO> orders) {
		this.orders = orders;
	}

    
}

