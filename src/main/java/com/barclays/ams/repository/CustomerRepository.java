package com.barclays.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barclays.ams.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
