package com.stackroute.buzzup.paymentservice.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.buzzup.kafka.model.BookingDetails;
import com.stackroute.buzzup.paymentservice.service.StripeClient;
import com.stripe.model.Charge;

@RestController
public class PaymentController {

	private StripeClient stripeClient;
	 @Autowired
	    PaymentController(StripeClient stripeClient) {
	        this.stripeClient = stripeClient;
	    }
	 
	 @PostMapping("/payment/charge")
	 public Charge chargeCard(HttpServletRequest request) throws Exception {
	        String token = request.getHeader("token");
	        int amount = Integer.parseInt(request.getHeader("amount"));
	        //Double amount = Double.parseDouble(request.getHeader("amount"));
	        return this.stripeClient.chargeCreditCard(token, amount);
	    }
	 
	 @PostMapping("/payment/bookticket")
	 public ResponseEntity<?> saveTicket(@RequestBody BookingDetails bookingDetails){
		 String saved = stripeClient.saveTicket(bookingDetails);
		 return new ResponseEntity<String>(saved,HttpStatus.OK);
	 }
	 
	 @GetMapping("/payment/getticket/{emailId}")
	 public ResponseEntity<?> getTicket(@PathVariable String emailId){
		 BookingDetails bookingDetails = stripeClient.getTicket(emailId);
		 return new ResponseEntity<BookingDetails>(bookingDetails,HttpStatus.OK);

	 }
}
