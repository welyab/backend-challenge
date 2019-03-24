package com.invillia.acme.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.invillia.acme.data.model.Cart;

@Repository
public interface CartRepository extends PagingAndSortingRepository<Cart, Long> {
}
