package com.stackroute.buzzup.repository;

//import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.buzzup.kafka.model.EventDetails;

@Repository
public interface EventRepository extends MongoRepository<EventDetails, String> {

//	public List<EventDetails> getByEmailId(String emailId);
	
	public EventDetails getByEventName(String eventName);
	public EventDetails getByEmailId(String emailId);
	
}
