package com.stackroute.buzzup.paymentservice.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.stackroute.buzzup.kafka.model.BookingDetails;
import com.stackroute.buzzup.paymentservice.config.KafkaProducerConfig;
import com.stackroute.buzzup.paymentservice.repository.BookingDetailsRepository;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.Refund;

@Service
public class StripeClient implements BookingDetailsService {

	public BookingDetailsRepository bookingRepo;
	@Autowired
	public StripeClient(BookingDetailsRepository bookingRepo) {
		this.bookingRepo = bookingRepo;
		Stripe.apiKey = "sk_test_XMwHxXWtsjafYU3FJAmAJVYY";
   }
	
	String topic = KafkaProducerConfig.getTopic();
	
	@Autowired
	private KafkaTemplate<String, BookingDetails> kafkaTemplate;

	
	private Customer getCustomer(String id) throws Exception {
        return Customer.retrieve(id);
    }
	public Customer createCustomer(String token, String email) throws Exception {
	    Map<String, Object> customerParams = new HashMap<String, Object>();
	    customerParams.put("email", email);
	    customerParams.put("source", token);
	    return Customer.create(customerParams);
	}
	
	public Charge chargeNewCard(String token, double amount) throws Exception {
        Map<String, Object> chargeParams = new HashMap<String, Object>();
        chargeParams.put("amount", (int)(amount * 100));
        chargeParams.put("currency", "INR");
        chargeParams.put("source", token);
        Charge charge = Charge.create(chargeParams);
        return charge;
    }
	public Charge chargeCustomerCard(String customerId, int amount) throws Exception {
	    String sourceCard =     Customer.retrieve(customerId).getDefaultSource();
	    Map<String, Object> chargeParams = new HashMap<String, Object>();
	    chargeParams.put("amount", amount);
	    chargeParams.put("currency", "USD");
	    chargeParams.put("customer", customerId);
	    chargeParams.put("source", sourceCard);
	    Charge charge = Charge.create(chargeParams);
	    return charge;
	}
	public Charge chargeCreditCard(String token, int amount) throws Exception {
        Map<String, Object> chargeParams = new HashMap<String, Object>();
        chargeParams.put("amount", amount);
        chargeParams.put("currency", "USD");
        chargeParams.put("source", token);
        Charge charge = Charge.create(chargeParams);
        return charge;
    }


	public Refund createRefund() throws StripeException {
		Map<String, Object> params = new HashMap<>();
		params.put("charge", "rk_test_A4gCTpyzs3ZzWzgA3llIbxj3");
		params.put("amount", 1000);
		Refund refund = Refund.create(params);
		return refund;
	}
	@Override
	public String saveTicket(BookingDetails bookingDetails) {
		Date date = new Date();
		bookingDetails.setDate(date);
		bookingDetails.setBookingStatus("true");
		bookingRepo.save(bookingDetails);
		kafkaTemplate.send(topic, bookingDetails);
		return "saved";
	}


	@Override
	public BookingDetails getTicket(String emailId) {
		BookingDetails fetchedDetails = bookingRepo.getByEmailId(emailId);
		return fetchedDetails;
	}
	
}