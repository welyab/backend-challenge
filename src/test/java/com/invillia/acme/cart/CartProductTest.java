package com.invillia.acme.cart;

import org.junit.Test;

/**
 * Unit tests for the <code>CartProduct</code> class.
 * 
 * @author Welyab Paula
 */
public class CartProductTest {

	@Test(expected = NullPointerException.class)
	@SuppressWarnings("javadoc")
	public void newCartProductProductShouldThrownNullPointerExceptionWhenProductIsNull() {
		new CartProduct(null);
	}

	@Test(expected = IllegalArgumentException.class)
	@SuppressWarnings("javadoc")
	public void newCartProductCodeDescriptionShouldThrownIllegalArgumentExceptionWhenCodeIsEmpty() {
		new CartProduct(null, "Computer");
	}

	@Test(expected = IllegalArgumentException.class)
	@SuppressWarnings("javadoc")
	public void newCartProductCodeDescriptionShouldThrownIllegalArgumentExceptionWhenDescriptionIsEmpty() {
		new CartProduct("A321", null);
	}
}
