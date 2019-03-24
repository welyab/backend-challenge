package com.invillia.acme.cart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import com.google.common.base.Preconditions;
import com.invillia.acme.data.model.Product;

/**
 * The shopping cart for storing items.
 *
 * @author Welyab Paula
 */
public class ShoppingCart {

	/**
	 * The <code>long</code> type maximum value as <code>BigDecimal</code>
	 * instance.
	 */
	private static final BigDecimal MAX_LONG = new BigDecimal(Long.toString(Long.MAX_VALUE));

	@SuppressWarnings("javadoc")
	private List<CartItem> items;

	@SuppressWarnings("javadoc")
	public ShoppingCart() {
		items = new ArrayList<>();
	}

	/**
	 * Adds the product into the cart.
	 *
	 * <p>
	 * If the cart already have the product, the quantity will be added to the
	 * current product in
	 * the cart, and the unit price will be the price passed as parameter.
	 *
	 * @param product The product to be added into the cart.
	 * @param unitPrice The product's unit price.
	 * @param quantity The amount of the product.
	 *
	 * @throws NullPointerException In the case of any parameter be informed as
	 *             <code>null</code>.
	 */
	public void addItem(Product product, BigDecimal unitPrice, BigDecimal quantity) {
		Preconditions.checkNotNull(product, "product");
		Preconditions.checkNotNull(unitPrice, "unitPrice");
		Preconditions.checkNotNull(quantity, "quantity");
		Preconditions.checkArgument(
			unitPrice.compareTo(BigDecimal.ZERO) > 0,
			"Parameter 'unitPrice' should be greater than 0"
		);
		Preconditions.checkArgument(
			quantity.compareTo(BigDecimal.ZERO) > 0,
			"Parameter 'quantity' should be greater than 0"
		);

		int index = indexByProduct(product);
		if (index >= 0) {
			CartItem currentItem = items.get(index);
			CartItem mergedItem = currentItem.merge(product, unitPrice, quantity);
			if (mergedItem.getQuantity().compareTo(MAX_LONG) > 0) {
				throw new InvalidQuantityException(
					String.format("The quantity of product in the cat cannot exceed %d", Long.MAX_VALUE)
				);
			}
			items.set(index, mergedItem);
		} else {
			items.add(new CartItem(product, unitPrice, quantity));
		}
	}

	/**
	 * Remove the given product from the shopping cart.
	 *
	 * @param product The product to remove
	 *
	 * @throws NullPointerException If the <code>product</code> parameter is
	 *             <code>null</code>.
	 */
	public void removeItem(Product product) {
		Preconditions.checkNotNull(product, "product");
		removeItem(product, new BigDecimal(Long.toString(Long.MAX_VALUE)));
	}

	/**
	 * Remove the given quantity of specific product from the cart. If the final
	 * quantity in the
	 * cart turns less or equals zero, the product is removed from the cart.
	 *
	 * @param product The product.
	 * @param quantity The quantity to remove. Must be a positive value.
	 *
	 * @throws NullPointerException If any of parameters is informed
	 *             <code>null</code>.
	 * @throws IllegalArgumentException If the parameter <code>quantity</code>
	 *             is negative.
	 */
	public void removeItem(Product product, BigDecimal quantity) {
		Preconditions.checkNotNull(product, "product");
		Preconditions.checkNotNull(quantity, "quantity");
		Preconditions.checkArgument(
			quantity.compareTo(BigDecimal.ZERO) > 0,
			"Parameter 'quantity' should be positive"
		);
		int index = indexByProduct(product);
		if (index >= 0) {
			CartItem item = items.get(index);
			BigDecimal targetQuantity = item.getQuantity().subtract(quantity);
			if (targetQuantity.compareTo(BigDecimal.ZERO) > 0) {
				items.set(index, new CartItem(product, item.getUnitPrice(), targetQuantity));
			} else {
				items.remove(index);
			}
		}
	}

	/**
	 * Evaluates if there is in the cart some with specified product.
	 *
	 * @param product The product being searched for.
	 *
	 * @return A value <code>true</code> if the cart has the specific product,
	 *         or <code>false</code>
	 *         otherwise.
	 */
	public boolean contains(Product product) {
		Preconditions.checkNotNull(product, "product");
		return containsProduct(product.getCode());
	}

	public boolean containsProduct(String productCode) {
		return indexByProduct(productCode) >= 0;
	}

	/**
	 * Retrieves the item at position indicated by <code>index</code> parameter.
	 *
	 * <p>
	 * The first index é <code>0</code> (zero). And the ordering of the items
	 * inside cart is the
	 * order where they are inserted. A insertion of a previously existent
	 * product don't change its
	 * position.
	 *
	 * @param index The item index.
	 *
	 * @return The item at the specified index.
	 *
	 * @throws IndexOutOfBoundsException If the index is out from bounds of cart
	 *             size.
	 */
	public CartItem getItem(int index) {
		return items.get(index);
	}

	/**
	 * Retrieves the size of this cart in number of unique products.
	 *
	 * @return The cart size, in number of unique products.
	 */
	public int size() {
		return items.size();
	}

	/**
	 * Retrieves index of <code>CartItem</code> object in the {@link #items}
	 * list.
	 *
	 * @param product The product being searched for.
	 *
	 * @return The index, or <code>-1</code> if the product is not in the
	 *         <code>items</code> array.
	 */
	private int indexByProduct(Product product) {
		return indexByProduct(product.getCode());
	}

	public List<CartItem> getItems() {
		return new ArrayList<>(items);
	}

	private int indexByProduct(String productCode) {
		return IntStream
			.range(0, items.size())
			.filter(i -> items.get(i).getProduct().getProductCode().equals(productCode))
			.findFirst()
			.orElse(-1);
	}

	public CartItem getItem(String productCode) {
		int index = indexByProduct(productCode);
		if (index < 0) {
			throw new ItemNotFoundException(productCode);
		}
		return items.get(index);
	}
}
