package com.barclays.ams.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barclays.ams.dao.RoleDao;
import com.barclays.ams.entity.Customer;
import com.barclays.ams.entity.Role;
import com.barclays.ams.repository.CustomerRepository;

@Service
public class RoleService {

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private CustomerRepository customerRepository;

	public Role addRole(Role role) {
		return roleDao.addRole(role);
	}

	public Customer getDetailsByPan(String pan) {
		List<Customer> customer = customerRepository.findAll();
		if (!pan.equals("Access Denied")) {
			for (Customer c : customer) {
				if (c.getPan().equals(pan)) {
					return c;
				}
			}
		}

		return null;
	}

}
