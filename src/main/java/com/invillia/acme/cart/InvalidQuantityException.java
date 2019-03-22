package com.invillia.acme.cart;

/**
 * Indicates that a invalid quantity was attemped to be inserted in the cart.
 * 
 * @author Welyab Paula
 */
public class InvalidQuantityException extends CartException {

	@SuppressWarnings("javadoc")
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("javadoc")
	public InvalidQuantityException() {
	}

	@SuppressWarnings("javadoc")
	public InvalidQuantityException(String message) {
		super(message);
	}

	@SuppressWarnings("javadoc")
	public InvalidQuantityException(Throwable cause) {
		super(cause);
	}

	@SuppressWarnings("javadoc")
	public InvalidQuantityException(String message, Throwable cause) {
		super(message, cause);
	}
}
