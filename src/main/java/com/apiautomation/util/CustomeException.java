package com.apiautomation.util;

/**
 * Custom exception class
 * 
 * @author santosh.pardeshi
 *
 */
public class CustomeException extends Exception{

	/**
	 * Added default serial version uid
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Instantiates a new custom exception.
	 */
	public CustomeException() {
		super();
	}
	
	/**
	 * 
	 * Instantiates a new custom exception.
	 * @param message custom error message
	 */
	public CustomeException(String message) {
		super(message);
	}
	
	/**
	 * Instantiates a new core framework exception.
	 * @param message custom error message
	 * @param cause reason for error
	 */
	public CustomeException(String message, Throwable cause) {
		super(message,cause);
	}
	
	/**
	 * Override the getMessage method
	 */
	@Override
	public String getMessage() {
		return super.getMessage();
	}
}
