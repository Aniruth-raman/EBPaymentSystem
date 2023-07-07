package com.group2.capstone.EBPaymentSystem.service;

import java.sql.SQLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group2.capstone.EBPaymentSystem.models.User;
import com.group2.capstone.EBPaymentSystem.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	public Optional<User> findById(long userid) {
		
		return userRepo.findById(userid);
	}
	
	public void insertUser(User user) {
		userRepo.save(user);
	}
	
	
	
	
	
}
