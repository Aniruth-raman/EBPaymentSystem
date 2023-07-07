package com.group2.capstone.EBPaymentSystem.authentication.repository;

import java.util.Optional;

import com.group2.capstone.EBPaymentSystem.authentication.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUsername(String username);
}
