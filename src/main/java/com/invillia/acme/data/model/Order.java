package com.invillia.acme.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "\"order\"")
@SuppressWarnings("javadoc")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items;

    @Column(name = "order_date")
    private LocalDateTime orderDate;

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public List<OrderItem> getItems() {
	return items;
    }

    public void setItems(List<OrderItem> items) {
	this.items = items;
    }

    public BigDecimal getTotalPrice() {
	return Optional.ofNullable(getItems())
		.orElse(new ArrayList<>())
		.stream()
		.map(i -> i.getQuantity().multiply(i.getUnitPrice()))
		.reduce((p1, p2) -> p1.add(p2))
		.orElse(BigDecimal.ZERO);
    }

    public LocalDateTime getOrderDate() {
	return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
	this.orderDate = orderDate;
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
	Order other = (Order) obj;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	return true;
    }

}
