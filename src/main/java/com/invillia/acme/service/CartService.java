package com.invillia.acme.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.invillia.acme.data.model.Cart;
import com.invillia.acme.data.model.CartItem;
import com.invillia.acme.data.model.Product;
import com.invillia.acme.data.repository.CartItemRepositoy;
import com.invillia.acme.data.repository.CartRepository;
import com.invillia.acme.data.repository.ProductRepository;

/**
 * REST endpoints for operations with <code>Cart</code>.
 * 
 * @author Welyab Paula
 */
@Service
public class CartService {

    @Autowired
    @SuppressWarnings("javadoc")
    private CartRepository cartRepository;

    @Autowired
    @SuppressWarnings("javadoc")
    private CartItemRepositoy cartItemRepositoy;

    @Autowired
    @SuppressWarnings("javadoc")
    private ProductRepository productRepository;

    /**
     * Saves the information.
     * 
     * @param cart The cart.
     * @return The saved cart. It is recommend to use this instance.
     * @throws IdPresentException If the informed cart already have an
     *             identification.
     */
    public Cart save(Cart cart) throws IdPresentException {
	Preconditions.checkNotNull(cart, "cart");
	if (cart.getId() != null) {
	    throw new IdPresentException(String.format("ID: %d", cart.getId()));
	}
	return cartRepository.save(cart);
    }

    /**
     * Retrieves the cart with specific identification.
     * 
     * @param cartId The cart identification.
     * @return The cart information. May return <code>null</code> if there is
     *         not cart with informed identification.
     */
    public Cart findById(Long cartId) {
	return cartRepository.findById(cartId).orElse(null);
    }

    /**
     * Adds or removes the informed product from the cart.
     * 
     * <p>
     * If the informed quantity is zero or less, than the product is removed
     * from the cart. But if the quantity is positive, than the product is added
     * to the cart, and quantity will be the new informed quantity parameter.
     * 
     * @param cartId The cart to be updated.
     * @param productId The product to be added or removed from the cart.
     * @param quantity The new quantity.
     * @throws EntryNotFoundException If the there is no cart with specific
     *             identification.
     */
    public void updateItem(
	    Long cartId,
	    Long productId,
	    BigDecimal quantity
    ) throws EntryNotFoundException {
	if (!cartItemRepositoy.existsById(cartId)) {
	    throw new EntryNotFoundException(String.format("Cart not found: ID = %d", cartId));
	}
	cartItemRepositoy.deleteByCartAndProduct(
		new Cart(cartId),
		new Product(productId)
	);
	if (quantity.compareTo(BigDecimal.ZERO) > 0) {
	    CartItem cartItem = new CartItem();
	    cartItem.setProduct(new Product(productId));
	    cartItem.setCart(new Cart(cartId));
	    cartItem.setUnitPrice(productRepository.findUnitPriceById(productId));
	    cartItemRepositoy.save(cartItem);
	}
    }
}
