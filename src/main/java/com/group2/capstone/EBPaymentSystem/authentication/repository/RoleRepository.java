package com.group2.capstone.EBPaymentSystem.authentication.repository;

import java.util.Optional;

import com.group2.capstone.EBPaymentSystem.authentication.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByAuthority(String authority);
}
