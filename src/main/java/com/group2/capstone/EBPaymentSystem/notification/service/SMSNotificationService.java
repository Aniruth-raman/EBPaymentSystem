package com.group2.capstone.EBPaymentSystem.notification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

public class SMSNotificationService {
    //    @Autowired
//    SMSSender smsSender;
    @Autowired
    private JavaMailSender mailSender;

    void sendSMSNotification(String phoneNumber, String message) {
//        smsSender.sendSMS(phoneNumber, message);
        System.out.println("Phone Number:" + phoneNumber + "," + "Message:" + message);
    }

}
