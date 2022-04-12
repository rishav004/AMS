//package com.barclays.ams.dao;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.barclays.ams.entity.AccountTransaction;
//import com.barclays.ams.repository.AccountTransactionRepository;
//
//@Repository
//public class AccountTransactionDao {
//
//	@Autowired
//	private AccountTransactionRepository accountTransactionRepository;
//
//	public Optional<AccountTransaction> getBalance(int cid) {
//		return accountTransactionRepository.findById(cid);
//	}
//
//}
