package com.invillia.acme.data.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The representative class for a <code>Store</code>.
 *
 * @author Welyab Paula
 */
@Entity
@Table(name = "store")
public class Store extends ResourceSupport implements Validated, Serializable {

	@SuppressWarnings("javadoc")
	private static final long serialVersionUID = 1L;

	/**
	 * Store identifier.
	 *
	 * @see UUID
	 */
	@Id
	@Column(
		name = "code",
		nullable = false,
		length = 10
	)
	private String code;

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
	 * Retrieves the code identifier of this store.
	 *
	 * <p>
	 * The code identifier is an <code>UUID</code> generated randomly during
	 * entry persistence.
	 *
	 * @return The code value.
	 *
	 * @see UUID
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Adjusts the code identifier of this store.
	 *
	 * @param code The code value.
	 */
	public void setCode(String code) {
		this.code = code;
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
		int result = super.hashCode();
		result = prime * result + (code == null ? 0 : code.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Store other = (Store) obj;
		if (code == null) {
			if (other.code != null) {
				return false;
			}
		} else if (!code.equals(other.code)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Store [name=" + name + "]";
	}
}
