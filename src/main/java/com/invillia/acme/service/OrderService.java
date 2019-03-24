package com.invillia.acme.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invillia.acme.data.model.Cart;
import com.invillia.acme.data.model.Order;
import com.invillia.acme.data.model.OrderItem;
import com.invillia.acme.data.repository.CartRepository;
import com.invillia.acme.data.repository.OrderRepository;

/**
 * Operations with <code>Order</code> objects.
 *
 * @author Welyab Paula
 */
@Service
public class OrderService {

    @Autowired
    @SuppressWarnings("javadoc")
    private CartRepository cartRepository;

    @Autowired
    @SuppressWarnings("javadoc")
    private OrderRepository orderRepository;

    public Order createOrder(Long cartId) throws EntryNotFoundException {
	Optional<Cart> cart = cartRepository.findById(cartId);
	if (!cart.isPresent()) {
	    throw new EntryNotFoundException(String.format("Cart not found with id %d", cartId));
	}
	Order order = new Order();
	List<OrderItem> orderItems = cart
		.get()
		.getItems()
		.stream()
		.map(OrderItem::new)
		.map(i -> {
		    i.setOrder(order);
		    return i;
		})
		.collect(Collectors.toList());
	order.setItems(orderItems);
	order.setOrderDate(LocalDateTime.now());
	orderRepository.save(order);
	cartRepository.delete(cart.get());
	return order;
    }

    public Order findById(Long orderId) {
	return orderRepository.findById(orderId).orElse(null);
    }
}
