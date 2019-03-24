package com.invillia.acme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.invillia.acme.data.model.Product;
import com.invillia.acme.data.repository.ProductRepository;

@Service
@SuppressWarnings("javadoc")
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Page<Product> findAllPaged(int pageNumber) {
	return productRepository.findAll(PageRequest.of(pageNumber, 5));
    }

    public Product findById(Long id) {
	return productRepository.findById(id).orElse(null);
    }
}
