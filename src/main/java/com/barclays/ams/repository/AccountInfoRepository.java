package com.barclays.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barclays.ams.entity.AccountInfo;

public interface AccountInfoRepository extends JpaRepository<AccountInfo, Integer> {

}
