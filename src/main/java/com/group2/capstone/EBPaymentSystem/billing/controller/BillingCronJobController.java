package com.group2.capstone.EBPaymentSystem.billing.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.group2.capstone.EBPaymentSystem.authentication.models.User;
import com.group2.capstone.EBPaymentSystem.authentication.services.UserService;
import com.group2.capstone.EBPaymentSystem.billing.models.Bill;
import com.group2.capstone.EBPaymentSystem.billing.models.Property;
import com.group2.capstone.EBPaymentSystem.billing.service.BillingService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Controller
public class BillingCronJobController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BillingService billService;
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Scheduled(cron="00 24 16 12 * *")
	public void generateBillEveryMonth() {
		List<User> users = userService.getAllConsumers();
       
		for(User user:users) {
			System.out.println(user);
			List<Property> properties = billService.getUserProperties(user);
	        System.out.println("properties fetched");
	       
	        LocalDate date = LocalDate.now();
	        int month = date.getMonthValue();
	        int year = date.getYear();
	        for(Property property:properties) {
	            billService.calculateBill(property, month, year);
	            System.out.println("bill calculated");
	        }

		}
		
    }
	
}
