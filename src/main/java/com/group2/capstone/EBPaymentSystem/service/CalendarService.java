package com.group2.capstone.EBPaymentSystem.service;


import java.util.Calendar;


import org.springframework.stereotype.Service;

@Service
public class CalendarService {

	public Calendar getDueDate() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 15);
		return cal;
	}
	
}
