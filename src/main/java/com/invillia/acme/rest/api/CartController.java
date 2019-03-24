package com.invillia.acme.rest.api;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.acme.cart.CartItem;
import com.invillia.acme.cart.ShoppingCart;
import com.invillia.acme.data.model.Product;

/**
 * REST endpoints for shopping cart manipulation.
 * 
 * @author Welyab Paula
 */
@RestController
@RequestMapping(path = "/cart")
public class CartController {

	@Autowired
	@SuppressWarnings("javadoc")
	private ShoppingCart cart;

	/**
	 * Retrieves all items currently stored in the cart.
	 * 
	 * @return The HTTP entity.
	 */
	@GetMapping(path = "/items")
	public HttpEntity<List<ItemDto>> getItems() {
		return ResponseEntity.ok(
			cart.getItems()
				.stream()
				.map(ItemDto::new)
				.map(p -> {
					fillLinks(p);
					return p;
				})
				.collect(Collectors.toList())
		);
	}

	@GetMapping(params = "/items/{productCode}")
	public HttpEntity<ItemDto> get(@PathVariable(name = "productCode") String productCode) {
		if (!cart.containsProduct(productCode)) {
			return (HttpEntity<ItemDto>) ResponseEntity.notFound();
		}
		CartItem cartItem = cart.getItem(productCode);
		ItemDto itemDto = new ItemDto(cartItem);
		fillLinks(itemDto);
		return ResponseEntity.ok(itemDto);
	}

	/**
	 * Adds a new, and only new, intem into the cart.
	 * 
	 * @param productCode
	 * 
	 * @param item The item to be added.
	 * 
	 * @return
	 */
	@PutMapping(path = "/items/{productCode}")
	public HttpEntity<ItemDto> addItem(
		@PathVariable(name = "productCode") String productCode,
		@RequestBody ItemDto item
	) {
		if (cart.containsProduct(item.getProductCode())) {
		}

		cart.addItem(
			new Product(item.getProductCode(), item.getProductDescription()),
			item.getUnitPrice(),
			item.getQuantity()
		);

		fillLinks(item);
		return ResponseEntity
			.created(getLinkBuilderSelfRel(item).toUri())
			.body(item);
	}

	private ControllerLinkBuilder getLinkBuilderSelfRel(ItemDto item) {
		return linkTo(methodOn(StoreController.class).getStore(item.getProductCode()));
	}

	private void fillLinks(ItemDto item) {
		item.add(getLinkBuilderSelfRel(item).withSelfRel());
	}
}
