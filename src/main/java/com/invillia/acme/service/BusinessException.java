package com.invillia.acme.service;

/**
 * Indicates problems during execution of application business logic.
 * 
 * @author Welyab Paula
 */
public class BusinessException extends Exception {

	@SuppressWarnings("javadoc")
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("javadoc")
	public BusinessException() {
	}

	@SuppressWarnings("javadoc")
	public BusinessException(String message) {
		super(message);
	}

	@SuppressWarnings("javadoc")
	public BusinessException(Throwable cause) {
		super(cause);
	}

	@SuppressWarnings("javadoc")
	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}
}
