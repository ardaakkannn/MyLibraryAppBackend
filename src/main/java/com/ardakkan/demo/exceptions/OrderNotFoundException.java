package com.ardakkan.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OrderNotFoundException extends RuntimeException{
	public OrderNotFoundException(int id) {
        super("Order not found with ID: " + id);
    }
}
