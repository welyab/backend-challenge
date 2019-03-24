package com.invillia.acme.rest.api.dto;

import java.math.BigDecimal;

/**
 * DTO used to add or remove items from the cart.
 * 
 * @author Welyab Paula
 */
public class CartItemPatchDto {

    @SuppressWarnings("javadoc")
    private Long productId;

    @SuppressWarnings("javadoc")
    private BigDecimal quantity;

    @SuppressWarnings("javadoc")
    public Long getProductId() {
	return productId;
    }

    @SuppressWarnings("javadoc")
    public void setProductId(Long productId) {
	this.productId = productId;
    }

    @SuppressWarnings("javadoc")
    public BigDecimal getQuantity() {
	return quantity;
    }

    @SuppressWarnings("javadoc")
    public void setQuantity(BigDecimal quantity) {
	this.quantity = quantity;
    }
}
