package com.invillia.acme.rest.api.dto;

import java.math.BigDecimal;

import com.invillia.acme.data.model.OrderItem;

@SuppressWarnings("javadoc")
public class OrderItemDto {

    private ProductDto product;
    private BigDecimal quantity;
    private BigDecimal unitPrice;

    public OrderItemDto() {
    }

    public OrderItemDto(OrderItem orderItem) {
	if (orderItem != null) {
	    product = new ProductDto(orderItem.getProduct());
	    quantity = orderItem.getQuantity();
	    unitPrice = orderItem.getUnitPrice();
	}
    }

    public ProductDto getProduct() {
	return product;
    }

    public void setProduct(ProductDto product) {
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
}
