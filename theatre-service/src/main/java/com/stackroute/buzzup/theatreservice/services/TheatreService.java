package com.stackroute.buzzup.theatreservice.services;

import com.stackroute.buzzup.kafka.domain.Theatre;
import com.stackroute.buzzup.theatreservice.exceptions.TheatreAlreadyExistsException;
import com.stackroute.buzzup.theatreservice.exceptions.TheatreNotFoundException;

public interface TheatreService {

	public Theatre saveTheatre(Theatre theatre) throws TheatreAlreadyExistsException;

	public Theatre updateTheatre(Theatre theatre) throws TheatreNotFoundException;

	public Theatre getTheatre(String theatreTitle) throws TheatreNotFoundException;
	
	public Theatre getEmailId(String email) throws TheatreNotFoundException;
	
	

}