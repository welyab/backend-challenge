package com.invillia.acme.data.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.google.common.base.Preconditions;

@Entity
public class Item implements Serializable {

	@SuppressWarnings("javadoc")
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "code")
	private String code;

	@ManyToOne
	@Column(name = "id_product")
	private Product product;

	@Column(name = "quantity")
	private BigDecimal quantity;

	@Column(name = "unitPrice")
	private BigDecimal unitPrice;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (code == null ? 0 : code.hashCode());
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
		Item other = (Item) obj;
		if (code == null) {
			if (other.code != null) {
				return false;
			}
		} else if (!code.equals(other.code)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Item [product=" + product + ", quantity=" + quantity + "]";
	}

	public Item merge(Product product, BigDecimal unitPrice, BigDecimal quantity) {
		Preconditions.checkArgument(
			this.product.equals(product),
			"The product to merge is different than this item product"
		);
		Item item = new Item();
		item.setProduct(this.product);
		item.setQuantity(this.quantity.add(quantity));
		item.setUnitPrice(unitPrice);
		return item;
	}
}
