package com.barclays.ams.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.ams.entity.Transaction;
import com.barclays.ams.service.TransactionService;

@RestController
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@PostMapping("/transactions")
	private String addTransaction(@RequestBody Transaction transaction) {
		return transactionService.addTransaction(transaction);
	}

}
