package com.invillia.acme.service;

/**
 * Indicates that a entity does not exist during some operation where it is
 * required.
 * 
 * @author Welyab Paula
 */
public class EntryNotFoundException extends BusinessException {

	@SuppressWarnings("javadoc")
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("javadoc")
	public EntryNotFoundException() {
	}

	@SuppressWarnings("javadoc")
	public EntryNotFoundException(String message) {
		super(message);
	}

	@SuppressWarnings("javadoc")
	public EntryNotFoundException(Throwable cause) {
		super(cause);
	}

	@SuppressWarnings("javadoc")
	public EntryNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
