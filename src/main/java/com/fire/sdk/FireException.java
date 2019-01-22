package com.fire.sdk;

/**
 * An exception class for general Fire SDK errors. All other SDK exceptions will extend this class.
 * 
 * @author owenobyrne
 */
public class FireException extends RuntimeException {


	/**
	 * version Id
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor for FireException.
	 * 
	 * @param message the message to display to the calling code
	 * @param throwable an exception to return to the calling code. 
	 */
	public FireException(String message, Throwable throwable) {
		super(message, throwable);
	}

	/**
	 * Constructor for FireException.
	 * 
	 * @param message the message to display to the calling code
	 */
	public FireException(String message) {
		super(message);
	}

}

