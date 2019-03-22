package com.invillia.acme.cart;

import java.io.Serializable;
import java.math.BigDecimal;

import com.google.common.base.Preconditions;
import com.invillia.acme.data.model.Product;

/**
 * This class represents a item in the shopping cart during user HTTP session life.
 *
 * @author Welyab Paula
 */
public class CartItem implements Serializable {

	@SuppressWarnings("javadoc")
	private static final long serialVersionUID = 1L;

	/**
	 * The product associated with this cart item.
	 */
	private CartProduct product;

	/**
	 * The quantity of the product.
	 */
	private BigDecimal quantity;

	/**
	 * The product's unit price.
	 */
	private BigDecimal unitPrice;

	/**
	 * Creates a new item using given parameters.
	 *
	 * @param product The product associated with this item.
	 * @param unitPrice The product's unit price.
	 * @param quantity The quantity of the product.
	 */
	public CartItem(Product product, BigDecimal unitPrice, BigDecimal quantity) {
		this.product = new CartProduct(product);
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}

	/**
	 * Retrieves the product associated with this cart item.
	 *
	 * @return The product information.
	 */
	public CartProduct getProduct() {
		return product;
	}

	/**
	 * Retrieves the quantity of this product in the cart.
	 *
	 * @return The quantity.
	 */
	public BigDecimal getQuantity() {
		return quantity;
	}

	/**
	 * Retrieves the unit price of this product.
	 *
	 * @return The product unit price.
	 */
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	/**
	 * Merge the given product, unit price and quantity in order to create a new item, where the
	 * quantity will be the sum of quantity present in <i>this</i> item plus given quantity.
	 *
	 * @param product The product to merge.
	 * @param unitPrice The unit price to merge.
	 * @param quantity The quantity to merge.
	 *
	 * @return A brand new item.
	 *
	 * @throws NullPointerException In the case of any parameter be informed as <code>null</code>
	 *         value.
	 * @throws IllegalArgumentException If the given product be different of the product present in
	 *         <i>this</i> item.
	 */
	public CartItem merge(Product product, BigDecimal unitPrice, BigDecimal quantity) {
		Preconditions.checkNotNull(product, "product");
		Preconditions.checkNotNull(unitPrice, "unitPrice");
		Preconditions.checkNotNull(quantity, "quantity");
		Preconditions.checkArgument(this.product.getProductCode().equals(product.getCode()));
		return new CartItem(
			product,
			unitPrice,
			this.quantity.add(quantity)
		);
	}

	@Override
	public String toString() {
		return "CartItem [product=" + product + ", quantity=" + quantity + "]";
	}
}
