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

/**
 *
 * @author Welyab Paula
 */
@Entity
public class City implements Serializable {

	@SuppressWarnings("javadoc")
	private static final long serialVersionUID = 1L;

	/**
	 * Database identifier for <code>City</code> entries.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	/**
	 * The city name.
	 */
	@Column(
		name = "name",
		length = 60,
		nullable = false
	)
	private String name;

	/**
	 * The state/province where this city is located.
	 */
	@ManyToOne(
		optional = false,
		cascade = CascadeType.PERSIST
	)
	@JoinColumn(
		name = "id_state",
		nullable = false
	)
	private State state;

	/**
	 * Retrieves the database identifier for this city.
	 *
	 * @return The identifier.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Adjusts the database identifier for this city.
	 *
	 * @param id The identifier.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Retrieves the name of this city.
	 *
	 * @return The name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Adjusts the name of this city.
	 *
	 * @param name The name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Retrieves the state where this city located.
	 *
	 * @return The state object.
	 */
	public State getState() {
		return state;
	}

	/**
	 * Adjusts the state where this city is located.
	 *
	 * @param state The state.
	 */
	public void setState(State state) {
		this.state = state;
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
		City other = (City) obj;
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
		return "City [id=" + id + ", name=" + name + "]";
	}
}
