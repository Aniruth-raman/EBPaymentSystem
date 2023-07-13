package com.group2.capstone.EBPaymentSystem.billing.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.group2.capstone.EBPaymentSystem.billing.models.Bill;
import com.group2.capstone.EBPaymentSystem.billing.service.BillingService;
import com.razorpay.*;
@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private BillingService billService;
	
	
	@PostMapping("/{billid}")
	public String billPayment(@PathVariable long billid) throws Exception {
		
		Bill bill = billService.getBillFromBillId(billid);
		
		RazorpayClient client = new RazorpayClient("rzp_test_Y9WtUj185aAZ1G", "muEQErTodUmXh3Fzgxbl41wB");
		
		JSONObject ob = new JSONObject();
		ob.put("amount", bill.getAmount()*100);
		ob.put("currency", "INR");
		ob.put("receipt","txn_235425");
		
		Order order = client.Orders.create(ob);
		
		return order.toString();
	}

}
