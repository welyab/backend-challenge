package com.invillia.acme.rest.api;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.invillia.acme.data.model.Order;
import com.invillia.acme.rest.api.dto.OrderDto;
import com.invillia.acme.service.EntryNotFoundException;
import com.invillia.acme.service.OrderService;

@RestController
@RequestMapping(path = "orders")
@SuppressWarnings("javadoc")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(
	    path = "{orderId}",
	    produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<OrderDto> get(@PathVariable(name = "orderId") Long orderId) {
	return ResponseEntity.of(
		Optional.ofNullable(orderService.findById(orderId))
			.map(OrderDto::new)
	);
    }

    @PostMapping(
	    path = "/cart/{cartId}",
	    produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
	    consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public ResponseEntity<OrderDto> createOrder(
	    @PathVariable(name = "cartId") Long cartId
    ) throws EntryNotFoundException {
	Order order = orderService.createOrder(cartId);
	OrderDto orderDto = new OrderDto(order);
	return ResponseEntity
		.created(
			linkTo(methodOn(OrderController.class).get(order.getId())).toUri()
		).body(orderDto);
    }
}
