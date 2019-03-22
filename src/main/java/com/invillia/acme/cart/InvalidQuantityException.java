package com.invillia.acme.cart;

public class InvalidQuantityException extends CartException {

	public InvalidQuantityException() {
	}

	public InvalidQuantityException(String message) {
		super(message);
	}

	public InvalidQuantityException(Throwable cause) {
		super(cause);
	}

	public InvalidQuantityException(String message, Throwable cause) {
		super(message, cause);
	}
}
