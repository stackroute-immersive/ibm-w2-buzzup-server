package com.stackroute.buzzup.theatreservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stackroute.buzzup.theatreservice.exception.TheatreAlreadyExistsException;
import com.stackroute.buzzup.theatreservice.exception.TheatreNotFoundException;
import com.stackroute.buzzup.theatreservice.model.Theatre;
import com.stackroute.buzzup.theatreservice.repository.TheatreRepository;

@Service
public class TheatreServiceImpl implements TheatreService {

	private TheatreRepository theatreRepository;

	// autowiring Repository class
	@Autowired
	public TheatreServiceImpl(TheatreRepository registrationRepository) {

		this.theatreRepository = registrationRepository;
	}

	// method for saving theatre object in mongo
	@Override
	public Theatre saveTheatre(Theatre theatre) throws TheatreAlreadyExistsException {
		if (!theatreRepository.existsByName(theatre.getName())) {
			Theatre theatreSaved = theatreRepository.save(theatre);
			return theatreSaved;
		} else
			throw new TheatreAlreadyExistsException("Theatre already exists");
	}

	// method for updating theatre object in mongo
	@Override
	public Theatre updateTheatre(Theatre theatre) {
		Theatre theatreUpdated = theatreRepository.save(theatre);

		return theatreUpdated;
	}

	// method for retriving theatre object by given title
	@Override
	public Theatre getTheatreByTheatreTitle(String theatreTitle) {

		Theatre list = theatreRepository.getByName(theatreTitle);
		return list;
	}

	// method for retriving theatre object by given email id
	@Override
	public Theatre getEmailId(String emailId) throws TheatreNotFoundException {
		Theatre theatre = theatreRepository.getByEmailId(emailId);
		return theatre;
	}

}