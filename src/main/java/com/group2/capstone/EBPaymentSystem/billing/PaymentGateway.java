package com.group2.capstone.EBPaymentSystem.billing;

public interface PaymentGateway {
    boolean processPayment(Payment payment);
}
