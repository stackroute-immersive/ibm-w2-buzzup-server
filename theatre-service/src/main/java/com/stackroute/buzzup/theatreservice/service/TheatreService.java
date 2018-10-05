package com.stackroute.buzzup.theatreservice.service;

import com.stackroute.buzzup.theatreservice.exception.TheatreAlreadyExistsException;
import com.stackroute.buzzup.theatreservice.exception.TheatreNotFoundException;
import com.stackroute.buzzup.theatreservice.model.Theatre;

public interface TheatreService {

	public Theatre saveTheatre(Theatre theatre) throws TheatreAlreadyExistsException;

	public Theatre updateTheatre(Theatre theatre) throws TheatreNotFoundException;

	public Theatre getTheatreByTheatreTitle(String theatreTitle) throws TheatreNotFoundException;

	public Theatre getEmailId(String emailId) throws TheatreNotFoundException;

}