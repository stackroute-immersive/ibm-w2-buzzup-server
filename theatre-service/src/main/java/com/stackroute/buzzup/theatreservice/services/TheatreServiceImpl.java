package com.stackroute.buzzup.theatreservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.stackroute.buzzup.kafka.domain.Theatre;
import com.stackroute.buzzup.theatreservice.exceptions.TheatreAlreadyExistsException;
import com.stackroute.buzzup.theatreservice.exceptions.TheatreNotFoundException;
import com.stackroute.buzzup.theatreservice.repository.TheatreRepository;


@Service
public class TheatreServiceImpl implements TheatreService {

	private TheatreRepository theatreRepository;

	@Autowired
	public TheatreServiceImpl(TheatreRepository registrationRepository) {

		this.theatreRepository = registrationRepository;
	}

	@Autowired
	private KafkaTemplate<String, Theatre> kafkaTemplate;
	private static final String TOPIC = "theater-details";


	@Override
	public Theatre saveTheatre(Theatre theatre) throws TheatreAlreadyExistsException {
		kafkaTemplate.send(TOPIC, theatre);
		if (!theatreRepository.existsByTheatreName(theatre.getTheatreName())) {
			Theatre theatreSaved = theatreRepository.save(theatre);
			return theatreSaved;
		} else
			throw new TheatreAlreadyExistsException("theatre already exists");
	}


	@Override
	public Theatre updateTheatre(Theatre theatre) {
		Theatre theatreUpdated = theatreRepository.save(theatre);

		return theatreUpdated;
	}

	@Override
	public Theatre getTheatre(String theatreTitle) {
		
		Theatre list = theatreRepository.getByTheatreName(theatreTitle);
		return list;
	}

	@Override
	public Theatre getEmailId(String email) throws TheatreNotFoundException {
		Theatre theatre = theatreRepository.getByEmail(email);
		return theatre;
	}

}