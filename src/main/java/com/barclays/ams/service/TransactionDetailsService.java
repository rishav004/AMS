package com.barclays.ams.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barclays.ams.dao.TransactionDetailsDao;
import com.barclays.ams.entity.TransactionDetails;

@Service
public class TransactionDetailsService {

	@Autowired
	public TransactionDetailsDao transactionDetailsDao;

	public List<TransactionDetails> getLastFiveTransactions(long accno) {
		return transactionDetailsDao.getLastFiveTransactions(accno);
	}

}
