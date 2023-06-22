package com.group2.capstone.EBPaymentSystem.billing;

public class Payment {
    private double amount;
    private PaymentMethod method;

    public Payment(double amount, PaymentMethod method) {
        this.amount = amount;
        this.method = method;
    }

    // getters and setters
}
