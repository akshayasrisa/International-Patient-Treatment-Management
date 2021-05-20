package com.cognizant.exception;

/**
 * @author POD2
 * @version 1.8
 * @apiNote Whenever the token validation fails then we will throw this
 *          exception and it extends RuntimeException.
 * 
 * @see RuntimeException
 *
 */
public class TokenValidationFailedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * No-arg constructor of {@link TokenValidationFailedException}
	 */
	public TokenValidationFailedException() {
		super();
	}

	/**
	 * All-arg constructor of {@link TokenValidationFailedException}
	 */
	public TokenValidationFailedException(String message) {
		super(message);
	}

}
