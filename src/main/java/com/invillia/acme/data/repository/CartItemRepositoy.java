package com.invillia.acme.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.invillia.acme.data.model.Cart;
import com.invillia.acme.data.model.CartItem;
import com.invillia.acme.data.model.Product;

public interface CartItemRepositoy extends JpaRepository<CartItem, Long> {

    public void deleteByCartAndProduct(Cart cart, Product product);

    public List<CartItem> findByCart(Cart cart);
}
