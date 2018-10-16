 package com.stackroute.buzzup.payment.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.buzzup.kafka.domain.TicketDetails;

@Repository
public interface PaymentRepository extends MongoRepository<TicketDetails, Integer> {
	
	public TicketDetails getByEmailId(String emailId);

}
