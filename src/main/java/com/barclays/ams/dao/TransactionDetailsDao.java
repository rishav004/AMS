package com.barclays.ams.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.barclays.ams.entity.TransactionDetails;
import com.barclays.ams.repository.TransactionDetailsRepo;

@Repository
public class TransactionDetailsDao {

	@Autowired
	public TransactionDetailsRepo transactionDetailsRepo;

	public TransactionDetails addTransactionDetails(TransactionDetails transactionDetails) {
		return transactionDetailsRepo.save(transactionDetails);
	}

	public double getTotalAmountPerDay(long accno) {
		return transactionDetailsRepo.findTotalAmountPerDay(accno);
	}

	public List<TransactionDetails> getLastFiveTransactions(long accno) {
		return transactionDetailsRepo.findLastFiveTransactions(accno);
	}

}
