package com.barclays.ams.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.barclays.ams.entity.Users;
import com.barclays.ams.repository.UsersRepo;

@Repository
public class UsersDao {

	@Autowired
	public UsersRepo usersRepo;

	public Users addUser(Users user) {
		return usersRepo.save(user);

	}

}
