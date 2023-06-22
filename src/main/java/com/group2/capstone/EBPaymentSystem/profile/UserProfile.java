package com.group2.capstone.EBPaymentSystem.profile;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserProfile {
    private final String name;
    private final String contactDetails;
    private final Address address;
    private final List<Property> properties;

    public UserProfile(String name, String contactDetails, Address address) {
        this.name = name;
        this.contactDetails = contactDetails;
        this.address = address;
        this.properties = new ArrayList<>();
    }

// getters and setters
}
