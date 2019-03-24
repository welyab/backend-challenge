package com.invillia.acme.rest.api;

import java.math.BigDecimal;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Preconditions;
import com.invillia.acme.cart.CartItem;

/**
 * DOT for sharing items (products with prices and quantities...).
 * 
 * @author Welyab Paula
 */
public class ItemDto extends ResourceSupport {

	@JsonProperty("product-code")
	@SuppressWarnings("javadoc")
	private String productCode;

	@JsonProperty("product-desc")
	@SuppressWarnings("javadoc")
	private String productDescription;

	@JsonProperty("unit-price")
	@SuppressWarnings("javadoc")
	private BigDecimal unitPrice;

	@JsonProperty("quantity")
	@SuppressWarnings("javadoc")
	private BigDecimal quantity;

	public ItemDto(CartItem cartItem) {
		Preconditions.checkNotNull(cartItem, "cartItem");
		productCode = cartItem.getProduct().getProductCode();
		productDescription = cartItem.getProduct().getProductDescription();
		quantity = cartItem.getQuantity();
		unitPrice = cartItem.getUnitPrice();
	}

	@SuppressWarnings("javadoc")
	public String getProductCode() {
		return productCode;
	}

	@SuppressWarnings("javadoc")
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	@SuppressWarnings("javadoc")
	public String getProductDescription() {
		return productDescription;
	}

	@SuppressWarnings("javadoc")
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	@SuppressWarnings("javadoc")
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	@SuppressWarnings("javadoc")
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	@SuppressWarnings("javadoc")
	public BigDecimal getQuantity() {
		return quantity;
	}

	@SuppressWarnings("javadoc")
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (productCode == null ? 0 : productCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		ItemDto other = (ItemDto) obj;
		if (productCode == null) {
			if (other.productCode != null) {
				return false;
			}
		} else if (!productCode.equals(other.productCode)) {
			return false;
		}
		return true;
	}
}
