package com.barclays.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barclays.ams.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
