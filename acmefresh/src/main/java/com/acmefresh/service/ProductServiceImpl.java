package com.acmefresh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.acmefresh.exception.ProductException;
import com.acmefresh.model.AdminSession;
import com.acmefresh.model.Product;
import com.acmefresh.repository.AdminSessionDao;
import com.acmefresh.repository.ProductDao;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private AdminSessionDao adminSessionDao;

	@Override
	public Product saveProduct(Product product, String key) throws ProductException {
		// TODO Auto-generated method stub
		Optional<AdminSession> session  = adminSessionDao.findByUuid(key);
		if(session.isPresent()) {
			return productDao.save(product);
		}
		throw new ProductException("Only admin can add products.");
	}

	@Override
	public Product updateProduct(Product product, String key) throws ProductException {
		// TODO Auto-generated method stub
		Optional<AdminSession> session  = adminSessionDao.findByUuid(key);
		if(session.isPresent()) {
			Optional<Product> existingProduct= productDao.findByProductId(product.getProductId());
			if(existingProduct.isPresent()) {
				return productDao.save(product);
			}
			throw new ProductException("Product not found with productId: "+product.getProductId());
		}
		throw new ProductException("Only admin can update products.");
	}

	@Override
	public String deleteProduct(Integer productId, String key) throws ProductException {
		// TODO Auto-generated method stub
		Optional<AdminSession> session  = adminSessionDao.findByUuid(key);
		if(session.isEmpty()) {
			throw new ProductException("Only admin can delete products.");
		}
		Optional<Product> product= productDao.findByProductId(productId);
		if(product.isEmpty()) {
			throw new ProductException("Product not found with productId: "+productId);
		}
		productDao.delete(product.get());
		return "Product deleted";
	}

	@Override
	public List<Product> getAllProducts() throws ProductException {
		// TODO Auto-generated method stub
		List<Product> products= productDao.findAll();
		if(products.size()>0) {
			return products;
		}
		throw new ProductException("No products found");
	}

	


	
	
}
