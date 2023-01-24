package com.example.HotelService.exception;

public class ResourceNotFoundException extends RuntimeException{

	
	public ResourceNotFoundException(String s) {
		super(s);
	}
	public ResourceNotFoundException() {
		super("this resource not found");
	}
}
