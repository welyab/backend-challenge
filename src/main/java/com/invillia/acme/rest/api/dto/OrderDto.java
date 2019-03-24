package com.invillia.acme.rest.api.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.ResourceSupport;

import com.invillia.acme.data.model.Order;

@SuppressWarnings("javadoc")
public class OrderDto extends ResourceSupport {

    private Long code;
    private LocalDateTime orderDate;
    private BigDecimal totalPrice;
    private List<OrderItemDto> items;

    public OrderDto(Order order) {
	if (order != null) {
	    code = order.getId();
	    orderDate = order.getOrderDate();
	    totalPrice = order.getTotalPrice();
	    items = order.getItems()
		    .stream()
		    .map(OrderItemDto::new)
		    .collect(Collectors.toList());
	}
    }

    public Long getCode() {
	return code;
    }

    public void setCode(Long code) {
	this.code = code;
    }

    public LocalDateTime getOrderDate() {
	return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
	this.orderDate = orderDate;
    }

    public BigDecimal getTotalPrice() {
	return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
	this.totalPrice = totalPrice;
    }

    public List<OrderItemDto> getItems() {
	return items;
    }

    public void setItems(List<OrderItemDto> items) {
	this.items = items;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((code == null) ? 0 : code.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (!super.equals(obj))
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	OrderDto other = (OrderDto) obj;
	if (code == null) {
	    if (other.code != null)
		return false;
	} else if (!code.equals(other.code))
	    return false;
	return true;
    }
}
