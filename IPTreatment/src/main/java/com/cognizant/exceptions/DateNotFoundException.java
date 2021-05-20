package com.cognizant.exceptions;

/**
 * @author POD2
 * @version 1.8
 * @apiNote Whenever the date entered from client is null then we will throw
 *          this exception and it extends RuntimeException.
 * 
 * @see RuntimeException
 *
 */
public class DateNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * No-arg constructor of {@link DateNotFoundException}
	 */
	public DateNotFoundException() {
		super();
	}

	/**
	 * All-arg constructor of {@link DateNotFoundException}
	 * 
	 * @param message
	 */
	public DateNotFoundException(String message) {
		super(message);
	}

}
