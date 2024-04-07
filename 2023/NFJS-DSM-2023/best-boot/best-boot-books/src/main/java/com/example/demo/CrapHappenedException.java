package com.example.demo;

public class CrapHappenedException 
	extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CrapHappenedException(String message) {
		super(message);
	}
	
}
