package com.group2.capstone.EBPaymentSystem.billing;

import com.group2.capstone.EBPaymentSystem.profile.User;

public interface BillGenerator {
    Bill generateBill(User user);
}


