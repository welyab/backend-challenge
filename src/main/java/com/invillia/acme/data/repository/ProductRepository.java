package com.invillia.acme.data.repository;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    BigDecimal findUnitPriceById(Long id);
}
