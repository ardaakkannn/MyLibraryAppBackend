package com.ardakkan.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ListIsEmptyException extends RuntimeException{
	public ListIsEmptyException() {
        super("Table is Empty" );
    }
}
