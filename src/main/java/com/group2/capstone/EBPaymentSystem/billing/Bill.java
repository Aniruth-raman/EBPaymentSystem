package com.group2.capstone.EBPaymentSystem.billing;

import java.util.Date;

public class Bill {
    private double amount;
    private Date dueDate;

    public Bill(double amount, Date dueDate) {
        this.amount = amount;
        this.dueDate = dueDate;
    }

    // getters and setters
}
