package com.barclays.ams.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.barclays.ams.entity.Role;
import com.barclays.ams.repository.RoleRepository;

@Repository
public class RoleDao {

	@Autowired
	private RoleRepository roleRepository;

	public Role addRole(Role role) {
		return roleRepository.save(role);
	}
}
