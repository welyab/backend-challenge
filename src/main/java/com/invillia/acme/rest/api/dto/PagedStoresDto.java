package com.invillia.acme.rest.api.dto;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A DTO for paged lists of <code>Store</code> objects.
 * 
 * @author Welyab Paula
 */
public class PagedStoresDto extends ResourceSupport {

	@JsonProperty("stores")
	@SuppressWarnings("javadoc")
	private List<StoreDto> stores;

	@JsonProperty("page-total-itens")
	@SuppressWarnings("javadoc")
	private int pageTotalItems;

	@JsonProperty("page-number")
	@SuppressWarnings("javadoc")
	private int pageNumber;

	@JsonProperty("page-size")
	@SuppressWarnings("javadoc")
	private int pageSize;

	@JsonProperty("total-items")
	@SuppressWarnings("javadoc")
	private int totalItems;

	@SuppressWarnings("javadoc")
	public List<StoreDto> getStores() {
		return stores;
	}

	@SuppressWarnings("javadoc")
	public void setStores(List<StoreDto> stores) {
		this.stores = stores;
	}

	@SuppressWarnings("javadoc")
	public int getPageNumber() {
		return pageNumber;
	}

	@SuppressWarnings("javadoc")
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	@SuppressWarnings("javadoc")
	public int getPageSize() {
		return pageSize;
	}

	@SuppressWarnings("javadoc")
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@SuppressWarnings("javadoc")
	public int getTotalItems() {
		return totalItems;
	}

	@SuppressWarnings("javadoc")
	public void setTotalItems(int totalItems) {
		this.totalItems = totalItems;
	}

	@SuppressWarnings("javadoc")
	public int getPageTotalItems() {
		return pageTotalItems;
	}

	@SuppressWarnings("javadoc")
	public void setPageTotalItems(int pageTotalItems) {
		this.pageTotalItems = pageTotalItems;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + pageNumber;
		result = prime * result + pageSize;
		result = prime * result + pageTotalItems;
		result = prime * result + (stores == null ? 0 : stores.hashCode());
		result = prime * result + totalItems;
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
		PagedStoresDto other = (PagedStoresDto) obj;
		if (pageNumber != other.pageNumber) {
			return false;
		}
		if (pageSize != other.pageSize) {
			return false;
		}
		if (pageTotalItems != other.pageTotalItems) {
			return false;
		}
		if (stores == null) {
			if (other.stores != null) {
				return false;
			}
		} else if (!stores.equals(other.stores)) {
			return false;
		}
		if (totalItems != other.totalItems) {
			return false;
		}
		return true;
	}
}
