package com.test.jwtapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.jwtapp.model.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer>{

	Boolean existsByUsername(String username);
    UserInfo findByUsername(String username);


}
