package com.acmefresh.service;

import java.util.List;

import com.acmefresh.exception.ProductException;
import com.acmefresh.model.Product;


public interface ProductService {

	public Product saveProduct(Product product, String key) throws ProductException;
	
	public Product updateProduct(Product product, String key) throws ProductException;
	
	public String deleteProduct(Integer productId, String key) throws ProductException;
	
	public List<Product> getAllProducts() throws ProductException;
}
