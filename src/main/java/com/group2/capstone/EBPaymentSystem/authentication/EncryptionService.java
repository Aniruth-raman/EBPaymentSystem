package com.group2.capstone.EBPaymentSystem.authentication;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptionService {
    public String hashPassword(String password) {
        // use a cryptographic hash function to hash the password
        // return the hashed password
//        return password;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            // handle exception
        }
        return null;
    }

}

//    public boolean verifyPassword(String password, String hash) {
//        // hash the given password using the same hash function
//        // compare the resulting hash with the given hash
//        // if they match, return true (password is correct)
//        // otherwise, return false (password is incorrect)
//        return false;
//    }
//}