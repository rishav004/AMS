package com.barclays.ams.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.barclays.ams.dao.CustomerDao;
import com.barclays.ams.entity.Customer;
import com.barclays.ams.entity.ResponseStructure;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;

	public ResponseStructure<Customer> addCustomer(Customer customer) {
		ResponseStructure<Customer> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Saved Data");
		Customer savedCustomer = customerDao.addCustomer(customer);
		responseStructure.setData(savedCustomer);
		return responseStructure;

	}

	public ResponseStructure<List<Customer>> getAll() {
		ResponseStructure<List<Customer>> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("All Customer Data");
		responseStructure.setData(customerDao.getAll());
		return responseStructure;
	}

}
