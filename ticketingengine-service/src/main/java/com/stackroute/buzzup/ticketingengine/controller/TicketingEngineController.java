package com.stackroute.buzzup.ticketingengine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.buzzup.ticketingengine.exceptions.TicketCannotGenerateException;
import com.stackroute.buzzup.ticketingengine.exceptions.TicketNotFoundException;
import com.stackroute.buzzup.ticketingengine.model.TicketingEngine;
import com.stackroute.buzzup.ticketingengine.service.TicketingEngineService;



@RestController
@RequestMapping("/api/v1")
public class TicketingEngineController {
	private TicketingEngineService ticketingEngineService;
	@Autowired
	public TicketingEngineController(TicketingEngineService ticketingEngineService) {
		super();
		this.ticketingEngineService = ticketingEngineService;
	}
	
	
	
	
	 /*
		 * Define a handler method which will generate a specific Ticket by reading the
		 * Serialized object from request body and save the ticket details in the
		 * database. This handler method should return any one of the status messages
		 * basis on different situations:
		 * 1. 201(CREATED) - If the ticket generated created successfully. 
		 * 2. 409(CONFLICT) - If the Id conflicts with any problem
		 * 
		 * This handler method should map to the URL "/api/v1/TicketingEngine" using HTTP POST method
		 */
	
	@PostMapping("/TicketingEngine")
		public ResponseEntity<?>generateTicket(@RequestBody TicketingEngine ticketingEngine){
		ResponseEntity<?>responseEntity=null;

		try {
			TicketingEngine tickets = ticketingEngineService.generateTicket(ticketingEngine); 
		    responseEntity = new ResponseEntity<TicketingEngine>(tickets,HttpStatus.CREATED);
		    
		}
		catch(TicketCannotGenerateException e){
			responseEntity= new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
			
		}
		return responseEntity;
	}
	
	
	
	
	/*
 	 * Define a handler method which will get us the tickets by Id.
 	 * 
 	 * This handler method should return any one of the status messages basis on
 	 * different situations: 1. Accepted - If the tickets found successfully. 
 	 * 
 	 * 
 	 * This handler method should map to the URL "/api/v1/TicketingEngine/{id}" using HTTP GET method
 	 */

	@GetMapping("/TicketingEngine/{id}")
	public ResponseEntity<?>getByTicketId(@PathVariable("id") int id ){
		ResponseEntity<?>responseEntity=null;
		try {
			TicketingEngine tickets = ticketingEngineService.getByTicketId(id);
			responseEntity = new ResponseEntity<TicketingEngine>(tickets,HttpStatus.ACCEPTED);
		}
		catch(TicketNotFoundException e) {
			responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}

}



