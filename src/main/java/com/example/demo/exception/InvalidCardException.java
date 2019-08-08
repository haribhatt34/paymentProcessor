package com.example.demo.exception;

public class InvalidCardException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public InvalidCardException(String s){  
		  super(s);
	}
	
	@Override
	public String getMessage() {
		return "########## You Entered Invalid Card Details ##########";
	}
	
}
