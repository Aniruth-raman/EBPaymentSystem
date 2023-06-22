package com.group2.capstone.EBPaymentSystem.profile;

public class Address {
    String street;
    String city;
    String state;
    Long postalCode;
    String country;
    public Address(String street, String city, String state, Long postalCode, String country) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
    }
}
