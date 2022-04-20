package com.barclays.ams.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.ams.entity.BankAccount;
import com.barclays.ams.service.BankAccountService;

@RestController
public class BankAccountController {

	@Autowired
	private BankAccountService bankAccountService;

	@GetMapping("/bankAccount/{cid}")
	private List<BankAccount> findBankAccountByCid(@PathVariable long cid) {
		return bankAccountService.findBankAccountByCid(cid);
	}

}
