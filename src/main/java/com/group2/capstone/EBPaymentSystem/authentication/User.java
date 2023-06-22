package com.group2.capstone.EBPaymentSystem.authentication;

import com.group2.capstone.EBPaymentSystem.profile.UserProfile;

public class User {
    private final String username;
    private final String password;
    private final Role role;
    private final UserProfile profile;


    public User(String username, String password, Role role, UserProfile profile) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.profile = profile;
    }
}
