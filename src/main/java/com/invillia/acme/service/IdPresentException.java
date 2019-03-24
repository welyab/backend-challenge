package com.invillia.acme.service;

/**
 * Indicates that processingment of save some entity idetified that given entity
 * has a identification (ID). That proccess generally creates the ID at runtime
 * and don't allow entities with already present ID.
 * 
 * @author Welyab Paula
 */
public class IdPresentException extends BusinessException {

	@SuppressWarnings("javadoc")
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("javadoc")
	public IdPresentException() {
		super();
	}

	@SuppressWarnings("javadoc")
	public IdPresentException(String message) {
		super(message);
	}

	@SuppressWarnings("javadoc")
	public IdPresentException(Throwable cause) {
		super(cause);
	}

	@SuppressWarnings("javadoc")
	public IdPresentException(String message, Throwable cause) {
		super(message, cause);
	}
}
