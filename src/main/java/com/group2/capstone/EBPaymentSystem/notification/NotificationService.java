package com.group2.capstone.EBPaymentSystem.notification;

import com.group2.capstone.EBPaymentSystem.billing.BillGenerator;

public interface NotificationService {
    void notify(String message, BillGenerator bill);

//    public void notify(String message);
}
