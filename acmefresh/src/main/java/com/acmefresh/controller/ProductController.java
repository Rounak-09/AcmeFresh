package com.acmefresh.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.acmefresh.model.Product;
import com.acmefresh.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/admin/products")
	public ResponseEntity<Product> saveProductHandler(@Valid @RequestBody  Product product,@RequestHeader String key){
			
		Product savedProduct = productService.saveProduct(product,key);
		return new ResponseEntity<Product>(savedProduct,HttpStatus.CREATED);
	}
	
	@PutMapping("/admin/products")
	public ResponseEntity<Product> updateProductHandler(@Valid @RequestBody  Product product,@RequestHeader String key){
			
		Product updatedProduct = productService.updateProduct(product,key);
		return new ResponseEntity<Product>(updatedProduct,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProductsHandler(){
		
		List<Product> products = productService.getAllProducts();
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
	}
	
	@DeleteMapping("/admin/products")
	public ResponseEntity<String> deleteVegetableHandler(@RequestBody  Integer productId,@RequestHeader String key){
			
		String response = productService.deleteProduct(productId,key);
		return new ResponseEntity<String>(response,HttpStatus.ACCEPTED);
	}
}
