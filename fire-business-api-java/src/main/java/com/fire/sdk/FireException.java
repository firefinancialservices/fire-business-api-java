package com.fire.sdk;

/**
 * An exception class for general Fire SDK errors. All other SDK exceptions will extend this class.
 * 
 * @author owenobyrne
 */
public class FireException extends RuntimeException {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor for FireException.
	 * 
	 * @param message
	 * @param throwable
	 */
	public FireException(String message, Throwable throwable) {
		super(message, throwable);
	}

	/**
	 * Constructor for FireException.
	 * 
	 * @param message
	 */
	public FireException(String message) {
		super(message);
	}

}

