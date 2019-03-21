package com.invillia.acme.service;

/**
 * This class indicates many kinds of problems during data processing.
 *
 * @author Welyab Paula
 */
public class DataValidationException extends Exception {

	@SuppressWarnings("javadoc")
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("javadoc")
	public DataValidationException() {
	}

	@SuppressWarnings("javadoc")
	public DataValidationException(String message, Throwable cause) {
		super(message, cause);
	}

	@SuppressWarnings("javadoc")
	public DataValidationException(String message) {
		super(message);
	}

	@SuppressWarnings("javadoc")
	public DataValidationException(Throwable cause) {
		super(cause);
	}
}
