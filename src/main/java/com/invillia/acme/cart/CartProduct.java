package com.invillia.acme.cart;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

import com.google.common.base.Preconditions;
import com.invillia.acme.data.model.Product;

public class CartProduct implements Comparable<CartProduct>, Serializable {

	@SuppressWarnings("javadoc")
	private static final long serialVersionUID = 1L;

	private final String productCode;

	private final String productDescription;

	public CartProduct(Product product) {
		this(
			Preconditions.checkNotNull(product, "product").getCode(),
			Preconditions.checkNotNull(product, "product").getDescription()
		);
	}

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

	public String getProductCode() {
		return productCode;
	}

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
