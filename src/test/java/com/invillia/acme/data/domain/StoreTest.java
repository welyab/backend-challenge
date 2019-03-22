package com.invillia.acme.data.domain;

import org.junit.Assert;
import org.junit.Test;

import com.invillia.acme.data.model.Store;
import com.invillia.acme.util.UuidUtils;

/**
 * Unit tests for <code>Store</code> class.
 *
 * @author Welyab Paula
 */
public class StoreTest {

	@Test
	@SuppressWarnings("javadoc")
	public void equalsShouldReturnTrueForStoresWithSameIdentifiers() {
		String code = UuidUtils.random();
		Store store1 = new Store();
		store1.setCode(code);
		Store store2 = new Store();
		store2.setCode(code);
		Assert.assertTrue(store1.equals(store2));
	}

	@Test
	@SuppressWarnings("javadoc")
	public void equalsShouldReturnFalseForStoresWithDifferentIdentifiers() {
		Store store1 = new Store();
		store1.setCode(UuidUtils.random());
		Store store2 = new Store();
		store2.setCode(UuidUtils.random());
		Assert.assertFalse(store1.equals(store2));
	}
}
