package com.acmefresh.service;

import java.util.List;

import com.acmefresh.exception.VegetableException;
import com.acmefresh.model.Vegetable;


public interface VegetableService {

	public Vegetable saveVegetable(Vegetable vegetable, String key) throws VegetableException;
	
	public Vegetable updateVegetable(Vegetable vegetable, String key) throws VegetableException;
	
	public String deleteVegetable(Integer vegetableId, String key) throws VegetableException;
	
	public List<Vegetable> getAllVegetables() throws VegetableException;
}
