package com.invillia.acme.cart;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Preconditions;
import com.invillia.acme.data.model.Product;

/**
 * A <code>CartProdut</code> is a immutable product information that is part of
 * an <code>Intem</code>. Items are used to store products, prices and
 * quantities in the shopping cart.
 * 
 * @author Welyab Paula
 */
public class CartProduct implements Comparable<CartProduct>, Serializable {

	@SuppressWarnings("javadoc")
	private static final long serialVersionUID = 1L;

	/**
	 * The product code.
	 */
	private final String productCode;

	/**
	 * The product description.
	 */
	private final String productDescription;

	/**
	 * Creates a new <code>CartProduct</code> based in the ginve
	 * <code>Product</code> object.
	 * 
	 * @param product The product.
	 * 
	 * @throws NullPointerException If the <code>product</code> parameter is
	 *             <code>null</code>.
	 */
	public CartProduct(Product product) {
		this(
			Preconditions.checkNotNull(product, "product").getCode(),
			Preconditions.checkNotNull(product, "product").getDescription()
		);
	}

	/**
	 * Creates a new <code>CartProduct</code> using given parameters.
	 * 
	 * @param productCode The product code.
	 * @param productDescription The product description.
	 * 
	 * @throws NullPointerException If any of the parameters is informed as
	 *             <code>null</code>.
	 */
	public CartProduct(String productCode, String productDescription) {
		Preconditions.checkArgument(
			StringUtils.isNoneBlank(productCode),
			"Parameter 'productCode' cannot be empty."
		);
		Preconditions.checkArgument(
			StringUtils.isNoneBlank(productCode),
			"Parameter 'productDescription' cannot be empty"
		);
		this.productCode = productCode;
		this.productDescription = productDescription;
	}

	/**
	 * Retrieves the product code.
	 * 
	 * @return The product code.
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * Retrieves the product description.
	 * 
	 * @return The product descrption.
	 */
	public String getProductDescription() {
		return productDescription;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (productCode == null ? 0 : productCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		CartProduct other = (CartProduct) obj;
		if (productCode == null) {
			if (other.productCode != null) {
				return false;
			}
		} else if (!productCode.equals(other.productCode)) {
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(CartProduct o) {
		return productCode.compareTo(o.productCode);
	}
}
