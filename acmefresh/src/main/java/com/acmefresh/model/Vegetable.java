package com.acmefresh.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Vegetable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer vegetableId;
	
	@NotNull
	private String image;
	
	@NotNull
	private String name;
	
	@NotNull
	private Double price;
	
	@NotNull
	private Integer quantity;
	
	@NotNull
	private String unit;
	
	public Vegetable() {
		super();
		// TODO Auto-generated constructor stub
	}


	


	public Vegetable(@NotNull String image, @NotNull String name, @NotNull Double price, @NotNull Integer quantity,
			@NotNull String unit) {
		super();
		this.image = image;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.unit = unit;
	}





	public Integer getVegetableId() {
		return vegetableId;
	}

	public void setVegetableId(Integer vegetableId) {
		this.vegetableId = vegetableId;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	
}
