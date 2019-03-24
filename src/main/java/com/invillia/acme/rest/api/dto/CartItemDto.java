package com.invillia.acme.rest.api.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.invillia.acme.data.model.CartItem;
import com.invillia.acme.data.model.Product;

/**
 * Represents a cart item.
 * 
 * @author Welyab Paula
 */
public class CartItemDto {

    @JsonProperty("quantity")
    @SuppressWarnings("javadoc")
    private BigDecimal quantity;

    @JsonProperty("product-description")
    @SuppressWarnings("javadoc")
    private String productDescription;

    @JsonProperty("product-id")
    @SuppressWarnings("javadoc")
    private Long productId;

    @JsonProperty("unity-price")
    @SuppressWarnings("javadoc")
    private BigDecimal unitPrice;

    @SuppressWarnings("javadoc")
    public CartItemDto(CartItem cartItem) {
	if (cartItem != null) {
	    this.unitPrice = cartItem.getUnitPrice();
	    this.productId = cartItem.getProduct().getId();
	    this.productDescription = cartItem.getProduct().getDescription();
	    this.quantity = cartItem.getQuantity();
	}
    }

    @SuppressWarnings("javadoc")
    public BigDecimal getQuantity() {
	return quantity;
    }

    @SuppressWarnings("javadoc")
    public void setQuantity(BigDecimal quantity) {
	this.quantity = quantity;
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
    public Long getProductId() {
	return productId;
    }

    @SuppressWarnings("javadoc")
    public void setProductId(Long productId) {
	this.productId = productId;
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
    public CartItem toCartItem() {
	CartItem item = new CartItem();
	Product product = new Product();
	product.setDescription(getProductDescription());
	product.setId(getProductId());
	item.setProduct(product);
	item.setQuantity(getQuantity());
	item.setUnitPrice(getUnitPrice());
	return item;
    }
}
