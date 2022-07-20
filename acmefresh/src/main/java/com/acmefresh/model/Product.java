package com.acmefresh.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	@NotNull
	private String image;
	@NotNull
	private String name;
	@NotNull
	private String description;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(@NotNull String image, @NotNull String name, @NotNull String description) {
		super();
		this.image = image;
		this.name = name;
		this.description = description;
	}






	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
