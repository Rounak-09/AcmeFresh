package com.acmefresh.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;
	@NotBlank
	private String image;
	@NotBlank
	private String name;
	@NotBlank
	private String description;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product(@NotBlank String image, @NotBlank String name, @NotBlank String description) {
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
