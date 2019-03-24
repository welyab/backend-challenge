package com.invillia.acme.data.repository;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.invillia.acme.data.model.Cart;

@Entity
public class CartItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany
    @JoinColumn(name = "id_cart")
    private Cart cart;

    @OneToMany
    @JoinColumn(name = "id_product")
    private Product product;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;

    @Column(name = "unit_price")
    private BigDecimal quantity;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Cart getCart() {
	return cart;
    }

    public void setCart(Cart cart) {
	this.cart = cart;
    }

    public Product getProduct() {
	return product;
    }

    public void setProduct(Product product) {
	this.product = product;
    }

    public BigDecimal getUnitPrice() {
	return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
	this.unitPrice = unitPrice;
    }

    public BigDecimal getQuantity() {
	return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
	this.quantity = quantity;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	CartItem other = (CartItem) obj;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	return true;
    }
}
