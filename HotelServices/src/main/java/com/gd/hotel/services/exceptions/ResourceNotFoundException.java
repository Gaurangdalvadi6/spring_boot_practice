package com.gd.hotel.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException(String s) {
		super(s);
	}
	
	public ResourceNotFoundException() {
		super("Resurce Not Found !!");
	}
}
