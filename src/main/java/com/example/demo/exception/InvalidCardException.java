package com.example.demo.exception;

public class InvalidCardException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	public String getMessage() {
		return "--------- invalid card -----------";
	}
	
}
