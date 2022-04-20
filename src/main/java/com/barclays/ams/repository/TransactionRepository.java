package com.barclays.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barclays.ams.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
