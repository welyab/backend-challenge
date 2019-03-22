package com.invillia.acme.cart;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * A spring component for create instances of <code>ShopppingCart</code>. The created instances have
 * the scope of session (HTTP context).
 *
 * @author Welyab Paula
 */
@Component
public class ShoppingCartProducer {

	/**
	 * Creates a new shopping cart object managed by Spring, with scope of <i>session</i> (HTTP
	 * context).
	 *
	 * @return The shopping cat.
	 */
	@Bean
	@Scope(WebApplicationContext.SCOPE_SESSION)
	public ShoppingCart createShoppingCart() {
		return new ShoppingCart();
	}
}
