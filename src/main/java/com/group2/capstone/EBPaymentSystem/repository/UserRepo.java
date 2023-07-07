package com.group2.capstone.EBPaymentSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.group2.capstone.EBPaymentSystem.models.User;

public interface UserRepo extends JpaRepository<User, Long>{
	

}
