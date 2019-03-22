package com.invillia.acme.data.model;

import java.math.BigDecimal;

import org.junit.Test;

import com.invillia.acme.cart.CartItem;

/**
 * Unit tests for the <code>CartItem</code> class.
 *
 * @author Welyab Paula
 */
public class ItemTest {

	@Test(expected = NullPointerException.class)
	@SuppressWarnings("javadoc")
	public void mergeProductUnitPriceQuantityShouldThrowNullPointerexceptionWhenProductIsNull() {
		CartItem item = new CartItem(new Product("A321", "Computer"), new BigDecimal("10.21"), new BigDecimal("1.00"));
		item.merge(null, new BigDecimal("10.21"), new BigDecimal("1.00"));
	}

	@Test(expected = NullPointerException.class)
	@SuppressWarnings("javadoc")
	public void mergeProductUnitPriceQuantityShouldThrowNullPointerexceptionWhenUnitPriceIsNull() {
		CartItem item = new CartItem(new Product("A321", "Computer"), new BigDecimal("10.21"), new BigDecimal("1.00"));
		item.merge(new Product("A321", "Computer"), null, new BigDecimal("1.00"));
	}

	@Test(expected = NullPointerException.class)
	@SuppressWarnings("javadoc")
	public void mergeProductUnitPriceQuantityShouldThrowNullPointerexceptionWhenUnitQuantityIsNull() {
		CartItem item = new CartItem(new Product("A321", "Computer"), new BigDecimal("10.21"), new BigDecimal("1.00"));
		item.merge(new Product("A321", "Computer"), new BigDecimal("10.21"), null);
	}

	@Test(expected = IllegalArgumentException.class)
	@SuppressWarnings("javadoc")
	public void mergeProductUnitPriceQuantityShouldThrowIllegalArgumentExceptionWhenPassedProductIsDifferent() {
		CartItem item = new CartItem(new Product("A321", "Computer"), new BigDecimal("10.21"), new BigDecimal("1.00"));
		item.merge(new Product("A123", "Computer"), new BigDecimal("10.21"), new BigDecimal("1.00"));
	}
}
