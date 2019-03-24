package com.invillia.acme.rest.api;

import org.springframework.http.ResponseEntity;

/**
 * Auxiliary class for performs unsafe casts in <code>ResponseEntity</code>
 * objects.
 * 
 * @author Welyab Paula
 */
public class ResponseCast {

	@SuppressWarnings("javadoc")
	private ResponseCast() {
	}

	/**
	 * Performs a unsafe cast in the given parameter.
	 * 
	 * @param response The object to be casted.
	 * 
	 * @return The same reference passed in the <code>response</code> parameter.
	 */
	public static <E> ResponseEntity<E> cast(ResponseEntity<?> response) {
		@SuppressWarnings("unchecked")
		ResponseEntity<E> e = (ResponseEntity<E>) response;
		return e;
	}

}
