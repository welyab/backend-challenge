package com.invillia.acme.data.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Order implements Serializable {

	@Id
	@Column(name = "code")
	private String code;

	@OneToMany
	@JoinColumn(name = "id_item")
	private List<Item> itens;

	public Order() {
		itens = new ArrayList<>();
	}

	@JsonProperty("total-price")
	public BigDecimal getTotalPrice() {
		return itens
			.stream()
			.map(i -> i.getQuantity().multiply(i.getUnitPrice()))
			.reduce((p1, p2) -> p1.add(p2))
			.orElse(BigDecimal.ZERO);
	}

	public void addItem(Product product, BigDecimal unitPrice, BigDecimal quantity) {
		Item item = itens
			.stream()
			.filter(i -> i.getProduct().getCode().equals(product.getCode()))
			.findFirst()
			.orElse(null);

		Item newItem = null;
		if (item != null) {
			newItem = item.merge(product, unitPrice, quantity);
		} else {
			newItem = new Item();
			newItem.setProduct(product);
			newItem.setQuantity(quantity);
			newItem.setUnitPrice(unitPrice);
		}

		itens.removeIf(i -> i.getProduct().getCode().equals(product.getCode()));
		itens.add(newItem);
	}
}
