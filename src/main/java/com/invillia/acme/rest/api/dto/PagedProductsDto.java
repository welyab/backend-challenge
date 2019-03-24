package com.invillia.acme.rest.api.dto;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonProperty;

@SuppressWarnings("javadoc")
public class PagedProductsDto extends ResourceSupport {

    @JsonProperty("products")
    private List<ProductDto> stores;

    @JsonProperty("page-total-itens")
    private int pageTotalItems;

    @JsonProperty("page-number")
    private int pageNumber;

    @JsonProperty("page-size")
    private int pageSize;

    @JsonProperty("total-items")
    private int totalItems;

    public List<ProductDto> getStores() {
	return stores;
    }

    public void setStores(List<ProductDto> stores) {
	this.stores = stores;
    }

    public int getPageTotalItems() {
	return pageTotalItems;
    }

    public void setPageTotalItems(int pageTotalItems) {
	this.pageTotalItems = pageTotalItems;
    }

    public int getPageNumber() {
	return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
	this.pageNumber = pageNumber;
    }

    public int getPageSize() {
	return pageSize;
    }

    public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
    }

    public int getTotalItems() {
	return totalItems;
    }

    public void setTotalItems(int totalItems) {
	this.totalItems = totalItems;
    }
}
