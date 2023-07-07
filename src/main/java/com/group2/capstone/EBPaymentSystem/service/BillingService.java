package com.group2.capstone.EBPaymentSystem.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group2.capstone.EBPaymentSystem.models.Bill;
import com.group2.capstone.EBPaymentSystem.models.Meter;
import com.group2.capstone.EBPaymentSystem.models.Property;
import com.group2.capstone.EBPaymentSystem.models.PropertyType;
import com.group2.capstone.EBPaymentSystem.models.User;
import com.group2.capstone.EBPaymentSystem.repository.BillingRepo;

@Service
public class BillingService {

	@Autowired
	private BillingRepo billRepo;
	
	@Autowired
	private CalendarService calService;
	
	public List<Property> getUserProperties(User user){
		List<Property> properties = user.getProfile().getProperties();
		return properties;
	}
	
	
	public Bill calculateBill(Property property) {
		Meter meter = property.getMeter();
		PropertyType pType = property.getPropertyType();
		
		double amount= 0;
		double units = meter.getUnitsConsumed();
		
		if(units>400) {
			amount += 200*pType.getLowRate();
			amount += 200*pType.getMediumRate();
			amount += (units-400)*pType.getHighRate();
		}else if(units>200) {
			amount += 200*pType.getLowRate();
			amount += (units-200)*pType.getMediumRate();
		}else {
			amount += units*pType.getLowRate();
		}
		
		Calendar cal = calService.getDueDate();
		LocalDate date = LocalDate.now();
		Integer status = 0;
		Bill bill = new Bill();
		bill.setAmount(amount);
		bill.setDueDate(cal.getTime());
		bill.setProperty(property);
		bill.setStatus(status);
		bill.setBillingMonth(date);
		return bill;
		
	}
	
	
	public void insertBill(Bill bill) {
		billRepo.save(bill);
	}
	
	
	public byte[] pdfGenerator(User user) throws IOException {
		List<Bill> latestBills = getBillForUser(user);
		PDDocument document = new PDDocument();
		
		PDPage pdpage = new PDPage();
		
		document.addPage(pdpage);
		
		PDPageContentStream contentStream = new PDPageContentStream(document, pdpage, PDPageContentStream.AppendMode.APPEND,true,true);

		contentStream.setFont(PDType1Font.HELVETICA_BOLD, 12);
		float startX = 50;
		float startY = 700;
	    float endX = pdpage.getMediaBox().getWidth() - 50; // Adjust the end position if needed
	    float endY = startY;
		
		contentStream.beginText();
		contentStream.newLineAtOffset(startX, startY);
		contentStream.showText("Name: "+user.getProfile().getName());
		contentStream.newLine();
		contentStream.showText("Email: "+user.getProfile().getEmail());
		contentStream.newLine();
		contentStream.showText("Contact No: "+user.getProfile().getContactNo());
		contentStream.newLine();
		contentStream.showText("Date: "+LocalDate.now());
		contentStream.newLine();
		for(Bill bill:latestBills) {
			
			contentStream.showText("Generated Date: "+bill.getBillingMonth());
			contentStream.newLine();
			contentStream.showText("Property Address: "+bill.getProperty().getAddress());
			contentStream.newLine();
			contentStream.showText("Meter ID: "+bill.getProperty().getMeter().getMeterId());
			contentStream.newLine();
			contentStream.showText("Units Consumed: "+bill.getProperty().getMeter().getUnitsConsumed());
			contentStream.newLine();
			contentStream.showText("Amount: "+bill.getAmount());
			contentStream.newLine();
			contentStream.showText("Due Date: "+bill.getDueDate());
			contentStream.newLine();
			contentStream.newLine();
			
		}
		contentStream.endText();
		contentStream.moveTo(startX, endY);
	    contentStream.lineTo(endX, endY);
	    contentStream.stroke();
		
		contentStream.close();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		document.save(outputStream);
		document.close();
		
		return outputStream.toByteArray();
	}
	
	public List<Bill> getBillForUser(User user){
		
		List<Bill> bills = new ArrayList<>();
		
		List<Property> properties = getUserProperties(user);
		
		for(Property property:properties) {
			List<Bill> allBills = billRepo.findByProperty(property.getId());
			bills.add(allBills.get(0));
		}

		return bills;
	}
	
	
}
