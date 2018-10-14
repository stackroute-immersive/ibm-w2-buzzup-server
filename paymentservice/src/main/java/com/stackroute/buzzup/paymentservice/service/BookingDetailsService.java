package com.stackroute.buzzup.paymentservice.service;

import com.stackroute.buzzup.kafka.model.BookingDetails;

public interface BookingDetailsService {

	public String saveTicket(BookingDetails bookingDetails);

	public BookingDetails getTicket(String emailId);
}
