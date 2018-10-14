package com.stackroute.buzzup.theatreservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.buzzup.kafka.domain.Theatre;
import com.stackroute.buzzup.theatreservice.exceptions.TheatreAlreadyExistsException;
import com.stackroute.buzzup.theatreservice.exceptions.TheatreNotFoundException;
import com.stackroute.buzzup.theatreservice.services.TheatreService;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/v1/")
public class TheatreController {

	
	TheatreService theatreService;

	@Autowired
	public void registrationController(TheatreService theatreService) {
		this.theatreService = theatreService;

	}

	
	@RequestMapping(value = "/theatre", method = RequestMethod.POST)
	public ResponseEntity<?> saveTheatre(@RequestBody Theatre theatre)
			throws TheatreAlreadyExistsException {

		Theatre theatreobj = null;
		
		try {

			
			System.out.println(theatre.getEmail());
			theatreobj = theatreService.saveTheatre(theatre);
			return new ResponseEntity<Theatre>(theatreobj, HttpStatus.OK);
		} catch (TheatreAlreadyExistsException m) {
			String result = m.getMessage();
			return new ResponseEntity<String>(result, HttpStatus.OK);
		}

	}

	
	@RequestMapping(value = "/theater", method = RequestMethod.GET)
	public ResponseEntity<?> getByEmailId(@RequestParam String email) throws TheatreNotFoundException {
		Theatre list = null;
		try {
			list = theatreService.getEmailId(email);
			return new ResponseEntity<Theatre>(list, HttpStatus.OK);
		} catch (TheatreNotFoundException m) {
			String result = m.getMessage();
			return new ResponseEntity<String>(result, HttpStatus.OK);
		}
	}

	
	@RequestMapping(value = "/theatre", method = RequestMethod.PUT)
	public ResponseEntity<Theatre> updateTheatre(@RequestBody Theatre theatre) throws TheatreNotFoundException {

		Theatre theatreobj = theatreService.updateTheatre(theatre);

		return new ResponseEntity<Theatre>(theatreobj, HttpStatus.OK);
	}

	@RequestMapping(value = "/theatre/{TheatreTitle}", method = RequestMethod.GET)
	public ResponseEntity<?> getByTheatreTitle(@PathVariable String TheatreTitle) throws TheatreNotFoundException {
		Theatre list = theatreService.getTheatre(TheatreTitle);

		return new ResponseEntity<Theatre>(list, HttpStatus.OK);

	}
}
