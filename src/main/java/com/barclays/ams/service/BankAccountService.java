package com.barclays.ams.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barclays.ams.dao.BankAccountDao;
import com.barclays.ams.entity.BankAccount;

@Service
public class BankAccountService {

	@Autowired
	public BankAccountDao bankAccountDao;

	public List<BankAccount> findBankAccountByCid(long cid) {
		return bankAccountDao.findBankAccountByCid(cid);
	}

}
