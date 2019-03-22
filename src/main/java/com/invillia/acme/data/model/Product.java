package com.invillia.acme.data.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * An product sold in the store.
 * 
 * @author Welyab Paula
 */
@Entity
public class Product implements Serializable {

	/**
	 * The minimum price for
	 */
	public static final BigDecimal MIN_PRICE = new BigDecimal("0.01");

	@SuppressWarnings("javadoc")
	private static final long serialVersionUID = 1L;

	/**
	 * The identification of this product.
	 */
	@Id
	@Column(name = "id")
	private String code;

	/**
	 * The description for this product.
	 */
	@Column(name = "description")
	private String description;

	/**
	 * Retrieves code of this product.
	 * 
	 * @return The code value.
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Adjusts the code of this prodcut.
	 * 
	 * @param code The code.
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Retrieves the description of this product.
	 * 
	 * @return The description.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Adjusts the description of this product.
	 * 
	 * @param description The description.
	 */
	public void setDescription(String description) {
		this.description = description;
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
		Product other = (Product) obj;
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
		return "Product [code=" + code + ", description=" + description + "]";
	}
}
