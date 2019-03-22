package com.invillia.acme.cart;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import com.invillia.acme.data.model.Product;

/**
 * Unit tests for <code>ShoppingCart</code> class.
 *
 * @author Welyab Paula
 */
public class ShoppingCartTest {

	@Test(expected = NullPointerException.class)
	@SuppressWarnings("javadoc")
	public void addItemProductUnitPriceQuantityShouldThrowNullPointerExceptionWhenProductIsNull() {
		ShoppingCart cart = new ShoppingCart();
		cart.addItem(null, new BigDecimal("1.02"), new BigDecimal("3.3"));
	}

	@Test(expected = NullPointerException.class)
	@SuppressWarnings("javadoc")
	public void addItemProductUnitPriceQuantityShouldThrowNullPointerExceptionWhenUnitPriceIsNull() {
		ShoppingCart cart = new ShoppingCart();
		cart.addItem(new Product("A3221", "Computer"), null, new BigDecimal("3.3"));
	}

	@Test(expected = NullPointerException.class)
	@SuppressWarnings("javadoc")
	public void addItemProductUnitPriceQuantityShouldThrowNullPointerExceptionWhenQuantityIsNull() {
		ShoppingCart cart = new ShoppingCart();
		cart.addItem(new Product("A3221", "Computer"), new BigDecimal("3.3"), null);
	}

	@Test(expected = IllegalArgumentException.class)
	@SuppressWarnings("javadoc")
	public void addItemProductUnitPriceQuantityShouldThrowIllegalArgumentExceptionWhenQuantityIsZero() {
		ShoppingCart cart = new ShoppingCart();
		cart.addItem(new Product("A3221", "Computer"), new BigDecimal("3.3"), new BigDecimal("0.00"));
	}

	@Test(expected = IllegalArgumentException.class)
	@SuppressWarnings("javadoc")
	public void addItemProductUnitPriceQuantityShouldThrowIllegalArgumentExceptionWhenQuantityIsLessThenZero() {
		ShoppingCart cart = new ShoppingCart();
		cart.addItem(new Product("A3221", "Computer"), new BigDecimal("3.3"), new BigDecimal("-2.75"));
	}

	@Test(expected = IllegalArgumentException.class)
	@SuppressWarnings("javadoc")
	public void addItemProductUnitPriceQuantityShouldThrowIllegalArgumentExceptionWhenUnitPriceIsZero() {
		ShoppingCart cart = new ShoppingCart();
		cart.addItem(new Product("A3221", "Computer"), new BigDecimal("0.0"), new BigDecimal("5.32"));
	}

	@Test(expected = IllegalArgumentException.class)
	@SuppressWarnings("javadoc")
	public void addItemProductUnitPriceQuantityShouldThrowIllegalArgumentExceptionWhenUnitPriceIsLessThenZero() {
		ShoppingCart cart = new ShoppingCart();
		cart.addItem(new Product("A3221", "Computer"), new BigDecimal("-650.0"), new BigDecimal("5.32"));
	}

	@Test
	@SuppressWarnings("javadoc")
	public void sizeShouldIncreaseAfterAddedProduct() {
		ShoppingCart cart = new ShoppingCart();
		int size = cart.size();
		cart.addItem(new Product("A3221", "Computer"), new BigDecimal("62.0"), new BigDecimal("5.32"));
		Assert.assertEquals(size + 1, cart.size());
	}

	@Test(expected = NullPointerException.class)
	@SuppressWarnings("javadoc")
	public void removeItemProductShouldThrowNullPointerExceptionWhenProductIsNull() {
		ShoppingCart cart = new ShoppingCart();
		Product product = new Product("A3221", "Computer");
		cart.addItem(product, new BigDecimal("62.0"), new BigDecimal("5.32"));
		Assert.assertEquals("A3221", cart.getItem(0).getProduct().getProductCode());
		cart.removeItem(null);
	}

	@Test
	@SuppressWarnings("javadoc")
	public void removeItemProductShouldRemoveItemFromCart() {
		ShoppingCart cart = new ShoppingCart();
		Product product = new Product("A3221", "Computer");
		cart.addItem(product, new BigDecimal("62.0"), new BigDecimal("5.32"));
		Assert.assertEquals("A3221", cart.getItem(0).getProduct().getProductCode());
		cart.removeItem(product);
		Assert.assertEquals(0, cart.size());
	}

	@Test
	@SuppressWarnings("javadoc")
	public void removeItemProductQuantityShouldRemoveOnlySpecifiedQuanity() {
		ShoppingCart cart = new ShoppingCart();
		Product product = new Product("A3221", "Computer");
		cart.addItem(product, new BigDecimal("62.0"), new BigDecimal("50.32"));
		Assert.assertEquals("A3221", cart.getItem(0).getProduct().getProductCode());
		cart.removeItem(product, new BigDecimal("30.00"));
		Assert.assertEquals(new BigDecimal("20.32"), cart.getItem(0).getQuantity());
	}


	@Test(expected = NullPointerException.class)
	@SuppressWarnings("javadoc")
	public void removeItemProductQuantityShouldThrowNullPointerExceptionWhenProductIsNull() {
		ShoppingCart cart = new ShoppingCart();
		Product product = new Product("A3221", "Computer");
		cart.addItem(product, new BigDecimal("62.0"), new BigDecimal("50.32"));
		Assert.assertEquals("A3221", cart.getItem(0).getProduct().getProductCode());
		cart.removeItem(null, new BigDecimal("30.00"));
	}


	@Test(expected = NullPointerException.class)
	@SuppressWarnings("javadoc")
	public void removeItemProductQuantityShouldThrowNullPointerExceptionQuantiyIsNull() {
		ShoppingCart cart = new ShoppingCart();
		Product product = new Product("A3221", "Computer");
		cart.addItem(product, new BigDecimal("62.0"), new BigDecimal("50.32"));
		Assert.assertEquals("A3221", cart.getItem(0).getProduct().getProductCode());
		cart.removeItem(product, null);
	}

	@Test(expected = IllegalArgumentException.class)
	@SuppressWarnings("javadoc")
	public void removeItemProductQuantityShouldThrowIllegalArgumentExceptionQuenQuantityIsZero() {
		ShoppingCart cart = new ShoppingCart();
		Product product = new Product("A3221", "Computer");
		cart.addItem(product, new BigDecimal("62.0"), new BigDecimal("50.32"));
		Assert.assertEquals("A3221", cart.getItem(0).getProduct().getProductCode());
		cart.removeItem(product, new BigDecimal("0.00"));
	}

	@Test(expected = IllegalArgumentException.class)
	@SuppressWarnings("javadoc")
	public void removeItemProductQuantityShouldThrowIllegalArgumentExceptionQuenQuantityIsLessThenZero() {
		ShoppingCart cart = new ShoppingCart();
		Product product = new Product("A3221", "Computer");
		cart.addItem(product, new BigDecimal("62.0"), new BigDecimal("50.32"));
		Assert.assertEquals("A3221", cart.getItem(0).getProduct().getProductCode());
		cart.removeItem(product, new BigDecimal("-2.00"));
	}
}
