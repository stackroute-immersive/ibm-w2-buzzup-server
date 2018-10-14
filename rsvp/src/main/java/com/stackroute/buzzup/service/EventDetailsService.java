package com.stackroute.buzzup.service;

import java.util.List;

import com.stackroute.buzzup.kafka.model.EventDetails;

public interface EventDetailsService {

	public EventDetails createEvent(EventDetails eventDetails);
	
	public EventDetails getEvent(String emailId);
	
	public EventDetails eventData(String eventName);
	
	public List<EventDetails> getDetails();
	public boolean deletedEvent(String emailId);
//	public EventDetails deleteEvent(String emailId );
//	public List<EventDetails> getEvent(String emailId);

}
