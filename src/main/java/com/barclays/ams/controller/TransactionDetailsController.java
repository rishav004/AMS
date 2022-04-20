package com.barclays.ams.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.ams.entity.TransactionDetails;
import com.barclays.ams.service.TransactionDetailsService;

@RestController
public class TransactionDetailsController {

	@Autowired
	private TransactionDetailsService transactionDetailsService;

	@GetMapping("/transactionDetails/miniStatement/{accno}")
	private List<TransactionDetails> getLastFiveTransactions(@PathVariable long accno) {
		return transactionDetailsService.getLastFiveTransactions(accno);
	}

}
