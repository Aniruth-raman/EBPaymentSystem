package com.group2.capstone.EBPaymentSystem.authentication.repository;

import com.group2.capstone.EBPaymentSystem.authentication.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String username);
}
