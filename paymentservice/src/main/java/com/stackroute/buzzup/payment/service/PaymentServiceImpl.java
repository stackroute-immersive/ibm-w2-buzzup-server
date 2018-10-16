package com.stackroute.buzzup.payment.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.stackroute.buzzup.kafka.domain.TicketDetails;
import com.stackroute.buzzup.payment.config.KafkaProducerConfig;
import com.stackroute.buzzup.payment.repository.PaymentRepository;
import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;
import com.stripe.model.Refund;

@Component
public class PaymentServiceImpl implements PaymentService {

	private PaymentRepository paymentRepo;
	// private KafkaProducerConfig kafkaProducer;

	@Autowired
	PaymentServiceImpl(PaymentRepository paymentRepo) {
		Stripe.apiKey = "sk_test_m91u0Hec19aRB71O6d0d1LbW";
		this.paymentRepo = paymentRepo;
	}

	@Autowired
	private KafkaTemplate<String, TicketDetails> kafkaTemplate;

	String topic = KafkaProducerConfig.getTopic();
	String chargeId;
	String chargeStatus;
	String chargeOutcome;
	Charge chargee;

	@Override
	public Charge chargeNewCard(String token, double amount) throws CardException {
		Map<String, Object> chargeParams = new HashMap<String, Object>();
		chargeParams.put("amount", (int) (amount * 100));
		chargeParams.put("currency", "INR");
		chargeParams.put("source", token);
		Charge charge = null;
		try {
			// Submit charge to credit card
			charge = Charge.create(chargeParams);
			chargee = charge;
			System.out.println(charge);
		} catch (CardException | AuthenticationException | InvalidRequestException | APIConnectionException
				| APIException e) {
			// Transaction was declined
			// System.out.println("Status is: " + e.getCode());
			System.out.println("Message is: " + e.getMessage());
			chargee = charge;
		}

		return charge;

	}

	@Override
	public Refund cardRefund() throws Exception {
		Map<String, Object> refundParams = new HashMap<String, Object>();
		refundParams.put("charge", chargeId);
		Refund refund = Refund.create(refundParams);
		return refund;

	}

	@Override
	public TicketDetails saveTicket(TicketDetails ticket) {
		// ticket.setBookingStatus(chargeStatus);
		if (chargee != null) {
			ticket.setBookingStatus("Success");
			paymentRepo.save(ticket);
			kafkaTemplate.send(topic, ticket);
		} else {
			ticket.setBookingStatus("Failure");
			paymentRepo.save(ticket);
			kafkaTemplate.send(topic, ticket);
		}
		return ticket;
	}

	@Override
	public TicketDetails addTicket(TicketDetails ticketDetails) {
		paymentRepo.save(ticketDetails);
		kafkaTemplate.send(topic, ticketDetails);
		return ticketDetails;
	}

	@Override
	public TicketDetails getTicket(String email) {
		TicketDetails ticket = paymentRepo.getByEmailId(email);
		return ticket;
	}

}
