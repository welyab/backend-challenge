package com.invillia.acme.rest.api;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.acme.data.model.Cart;
import com.invillia.acme.rest.api.dto.CartDto;
import com.invillia.acme.rest.api.dto.CartItemPatchDto;
import com.invillia.acme.service.CartService;
import com.invillia.acme.service.EntryNotFoundException;
import com.invillia.acme.service.IdPresentException;

/**
 * REST endpoints for operations with <code>Cart</code>.
 * 
 * @author Welyab Paula
 */
@RestController
@RequestMapping("carts")
public class CartController {

    @Autowired
    @SuppressWarnings("javadoc")
    private CartService cartService;

    /**
     * Retrieves the specified cart.
     * 
     * @param cartId The cart identification.
     * 
     * @return A response with cart current state.
     * 
     * @throws EntryNotFoundException If the cart with specific id does not
     *             exists in the system.
     */
    @GetMapping(
	    path = "{cartId}",
	    produces = MediaType.APPLICATION_JSON_VALUE,
	    consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<CartDto> get(
	    @PathVariable(name = "cartId") Long cartId
    ) throws EntryNotFoundException {
	Cart cart = cartService.findById(cartId);
	if (cart == null) {
	    throw new EntryNotFoundException(String.format("Cart not found: ID = %d", cartId));
	}
	return ResponseEntity.ok(fillCommonLinks(new CartDto(cart)));
    }

    /**
     * Update the cart by adding removing the specified product.
     * 
     * <p>
     * If the informed quantity is zero or less, than the product is removed
     * from the cart. Positive quantities will replace the current quantity in
     * the cart for given product.
     * 
     * @param cartId The cart to be updated.
     * @param cartItemDto The item information.
     * 
     * @return HTTP response.
     * 
     * @throws EntryNotFoundException If the specified cart is not found in the
     *             system.
     */
    @PatchMapping(
	    path = "{cartId}",
	    produces = MediaType.APPLICATION_JSON_VALUE,
	    consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<CartDto> updateItem(
	    @PathVariable(name = "cartId") Long cartId,
	    CartItemPatchDto cartItemDto
    ) throws EntryNotFoundException {
	cartService.updateItem(
		cartId,
		cartItemDto.getProductId(),
		cartItemDto.getQuantity()
	);

	Cart cart = cartService.findById(cartId);
	CartDto cartDto = new CartDto(cart);
	fillCommonLinks(cartDto);
	return ResponseEntity.ok(cartDto);
    }

    /**
     * Creates a new cart for adding items.
     * 
     * @param cartDto The cart initial information.
     * 
     * @return A response with cart information.
     * 
     * @throws IdPresentException If the informed cart already have an
     *             identification.
     */
    @PostMapping(
	    produces = MediaType.APPLICATION_JSON_VALUE,
	    consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<CartDto> createCart(
	    @RequestBody CartDto cartDto
    ) throws IdPresentException {
	Cart cart = cartService.save(cartDto.toCart());
	cartDto = new CartDto(cart);

	return ResponseEntity
		.created(getLinkBuilderForSelfRef(cartDto).toUri())
		.body(fillCommonLinks(cartDto));
    }

    @SuppressWarnings("javadoc")
    private ControllerLinkBuilder getLinkBuilderForSelfRef(CartDto cartDto) {
	try {
	    return linkTo(methodOn(CartController.class).get(cartDto.getCartId()));
	} catch (EntryNotFoundException e) {
	    // ignore
	    throw new RuntimeException(e);
	}
    }

    @SuppressWarnings("javadoc")
    private CartDto fillCommonLinks(CartDto cartDto) {
	try {
	    cartDto.add(getLinkBuilderForSelfRef(cartDto).withSelfRel());
	    cartDto.add(
		    linkTo(methodOn(CartController.class).updateItem(cartDto.getCartId(), null)).withRel("addItem")
	    );
	} catch (EntryNotFoundException e) {
	    // ignore
	    throw new RuntimeException(e);
	}
	return cartDto;
    }
}
