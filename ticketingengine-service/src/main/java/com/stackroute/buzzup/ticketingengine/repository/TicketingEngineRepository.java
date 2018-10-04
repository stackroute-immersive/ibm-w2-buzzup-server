package com.stackroute.buzzup.ticketingengine.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.stackroute.buzzup.ticketingengine.model.TicketingEngine;

public interface TicketingEngineRepository extends MongoRepository<TicketingEngine,String> {

	//TicketingEngine existsById(int id);

	TicketingEngine findById(int id);

	

}
