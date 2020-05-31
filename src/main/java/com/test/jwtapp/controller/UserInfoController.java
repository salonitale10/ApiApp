package com.test.jwtapp.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.jwtapp.exceptions.ValidationException;
import com.test.jwtapp.model.UserInfo;
import com.test.jwtapp.repository.UserInfoRepository;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Map;


@RestController
public class UserInfoController {

	final
    private UserInfoRepository userInfoRepository;

//    private HashData hashData = new HashData();

    public UserInfoController(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }


    @PostMapping("/user")
    public ResponseEntity<String> create(@RequestBody Map<String, String> body) throws NoSuchAlgorithmException {
        String username = body.get("username");
        if (userInfoRepository.existsByUsername(username)){

            throw new ValidationException("Username already existed");

        }

        String password = body.get("password");
        String encodedPassword = new BCryptPasswordEncoder().encode(password);
//        String hashedPassword = hashData.get_SHA_512_SecurePassword(password);
        String fullname = body.get("fullname");
        String address = body.get("address");
        userInfoRepository.save(new UserInfo(username, encodedPassword, fullname,address));
        
       
        return new ResponseEntity<>("new user created",HttpStatus.CREATED);
    }

	
	
}
