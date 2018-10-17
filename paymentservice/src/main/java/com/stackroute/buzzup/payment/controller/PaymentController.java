package com.stackroute.buzzup.payment.controller;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.buzzup.kafka.domain.TicketDetails;
import com.stackroute.buzzup.payment.service.PaymentServiceImpl;
import com.stripe.exception.CardException;
import com.stripe.model.Charge;
import com.stripe.model.Refund;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {

	private PaymentServiceImpl stripeClient;

	// String topic = "payment3";
	//
	// private KafkaTemplate<String, TicketDetails> kafkaTemplate;

	@Autowired
	PaymentController(PaymentServiceImpl stripeClient) {
		this.stripeClient = stripeClient;
	}

	@PostMapping("/charge")
	public Charge chargeCard(HttpServletRequest request) throws CardException {
		String token = request.getHeader("token");
		Double amount = Double.parseDouble(request.getHeader("amount"));
		return this.stripeClient.chargeNewCard(token, amount);
	}

	@PostMapping("/refund")
	public Refund refundCard(HttpServletRequest request) throws Exception {
		// String token = request.getHeader("token");
		// Double amount = Double.parseDouble(request.getHeader("amount"));
		return this.stripeClient.cardRefund();
	}

	@PostMapping("/ticket")
	public ResponseEntity<?> saveTicketHandler(@RequestBody TicketDetails ticket) {
		TicketDetails saveTicket = stripeClient.saveTicket(ticket);
		return new ResponseEntity<TicketDetails>(saveTicket, HttpStatus.OK);

	}

	@PostMapping("/tickett")
	public ResponseEntity<?> ticketHandler(@RequestBody TicketDetails ticketDetails) {

		stripeClient.addTicket(ticketDetails);
		// kafkaTemplate.send(topic, ticketDetails);

		return new ResponseEntity<TicketDetails>(ticketDetails, HttpStatus.OK);

	}

	@GetMapping("ticket")
	public ResponseEntity<?> getTicket(@RequestParam String email) {

		TicketDetails ticket = stripeClient.getTicket(email);
		return new ResponseEntity<TicketDetails>(ticket, HttpStatus.OK);

	}

}
