package com.acmefresh.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acmefresh.exception.ProductException;
import com.acmefresh.model.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

	public Optional<Product> findByProductId(Integer productId) throws ProductException;
}
