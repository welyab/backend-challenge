package com.invillia.acme.rest.api.dto;

import java.util.Optional;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.invillia.acme.data.model.Store;

/**
 * A DTO for sharing <code>Store</code> information.
 * 
 * @author Welyab Paula
 */
public class StoreDto extends ResourceSupport {

	@JsonProperty("id")
	@SuppressWarnings("javadoc")
	private Long code;

	@JsonProperty("name")
	@SuppressWarnings("javadoc")
	private String name;

	@JsonProperty("address")
	@SuppressWarnings("javadoc")
	private StoreAddressDto address;

	@SuppressWarnings("javadoc")
	public StoreDto() {
	}

	@SuppressWarnings("javadoc")
	public StoreDto(Store store) {
		if (store != null) {
			code = store.getId();
			name = store.getName();
			address = Optional
				.ofNullable(store.getAddress())
				.map(StoreAddressDto::new)
				.orElse(null);
		}
	}

	@SuppressWarnings("javadoc")
	public Long getCode() {
		return code;
	}

	@SuppressWarnings("javadoc")
	public void setCode(Long id) {
		this.code = id;
	}

	@SuppressWarnings("javadoc")
	public String getName() {
		return name;
	}

	@SuppressWarnings("javadoc")
	public void setName(String name) {
		this.name = name;
	}

	@SuppressWarnings("javadoc")
	public StoreAddressDto getAddress() {
		return address;
	}

	@SuppressWarnings("javadoc")
	public void setAddress(StoreAddressDto address) {
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
		StoreDto other = (StoreDto) obj;
		if (code == null) {
			if (other.code != null) {
				return false;
			}
		} else if (!code.equals(other.code)) {
			return false;
		}
		return true;
	}

	/**
	 * Converts this DTO in a <code>Store</code> object.
	 * 
	 * @return The <code>Store</code> object.
	 */
	public Store toStore() {
		Store store = new Store();
		store.setId(getCode());
		store.setName(getName());
		store.setAddress(
			Optional
				.ofNullable(getAddress())
				.map(StoreAddressDto::toAddress)
				.orElse(null)
		);
		if (store.getAddress() != null) {
			store.getAddress().setStore(store);
		}
		return store;
	}
}
