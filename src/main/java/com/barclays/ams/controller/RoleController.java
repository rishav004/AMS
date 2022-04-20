package com.barclays.ams.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.ams.entity.Customer;
import com.barclays.ams.entity.Role;
import com.barclays.ams.service.RoleService;

@RestController
public class RoleController {

	@Autowired
	private RoleService roleService;

	@PostMapping(value = "/role")
	private Role addRole(@RequestBody Role role) {
		return roleService.addRole(role);
	}

	@GetMapping(value = "/{rid}")
	private Customer getDetailsByPan(@PathVariable int rid, @RequestParam String pan) {
		if (rid == 1) {
			return roleService.getDetailsByPan(pan);
		}
		return roleService.getDetailsByPan("Access Denied");
	}

}
