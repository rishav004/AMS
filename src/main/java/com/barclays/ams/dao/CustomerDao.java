package com.barclays.ams.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.barclays.ams.entity.BankAccount;
import com.barclays.ams.entity.Customer;
import com.barclays.ams.repository.BankAccountRepository;
import com.barclays.ams.repository.CustomerRepository;

@Repository
public class CustomerDao {

	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private BankAccountRepository bankAccountRepository;

	private BankAccount bankAccount;

	public Customer addCustomer(Customer customer) {
		bankAccount = new BankAccount();
		List<Customer> cust = customerRepository.findAll();

		for (Customer c : cust) {
			if (c.getPan().equals(customer.getPan())) {
				bankAccount.setCid(c.getCid());
				bankAccountRepository.save(bankAccount);
				return null;
			}
		}

		Customer cust1 = customerRepository.save(customer);
		bankAccount.setCid(cust1.getCid());
		bankAccountRepository.save(bankAccount);
		return cust1;
	}

	public List<Customer> getAll() {
		return customerRepository.findAll();
	}

}
