package com.barclays.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barclays.ams.entity.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, Integer> {

}
