package com.invillia.acme.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Represents a set of information about some country.
 *
 * @author Welyab Paula
 */
@Entity
@Table(name = "country")
public class Country implements Serializable {

	@SuppressWarnings("javadoc")
	private static final long serialVersionUID = 1L;

	/**
	 * Database identifier for <code>Country</code> entries.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	/**
	 * The name of the country.
	 */
	@Column(
			name = "name",
			length = 60,
			nullable = false
	)
	private String name;

	/**
	 * Retrieves the country identifier.
	 *
	 * @return The identifier value.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Adjusts the country identifier.
	 *
	 * @param id The country identifier.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Retrieves the country name.
	 *
	 * @return The name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Adjusts the country name.
	 *
	 * @param name The name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (id == null ? 0 : id.hashCode());
		result = prime * result + (name == null ? 0 : name.hashCode());
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
		Country other = (Country) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + "]";
	}
}
