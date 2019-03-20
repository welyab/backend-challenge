package com.invillia.acme.data.domain;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for <code>Store</code> class.
 *
 * @author Welyab Paula
 */
public class StoreTest {

	@Test
	@SuppressWarnings("javadoc")
	public void equalsShouldReturnTrueForStoresWithSameIdentifiers() {
		Store store1 = new Store();
		store1.setId(100L);
		Store store2 = new Store();
		store2.setId(100L);
		Assert.assertTrue(store1.equals(store2));
	}

	@Test
	@SuppressWarnings("javadoc")
	public void equalsShouldReturnFalseForStoresWithDifferentIdentifiers() {
		Store store1 = new Store();
		store1.setId(100L);
		Store store2 = new Store();
		store2.setId(200L);
		Assert.assertFalse(store1.equals(store2));
	}
}
