package com.invillia.acme.rest.api.dto;

import java.math.BigDecimal;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.invillia.acme.data.model.Product;

@SuppressWarnings("javadoc")
public class ProductDto extends ResourceSupport {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("description")
    private String description;

    @JsonProperty("unit-price")
    private BigDecimal unitPrice;

    public ProductDto() {
    }

    public ProductDto(Product product) {
	if (product != null) {
	    id = product.getId();
	    description = product.getDescription();
	    unitPrice = product.getUnitPrice();
	}
    }

    public Long getIdentifier() {
	return id;
    }

    public void setIdentifier(Long id) {
	this.id = id;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public BigDecimal getUnitPrice() {
	return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
	this.unitPrice = unitPrice;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (!super.equals(obj))
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	ProductDto other = (ProductDto) obj;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	return true;
    }
}
