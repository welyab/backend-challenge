package com.invillia.acme.cart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.google.common.base.Preconditions;
import com.invillia.acme.data.model.Item;
import com.invillia.acme.data.model.Product;

/**
 * The shopping cart for storing items.
 * 
 * @author Welyab Paula
 */
@Component
@Scope(WebApplicationContext.SCOPE_SESSION)
public class ShoppingCart {

	private List<Item> items;

	public ShoppingCart() {
		items = new ArrayList<>();
	}

	public void addItem(Product product, BigDecimal unitPrice, BigDecimal quantity) {
		Preconditions.checkNotNull(product, "product");
		Preconditions.checkNotNull(unitPrice, "unitPrice");
		Preconditions.checkNotNull(quantity, "quantity");
	}

	/**
	 * Retrieves index of <code>Item</code> object in the {@link #items} list.
	 * 
	 * @param product The product being searched for.
	 * 
	 * @return The index, or <code>-1</code> if the product is not in the
	 *         <code>items</code> array.
	 */
	private int indexByProduct(Product product) {
		return IntStream
			.range(0, items.size())
			.filter(i -> items.get(i).getProduct().equals(product))
			.findFirst()
			.orElse(-1);
	}
}
