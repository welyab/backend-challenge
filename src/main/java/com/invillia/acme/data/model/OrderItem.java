package com.invillia.acme.data.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_item")
@SuppressWarnings("javadoc")
public class OrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_order")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

    @Column(name = "quantity")
    private BigDecimal quantity;

    @Column(name = "unit-price")
    private BigDecimal unitPrice;

    public OrderItem() {
    }

    public OrderItem(CartItem cartItem) {
	this.product = cartItem.getProduct();
	this.quantity = cartItem.getQuantity();
	this.unitPrice = cartItem.getUnitPrice();
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
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

    public Order getOrder() {
	return order;
    }

    public void setOrder(Order order) {
	this.order = order;
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
	OrderItem other = (OrderItem) obj;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	return true;
    }

}
