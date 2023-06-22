package com.group2.capstone.EBPaymentSystem.authentication;

import com.group2.capstone.EBPaymentSystem.profile.UserProfile;

public class LoginService {
    public boolean login(String username, String password) {
        // retrieve the user from the database using the given username
        // if the user exists, hash the given password using EncryptionUtils.hashPassword()
        // compare the resulting hash with the stored hash
        // if they match, return true (login successful)
        // otherwise, return false (login failed)
        return false;
    }
}
