package com.group2.capstone.EBPaymentSystem.billing;

import com.group2.capstone.EBPaymentSystem.billing.models.Bill;
import com.group2.capstone.EBPaymentSystem.billing.models.User;

public interface BillGenerator {
    Bill generateBill(User user);
}


