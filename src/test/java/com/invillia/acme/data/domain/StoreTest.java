package com.invillia.acme.data.domain;

import org.junit.Assert;
import org.junit.Test;

import com.invillia.acme.data.model.Store;

/**
 * Unit tests for <code>Store</code> class.
 *
 * @author Welyab Paula
 */
public class StoreTest {

	@Test
	@SuppressWarnings("javadoc")
	public void equalsShouldReturnTrueForStoresWithSameIdentifiers() {
		Long id = 10L;
		Store store1 = new Store();
		store1.setId(id);
		Store store2 = new Store();
		store2.setId(id);
		Assert.assertTrue(store1.equals(store2));
	}

	@Test
	@SuppressWarnings("javadoc")
	public void equalsShouldReturnFalseForStoresWithDifferentIdentifiers() {
		Store store1 = new Store();
		store1.setId(10L);
		Store store2 = new Store();
		store2.setId(20L);
		Assert.assertFalse(store1.equals(store2));
	}
}
