package com.group2.capstone.EBPaymentSystem.authentication;

import com.group2.capstone.EBPaymentSystem.profile.Role;
import com.group2.capstone.EBPaymentSystem.profile.UserProfile;

public class RegisterService {
    public boolean register(String username, String password, Role role, UserProfile profile) {
        // check if a user with the given username already exists in the database
        // if yes, return false (registration failed)
        // otherwise, create a new User object with the given details
        // hash the password using EncryptionUtils.hashPassword()
        // store the new user in the database with the hashed password
        // return true (registration successful)
        return false;
    }
}
