package com.invillia.acme.cart;

public class CartException extends RuntimeException {

	public CartException() {
	}

	public CartException(String message) {
		super(message);
	}

	public CartException(Throwable cause) {
		super(cause);
	}

	public CartException(String message, Throwable cause) {
		super(message, cause);
	}
}
