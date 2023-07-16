package com.group2.capstone.EBPaymentSystem.billing.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.group2.capstone.EBPaymentSystem.billing.models.Bill;
import com.group2.capstone.EBPaymentSystem.billing.models.OrderResponse;
import com.group2.capstone.EBPaymentSystem.billing.models.PaymentInfo;
import com.group2.capstone.EBPaymentSystem.billing.service.BillingService;
import com.group2.capstone.EBPaymentSystem.billing.service.PaymentService;
import com.razorpay.Order;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private BillingService billService;
	
	@Autowired
	private PaymentService paymentService;

	private RazorpayClient client = null;

	@PostMapping("/createOrder/{billid}")
	public ResponseEntity<?> createOrder(@PathVariable long billid) throws Exception {

		
		Bill bill = billService.getBillFromBillId(billid);

		client = new RazorpayClient("rzp_test_Y9WtUj185aAZ1G", "muEQErTodUmXh3Fzgxbl41wB");
		try {
			JSONObject ob = new JSONObject();
			ob.put("amount", bill.getAmount() * 100);
			ob.put("currency", "INR");
			ob.put("receipt", "txn_235425");

			Order order = client.Orders.create(ob);

			String orderid = order.get("id");
			String status = order.get("status");
			PaymentInfo paymentInfo = new PaymentInfo();
			paymentInfo.setOrderId(orderid);
			paymentInfo.setBill(bill);
			paymentInfo.setStatus(status);
			
			paymentService.insertPaymentInfo(paymentInfo);
			OrderResponse response = new OrderResponse(order.get("id"),order.get("amount"),order.get("currency"),bill.getId()); 

			return ResponseEntity.ok().body(response);
		} catch (RazorpayException e) {
			// Handle exception and return appropriate response
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating order");
		}
	}
	
	@PostMapping("/response")
    public ResponseEntity<Object> handlePaymentResponse(
            @RequestParam("paymentId") String paymentId,
            @RequestParam("orderId") String orderId, 
            @RequestParam("signature") String signature,
            @RequestParam("billid") long billid) throws Exception  {
		client = new RazorpayClient("rzp_test_Y9WtUj185aAZ1G", "muEQErTodUmXh3Fzgxbl41wB");
		
		
		Payment payment = client.Payments.fetch(paymentId);
		
		billService.updateStatusAsPaid(billid);
		paymentService.updatePaymentInfo(paymentId,signature,payment.get("status"),orderId);
       
		return ResponseEntity.status(302).header("Location", "/success").build();
    }


}
