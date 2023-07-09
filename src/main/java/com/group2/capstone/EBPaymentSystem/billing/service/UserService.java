package com.group2.capstone.EBPaymentSystem.billing.service;

import com.group2.capstone.EBPaymentSystem.billing.models.User;
import com.group2.capstone.EBPaymentSystem.billing.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
