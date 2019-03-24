package com.invillia.acme.data.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.invillia.acme.data.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    BigDecimal findUnitPriceById(Long id);
}
