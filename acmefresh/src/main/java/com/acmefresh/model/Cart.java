package com.acmefresh.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartId;
	
	private Integer vegetableId;
	
	private String image;
	
	private String name;
	
	private Integer quantity;
	
	private Double price;
	
	private Double total;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	public Cart(Integer vegetableId, String image, String name, Double price) {
		super();
		this.vegetableId = vegetableId;
		this.image = image;
		this.name = name;
		this.price = price;
	}



	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Integer getVegetableId() {
		return vegetableId;
	}

	public void setVegetableId(Integer vegetableId) {
		this.vegetableId = vegetableId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	
	
	
	
}
