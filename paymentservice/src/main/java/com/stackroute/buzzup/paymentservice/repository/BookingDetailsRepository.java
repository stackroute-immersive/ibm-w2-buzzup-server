package com.stackroute.buzzup.paymentservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.buzzup.kafka.model.BookingDetails;
import com.stackroute.buzzup.paymentservice.service.BookingDetailsService;

@Repository
public interface BookingDetailsRepository extends MongoRepository<BookingDetails, String>{

	public BookingDetails getByEmailId(String emailId);


}
