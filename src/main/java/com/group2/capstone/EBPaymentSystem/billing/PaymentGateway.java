package com.group2.capstone.EBPaymentSystem.billing;

public interface PaymentGateway {
    public boolean processPayment(Payment payment);
}
