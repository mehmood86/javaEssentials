package com.mehmood.studentportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mehmood.studentportal.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}
