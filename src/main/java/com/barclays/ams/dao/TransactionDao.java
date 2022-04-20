package com.barclays.ams.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.barclays.ams.entity.Transaction;
import com.barclays.ams.repository.TransactionRepository;

@Repository
public class TransactionDao {

	@Autowired
	private TransactionRepository transactionRepository;

	public Transaction addTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}

}
