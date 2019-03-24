package com.invillia.acme.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * This class represents a set of information about the address of some store.
 *
 * @author Welyab Paula
 */
@Entity
@Table(name = " store_address")
public class StoreAddress implements Serializable {

	@SuppressWarnings("javadoc")
	private static final long serialVersionUID = 1L;

	/**
	 * The database identifier for this
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	/**
	 * The underlying store associated with this address.
	 */
	@OneToOne(optional = false)
	@JoinColumn(
		name = "id_store",
		nullable = false
	)
	private Store store;

	/**
	 * The name of the public place where the store is located.
	 */
	@Column(
		name = "public_place",
		length = 40,
		nullable = false
	)
	private String publicPlace;

	/**
	 * The location indicator.
	 */
	@Column(
		name = "number",
		length = 10,
		nullable = false
	)
	private String number;

	/**
	 * Complementary information to the address of store.
	 */
	@Column(
		name = "complementary_info",
		length = 40
	)
	private String complementaryInfo;

	/**
	 * The city where this store is located.
	 */
	@Column(
		name = "city_name",
		length = 60,
		nullable = false
	)
	private String cityName;

	/**
	 * The name of the state/province where the city is located.
	 */
	@Column(
		name = "state_name",
		length = 60,
		nullable = false
	)
	private String stateName;

	/**
	 * The name of the address' country.
	 */
	@Column(
		name = "country_name",
		length = 60,
		nullable = false
	)
	private String countryName;

	/**
	 * The postal code.
	 */
	@Column(
		name = "postal_code",
		length = 20
	)
	private String postalCode;

	/**
	 * Retrieves the database identification for this address.
	 * .
	 *
	 * @return The identifier.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Adjusts the database identifier for this address.
	 *
	 * @param id The identifier.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Retrieves the store for which this address is associated.
	 *
	 * @return The store.
	 */
	public Store getStore() {
		return store;
	}

	/**
	 * Adjusts the store
	 *
	 * @param store
	 */
	public void setStore(Store store) {
		this.store = store;
	}

	/**
	 * Retrieves the public place name where the stored is located.
	 *
	 * @return The public place name.
	 */
	public String getPublicPlace() {
		return publicPlace;
	}

	/**
	 * Adjusts the public place where the store is located.
	 *
	 * @param publicPlace The name of public place.
	 */
	public void setPublicPlace(String publicPlace) {
		this.publicPlace = publicPlace;
	}

	/**
	 * Retrieves the complementary information to the store address.
	 *
	 * @return The complementary information.
	 */
	public String getComplementaryInfo() {
		return complementaryInfo;
	}

	/**
	 * Adjusts the complementary information of this address.
	 *
	 * @param complementaryInfo
	 */
	public void setComplementaryInfo(String complementaryInfo) {
		this.complementaryInfo = complementaryInfo;
	}

	/**
	 * Retrieves the location number, apartment/room number, etc.
	 * 
	 * @return The number.
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * Adjusts the location number, appartment/room number, etc.
	 * 
	 * @param number The number.
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * Retrieves the city name.
	 * 
	 * @return THe city name.
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * Adjusts the city name.
	 * 
	 * @param cityName The city name.
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	/**
	 * Retrieves the state/province name.
	 * 
	 * @return The state/province name.
	 */
	public String getStateName() {
		return stateName;
	}

	/**
	 * Adjusts the state/province name.
	 * 
	 * @param stateName The state/province name.
	 */
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	/**
	 * Retrieves the country name.
	 * 
	 * @return THe country name.
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * Adjusts the country name.
	 * 
	 * @param countryName The country name.
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	/**
	 * Retrieves the postal code of this code.
	 *
	 * @return The postal code.
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * Adjusts the postal code information of this address.
	 *
	 * @param postalCode The postal code.
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
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
		StoreAddress other = (StoreAddress) obj;
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
		return "StoreAddress [id=" + id + "]";
	}
}
