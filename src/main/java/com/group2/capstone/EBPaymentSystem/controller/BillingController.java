package com.group2.capstone.EBPaymentSystem.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group2.capstone.EBPaymentSystem.models.Bill;
import com.group2.capstone.EBPaymentSystem.models.Property;
import com.group2.capstone.EBPaymentSystem.models.User;
import com.group2.capstone.EBPaymentSystem.service.BillingService;
import com.group2.capstone.EBPaymentSystem.service.UserService;

@RestController
@RequestMapping("/bill/generator")
public class BillingController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private BillingService billService;
	
	@GetMapping("/{userid}")
	public String generateBill(@PathVariable long userid) {
		
		Optional<User> user = userService.findById(userid);
		System.out.println("user fetched");
		System.out.println(user);
		List<Property> properties = billService.getUserProperties(user.get());
		System.out.println("properties fetched");
		List<Bill> bills = new ArrayList<>();
		for(Property property:properties) {
			bills.add(billService.calculateBill(property));
			System.out.println("bill calculated");
		}
		
		for(Bill bill:bills) {
			billService.insertBill(bill);
			System.out.println("bill inserted");
		}
		
		return bills.toString();
	}
	
	@GetMapping("/pdf/{userid}")
	public ResponseEntity<byte[]> generatePDF(@PathVariable long userid) throws IOException{
		Optional<User> user = userService.findById(userid);
		try {
            byte[] pdfBytes = billService.pdfGenerator(user.get());

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "bill.pdf");

            return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
        } catch (IOException e) {
            // Handle exceptions and return an error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
	}
	
	
	
}
