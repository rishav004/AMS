package com.barclays.ams.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.barclays.ams.entity.BankAccount;
import com.barclays.ams.repository.BankAccountRepository;

@Repository
public class BankAccountDao {

	@Autowired
	private BankAccountRepository bankAccountRepository;

	public List<BankAccount> findBankAccountByCid(long cid) {
		return bankAccountRepository.findByCid(cid);

	}

}
