package com.invillia.acme.rest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;

import com.invillia.acme.service.OrderService;

/**
 * REST services for <code>Order</code> class.
 *
 * @author Welyab Paula
 *
 * @see OrderService
 */
public class OrderController {

	@Autowired
	@SuppressWarnings("javadoc")
	private OrderService orderService;

	@PatchMapping("{code}")
	public void addItem(ItemDto itemDto) {
	}
}
