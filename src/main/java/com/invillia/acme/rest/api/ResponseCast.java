package com.invillia.acme.rest.api;

import org.springframework.http.ResponseEntity;

public class ResponseCast {

	public static <E> ResponseEntity<E> cast(ResponseEntity<?> response) {
		@SuppressWarnings("unchecked")
		ResponseEntity<E> e = (ResponseEntity<E>) response;
		return e;
	}

}
