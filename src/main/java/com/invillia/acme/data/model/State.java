package com.invillia.acme.data.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * A state is a common political division in a country, sometimes called
 * province as well. This
 * class represents those divisions and some other kinds of country
 * organization.
 *
 * @author Welyab Paula
 */
@Entity
@Table(name = "state")
public class State implements Serializable {

	@SuppressWarnings("javadoc")
	private static final long serialVersionUID = 1L;

	/**
	 * Database identifier for <code>State</code> entries.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	/**
	 * The state/province name.
	 */
	@Column(
		name = "name",
		length = 60,
		nullable = false
	)
	private String name;

	/**
	 * The acronym representative for this state.
	 */
	@Column(
		name = "acronym",
		length = 10,
		nullable = false
	)
	private String acronym;

	/**
	 * The country where this state is located.
	 */
	@ManyToOne(
		optional = false,
		cascade = CascadeType.PERSIST
	)
	@JoinColumn(
		name = "id_country",
		nullable = false
	)
	private Country country;

	/**
	 * Retrieves database identifier for this state.
	 *
	 * @return The state database identifier.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Adjusts the database identifier for this state.
	 *
	 * @param id The database identifier.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Retrieves the state name.
	 *
	 * @return The name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Adjusts the name of this state.
	 *
	 * @param name The state name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retrieves the acronym information.
	 *
	 * @return The acronym.
	 */
	public String getAcronym() {
		return acronym;
	}

	/**
	 * Adjusts the acronym information for this state.
	 *
	 * @param acronym The acronym.
	 */
	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	/**
	 * Retrieves the country for which this state is associated.
	 *
	 * @return The country object.
	 */
	public Country getCountry() {
		return country;
	}

	/**
	 * Adjusts the country for which this is associated.
	 *
	 * @param country The country object.
	 */
	public void setCountry(Country country) {
		this.country = country;
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
		State other = (State) obj;
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
		return "State [id=" + id + ", name=" + name + "]";
	}
}
