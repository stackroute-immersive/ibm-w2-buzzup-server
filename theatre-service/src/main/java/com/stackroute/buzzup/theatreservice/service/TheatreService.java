package com.stackroute.buzzup.theatreservice.service;

import com.stackroute.buzzup.theatreservice.exception.TheatreAlreadyExistsException;
import com.stackroute.buzzup.theatreservice.exception.TheatreNotFoundException;
import com.stackroute.buzzup.theatreservice.model.Theatre;

public interface TheatreService {

	/*
	 * Should not modify this interface. You have to implement these methods in
	 * corresponding Impl classes
	 */

    Theatre registerTheatre(Theatre theatre)throws TheatreAlreadyExistsException ;
    
    boolean deleteTheatre(String theaterId) throws TheatreNotFoundException;

    Theatre updateTheatre(String theaterId, Theatre theatre) throws TheatreNotFoundException;

    Theatre getTheatreByemailId(String emailId) throws TheatreNotFoundException;
    
    /*Theatre getTheatreByCity(String city) throws TheatreNotFoundException;*/
}