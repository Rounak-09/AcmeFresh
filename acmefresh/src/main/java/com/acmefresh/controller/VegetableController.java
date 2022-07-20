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

import com.acmefresh.model.Vegetable;
import com.acmefresh.service.VegetableService;

@RestController
public class VegetableController {
	
	@Autowired
	private VegetableService vegetableService;

	@PostMapping("/admin/vegetables")
	public ResponseEntity<Vegetable> saveVegetableHandler(@Valid @RequestBody  Vegetable vegetable,@RequestHeader String key){
			
		Vegetable savedVegetable = vegetableService.saveVegetable(vegetable,key);
		return new ResponseEntity<Vegetable>(savedVegetable,HttpStatus.CREATED);
	}
	
	@PutMapping("/admin/vegetables")
	public ResponseEntity<Vegetable> updateVegetableHandler(@Valid @RequestBody  Vegetable vegetable,@RequestHeader String key){
			
		Vegetable updatedVegetable = vegetableService.updateVegetable(vegetable,key);
		return new ResponseEntity<Vegetable>(updatedVegetable,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/vegetables")
	public ResponseEntity<List<Vegetable>> getAllVegetablesHandler(){
		
		List<Vegetable> vegetables = vegetableService.getAllVegetables();
		return new ResponseEntity<List<Vegetable>>(vegetables,HttpStatus.OK);
	}
	
	@DeleteMapping("/admin/vegetables")
	public ResponseEntity<String> deleteVegetableHandler(@RequestBody  Integer vegetableId,@RequestHeader String key){
			
		String response = vegetableService.deleteVegetable(vegetableId,key);
		return new ResponseEntity<String>(response,HttpStatus.ACCEPTED);
	}
}
