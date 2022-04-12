//package com.barclays.ams.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.barclays.ams.entity.AccountTransaction;
//import com.barclays.ams.service.AccountTransactionService;
//
//@RestController
//public class AccountTransactionController {
//
//	@Autowired
//	private AccountTransactionService accountTransactionService;
//
//	@GetMapping("/customer/{cid}")
//	private AccountTransaction getBalance(@PathVariable int cid) {
//		return accountTransactionService.getBalance(cid);
//	}
//
//}
