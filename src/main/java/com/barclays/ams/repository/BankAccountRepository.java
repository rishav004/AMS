package com.barclays.ams.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.barclays.ams.entity.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, Integer> {

	@Query(value = "select * from bank_account where cid=?1", nativeQuery = true)
	public List<BankAccount> findByCid(long cid);

}
