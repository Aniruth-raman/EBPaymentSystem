package com.group2.capstone.EBPaymentSystem.notification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class EmailNotificationService {
    @Autowired
    private JavaMailSender mailSender;

    void sendEmailNotification(String userEmail, String subject, String message) {
        System.out.println("User Email" + userEmail + ",Subject:" + subject + ",Message:" + message);
//        SimpleMailMessage mailMessage = new SimpleMailMessage();
//        mailMessage.setTo(userEmail);
//        mailMessage.setSubject(subject);
//        mailMessage.setText(message);
//        mailSender.send(mailMessage);
    }

}
