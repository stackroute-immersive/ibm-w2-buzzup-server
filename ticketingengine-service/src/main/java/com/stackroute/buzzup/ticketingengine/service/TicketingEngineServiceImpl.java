package com.stackroute.buzzup.ticketingengine.service;



import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.buzzup.ticketingengine.exceptions.TicketCannotGenerateException;
import com.stackroute.buzzup.ticketingengine.exceptions.TicketNotFoundException;
import com.stackroute.buzzup.ticketingengine.model.TicketingEngine;
import com.stackroute.buzzup.ticketingengine.repository.TicketingEngineRepository;



@Service
public class TicketingEngineServiceImpl implements TicketingEngineService{
		private TicketingEngineRepository ticketingEngineRepository;
		
		 /*
	     * Autowiring should be implemented for the TicketingEngineRepository. (Use
	     * Constructor-based autowiring) Please note that we should not create any
	     * object using the new keyword.
	     */
		@Autowired
		public TicketingEngineServiceImpl(TicketingEngineRepository ticketingEngineRepository) {
			this.ticketingEngineRepository = ticketingEngineRepository;
		}
		/*
		 * This method should be used to generate a new ticket.Call the corresponding
		 * method of Repository interface.
		 */

		@Override
		public TicketingEngine generateTicket(TicketingEngine ticketingEngine) throws TicketCannotGenerateException{
			ticketingEngine.setDate(new Date());
			TicketingEngine tickets = ticketingEngineRepository.insert(ticketingEngine);
			if(tickets==null) {
				throw new TicketCannotGenerateException("CANNOT GENERATE");
			}
			return tickets;
		}
		/*
		 * This method should be used to get a Ticket by Id.Call the
		 * corresponding method of Respository interface.
		 */

		@Override
		public TicketingEngine getByTicketId(int id) throws TicketNotFoundException {
			TicketingEngine tickets = ticketingEngineRepository.findById(id);
			if(tickets==null) {
				throw new TicketNotFoundException("Invalid");
			}
			return tickets;
		}
		
			
}
