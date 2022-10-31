package com.yash.pms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.OK)
public class ProductNotFoundException extends RuntimeException{

	public ProductNotFoundException(String msg) {
		
		super(msg);
	}
	
}
