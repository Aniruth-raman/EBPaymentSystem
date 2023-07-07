package com.group2.capstone.EBPaymentSystem.billing;

import com.group2.capstone.EBPaymentSystem.models.Bill;
import com.group2.capstone.EBPaymentSystem.models.User;

public interface BillGenerator {
    Bill generateBill(User user);
}


