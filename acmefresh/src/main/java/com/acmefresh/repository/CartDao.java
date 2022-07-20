package com.acmefresh.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acmefresh.exception.CartException;
import com.acmefresh.model.Cart;

public interface CartDao extends JpaRepository<Cart, Integer> {

	public Optional<Cart> findByVegetableId(Integer vegetableId) throws CartException;

	public Optional<Cart> findByCartId(Integer cartId) throws CartException;

}
