package com.acmefresh.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acmefresh.exception.VegetableException;
import com.acmefresh.model.Vegetable;

public interface VegetableDao extends JpaRepository<Vegetable, Integer> {

	public Optional<Vegetable> findByVegetableId(Integer vegetableId) throws VegetableException;

}
