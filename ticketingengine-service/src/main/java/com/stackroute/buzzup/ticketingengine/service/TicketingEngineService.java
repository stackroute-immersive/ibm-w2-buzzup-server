package com.stackroute.buzzup.ticketingengine.service;

import com.stackroute.buzzup.ticketingengine.exceptions.TicketCannotGenerateException;
import com.stackroute.buzzup.ticketingengine.exceptions.TicketNotFoundException;
import com.stackroute.buzzup.ticketingengine.model.TicketingEngine;


public interface TicketingEngineService {
	public TicketingEngine generateTicket(TicketingEngine ticketingEngine) throws TicketCannotGenerateException;
	public TicketingEngine getByTicketId(int id) throws TicketNotFoundException;

}
