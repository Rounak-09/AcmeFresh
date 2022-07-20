package com.acmefresh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acmefresh.model.Address;

public interface AddressDao extends JpaRepository<Address, Integer> {

}
