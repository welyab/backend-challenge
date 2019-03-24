package com.invillia.acme.data.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Representive class for shopping cart.
 * 
 * @author Welyab Paula
 */
@Entity
@Table(name = "cart")
public class Cart implements Serializable {

    @SuppressWarnings("javadoc")
    private static final long serialVersionUID = 1L;

    /**
     * Database identifier for this entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * The store which this cart is associated.
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "id_store", nullable = false)
    private Store store;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<CartItem> items;

    public Cart() {
    }

    public Cart(Long id) {
	this.id = id;
    }

    /**
     * Retrieves the database identification for this cart.
     * 
     * @return The database identification, if any.
     */
    public Long getId() {
	return id;
    }

    /**
     * Adjusts the database identification for this cart.
     * 
     * @param id The database identification.
     */
    public void setId(Long id) {
	this.id = id;
    }

    /**
     * Retrieves the store for which this cart is associated.
     * 
     * @return The store object.
     */
    public Store getStore() {
	return store;
    }

    /**
     * Adjusts the store for which this cart is associated.
     * 
     * @param store The store.
     */
    public void setStore(Store store) {
	this.store = store;
    }

    public List<CartItem> getItems() {
	return items;
    }

    public void setItems(List<CartItem> items) {
	this.items = items;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (id == null ? 0 : id.hashCode());
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
	Cart other = (Cart) obj;
	if (id == null) {
	    if (other.id != null) {
		return false;
	    }
	} else if (!id.equals(other.id)) {
	    return false;
	}
	return true;
    }

}
