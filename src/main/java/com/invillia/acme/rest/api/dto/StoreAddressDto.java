package com.invillia.acme.rest.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.invillia.acme.data.model.StoreAddress;

/**
 * A DTO for sharing information about <code>StoreAddress</code>.
 * 
 * @author Welyab Paula
 */
public class StoreAddressDto {

	@JsonProperty("public-place")
	@SuppressWarnings("javadoc")
	private String publicPlace;

	@JsonProperty("number")
	@SuppressWarnings("javadoc")
	private String number;

	@JsonProperty("complementary-info")
	@SuppressWarnings("javadoc")
	private String complementaryInfo;

	@JsonProperty("city-name")
	@SuppressWarnings("javadoc")
	private String cityName;

	@JsonProperty("country-name")
	@SuppressWarnings("javadoc")
	private String countryName;

	@JsonProperty("state-name")
	@SuppressWarnings("javadoc")
	private String stateName;

	@JsonProperty("postal-code")
	@SuppressWarnings("javadoc")
	private String postalCode;

	@SuppressWarnings("javadoc")
	public StoreAddressDto() {
	}

	@SuppressWarnings("javadoc")
	public StoreAddressDto(StoreAddress address) {
		if (address != null) {
			publicPlace = address.getPublicPlace();
			number = address.getNumber();
			complementaryInfo = address.getComplementaryInfo();
			cityName = address.getCityName();
			countryName = address.getCountryName();
			stateName = address.getStateName();
			postalCode = address.getPostalCode();
		}
	}

	@SuppressWarnings("javadoc")
	public String getPublicPlace() {
		return publicPlace;
	}

	@SuppressWarnings("javadoc")
	public void setPublicPlace(String publicPlace) {
		this.publicPlace = publicPlace;
	}

	@SuppressWarnings("javadoc")
	public String getNumber() {
		return number;
	}

	@SuppressWarnings("javadoc")
	public void setNumber(String number) {
		this.number = number;
	}

	@SuppressWarnings("javadoc")
	public String getComplementaryInfo() {
		return complementaryInfo;
	}

	@SuppressWarnings("javadoc")
	public void setComplementaryInfo(String complementaryInfo) {
		this.complementaryInfo = complementaryInfo;
	}

	@SuppressWarnings("javadoc")
	public String getCityName() {
		return cityName;
	}

	@SuppressWarnings("javadoc")
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	@SuppressWarnings("javadoc")
	public String getCountryName() {
		return countryName;
	}

	@SuppressWarnings("javadoc")
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@SuppressWarnings("javadoc")
	public String getPostalCode() {
		return postalCode;
	}

	@SuppressWarnings("javadoc")
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@SuppressWarnings("javadoc")
	public String getStateName() {
		return stateName;
	}

	@SuppressWarnings("javadoc")
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	/**
	 * Converts this DTO in a <code>StoreAddress</code> object.
	 * 
	 * @return The store address.
	 */
	public StoreAddress toAddress() {
		StoreAddress address = new StoreAddress();
		address.setCityName(getCityName());
		address.setComplementaryInfo(getComplementaryInfo());
		address.setCountryName(getCountryName());
		address.setNumber(getNumber());
		address.setPostalCode(getPostalCode());
		address.setPublicPlace(getPublicPlace());
		address.setStateName(getStateName());
		return address;
	}
}
