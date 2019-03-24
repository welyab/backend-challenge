package com.invillia.acme.data.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The representative class for a <code>Store</code>.
 *
 * @author Welyab Paula
 */
@Entity
@Table(name = "store")
public class Store implements Serializable {

	@SuppressWarnings("javadoc")
	private static final long serialVersionUID = 1L;

	/**
	 * Store identifier.
	 *
	 * @see UUID
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(
		name = "code",
		nullable = false,
		length = 10
	)
	private Long id;

	/**
	 * The name of this store entry.
	 *
	 * <p>
	 * Values <code>null</code> can't be persisted.
	 */
	@Column(
		name = "name",
		length = 60,
		nullable = false
	)
	@JsonProperty(value = "name")
	private String name;

	/**
	 * The location address for this store.
	 */
	@OneToOne(
		optional = false,
		mappedBy = "store",
		cascade = CascadeType.ALL
	)
	@JsonProperty(value = "address")
	private StoreAddress address;

	/**
	 * Creates a new <code>Store</code> object.
	 */
	public Store() {
	}

	/**
	 * Creates a new <code>Store</code> object using given <code>id</code>
	 * parameter.
	 * 
	 * @param id The database identification for the being created store.
	 */
	public Store(Long id) {
		this.id = id;
	}

	/**
	 * Retrieves the code identifier of this store.
	 *
	 * <p>
	 * The code identifier is an <code>UUID</code> generated randomly during
	 * entry persistence.
	 *
	 * @return The code value.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Adjusts the code identifier of this store.
	 *
	 * @param code The code value.
	 */
	public void setId(Long code) {
		this.id = code;
	}

	/**
	 * Retrieves the registered name for this store.
	 *
	 * @return The store name. May return <code>null</code> for brand new
	 *         objects.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Adjusts the name value for this store.
	 *
	 * @param name The store name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retrieves the location address of this store.
	 *
	 * @return The address.
	 */
	public StoreAddress getAddress() {
		return address;
	}

	/**
	 * Adjusts the address.
	 *
	 * @param address The address.
	 */
	public void setAddress(StoreAddress address) {
		this.address = address;
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
		Store other = (Store) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Store [name=" + name + "]";
	}
}
