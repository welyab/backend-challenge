package com.invillia.acme.cart;

/**
 * Indicates problems during shopping cart manipulation.
 * 
 * @author Welyab Paula
 */
public class CartException extends RuntimeException {

	@SuppressWarnings("javadoc")
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("javadoc")
	public CartException() {
	}

	@SuppressWarnings("javadoc")
	public CartException(String message) {
		super(message);
	}

	@SuppressWarnings("javadoc")
	public CartException(Throwable cause) {
		super(cause);
	}

	@SuppressWarnings("javadoc")
	public CartException(String message, Throwable cause) {
		super(message, cause);
	}
}
