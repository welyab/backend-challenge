package com.invillia.acme.util;

import java.util.UUID;
import java.util.regex.Pattern;

import com.google.common.base.Preconditions;

/**
 * Some auxiliary method to work with UUID.
 * 
 * @author Welyab Paula
 */
public class UuidUtils {

	/**
	 * Regex for UUID validation.
	 */
	private static final Pattern REGEX = Pattern
		.compile("^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$");

	@SuppressWarnings("javadoc")
	private UuidUtils() {
	}

	/**
	 * Evaluates if given UUID parameter is valid.
	 * 
	 * @param uuid The UUID to validate.
	 * 
	 * @return A value <code>true</code> if given UUID is valid, or
	 *         <code>false</code> otherwise.
	 * 
	 * @throws NullPointerException If the given parameter is <code>null</code>.
	 */
	public static boolean isValid(String uuid) {
		Preconditions.checkNotNull(uuid, "uuid");
		return REGEX.matcher(uuid).matches();
	}

	/**
	 * Creates a new randomly generated UUID.
	 * 
	 * @return The UUID.
	 */
	public static String random() {
		return UUID.randomUUID().toString();
	}
}
