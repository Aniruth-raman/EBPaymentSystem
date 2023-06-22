package com.group2.capstone.EBPaymentSystem.billing;

import com.group2.capstone.EBPaymentSystem.authentication.User;

import java.util.Date;

public interface BillGenerator {
    public Bill generateBill(User user);
}


