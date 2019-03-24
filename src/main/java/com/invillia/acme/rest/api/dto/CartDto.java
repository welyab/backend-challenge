package com.invillia.acme.rest.api.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.invillia.acme.data.model.Cart;
import com.invillia.acme.data.model.Store;

/**
 * A DTO for sharing cart information.
 * 
 * @author Welyab Paula
 */
public class CartDto extends ResourceSupport {

    @JsonProperty("store-id")
    @SuppressWarnings("javadoc")
    private Long storeId;

    @JsonProperty("cart-id")
    @SuppressWarnings("javadoc")
    private Long cartId;

    @JsonProperty("items")
    @SuppressWarnings("javadoc")
    private List<CartItemDto> items;

    @SuppressWarnings("javadoc")
    public CartDto() {
    }

    @SuppressWarnings("javadoc")
    public CartDto(Cart cart) {
	if (cart != null) {
	    cartId = cart.getId();
	    storeId = cart.getStore().getId();
	    items = Optional
		    .ofNullable(cart.getItems())
		    .map(List::stream)
		    .map(s -> s.map(CartItemDto::new))
		    .map(s -> s.collect(Collectors.toList()))
		    .orElse(new ArrayList<>());
	}
    }

    @SuppressWarnings("javadoc")
    public Long getStoreId() {
	return storeId;
    }

    @SuppressWarnings("javadoc")
    public void setStoreId(Long storeId) {
	this.storeId = storeId;
    }

    @SuppressWarnings("javadoc")
    public Long getCartId() {
	return cartId;
    }

    @SuppressWarnings("javadoc")
    public void setCartId(Long cartId) {
	this.cartId = cartId;
    }

    @SuppressWarnings("javadoc")
    public List<CartItemDto> getItems() {
	return items;
    }

    @SuppressWarnings("javadoc")
    public void setItems(List<CartItemDto> items) {
	this.items = items;
    }

    @SuppressWarnings("javadoc")
    public Cart toCart() {
	Cart cart = new Cart();
	cart.setId(getCartId());
	cart.setStore(new Store(getStoreId()));
	cart.setItems(
		Optional.ofNullable(getItems())
			.map(List::stream)
			.map(l -> l.map(CartItemDto::toCartItem))
			.map(l -> l.collect(Collectors.toList()))
			.orElse(new ArrayList<>())
	);
	return cart;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((cartId == null) ? 0 : cartId.hashCode());
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
	CartDto other = (CartDto) obj;
	if (cartId == null) {
	    if (other.cartId != null)
		return false;
	} else if (!cartId.equals(other.cartId))
	    return false;
	return true;
    }
}
