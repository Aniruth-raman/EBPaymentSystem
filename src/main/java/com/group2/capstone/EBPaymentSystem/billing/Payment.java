package com.group2.capstone.EBPaymentSystem.billing;

public class Payment {
    private final double amount;
    private final PaymentMethod method;

    public Payment(double amount, PaymentMethod method) {
        this.amount = amount;
        this.method = method;
    }

    // getters and setters
}
