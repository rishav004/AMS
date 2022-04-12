package com.barclays.ams.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barclays.ams.dao.AccountInfoDao;
import com.barclays.ams.entity.AccountInfo;

@Service
public class AccountInfoService {

	@Autowired
	private AccountInfoDao accountInfoDao;

	public List<AccountInfo> getAllAccounts() {
		return accountInfoDao.getAllAccounts();

	}

	public AccountInfo addTransaction(AccountInfo accountInfo) {
		return accountInfoDao.addTransaction(accountInfo);

	}

	public List<AccountInfo> findByAccountNo(long accno) {
		return accountInfoDao.findByAccountNo(accno);

	}

}
