package com.barclays.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.barclays.ams.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query(value = "select * from customer where cid=?1", nativeQuery = true)
	public Customer findByCid(long cid);

}
