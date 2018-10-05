package com.stackroute.buzzup.theatreservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.stackroute.buzzup.theatreservice.exception.TheatreAlreadyExistsException;
import com.stackroute.buzzup.theatreservice.exception.TheatreNotFoundException;
import com.stackroute.buzzup.theatreservice.model.Theatre;
import com.stackroute.buzzup.theatreservice.service.TheatreService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api/v1/")
public class TheatreController {

	TheatreService theatreService;

	//autowiring Service class object
	@Autowired
	public TheatreController(TheatreService theatreService) {
		this.theatreService = theatreService;

	}
	

	//handler method for saving the theatre object
	@PostMapping(value = "/theatre")
	public ResponseEntity<?> saveTheatre(@RequestBody Theatre theatre) throws TheatreAlreadyExistsException {

		try {
			return new ResponseEntity<Theatre>(theatreService.saveTheatre(theatre), HttpStatus.OK);
		} catch (TheatreAlreadyExistsException m) {
			return new ResponseEntity<String>(m.getMessage(), HttpStatus.OK);
		}

	}

	//handler method for updating the theatre object
	@PutMapping(value = "/theatre")
	public ResponseEntity<Theatre> updateTheatre(@RequestBody Theatre theatre) throws TheatreNotFoundException {

		return new ResponseEntity<Theatre>(theatreService.updateTheatre(theatre), HttpStatus.OK);
	}

	
	//handler method for retriving the theatre list by given email id
	@GetMapping("/theatre/{emailId}")
    public ResponseEntity<?> getByEmailId(@PathVariable String emailId) throws TheatreNotFoundException {
        Theatre list = null;
        try {
            list = theatreService.getEmailId(emailId);
            return new ResponseEntity<Theatre>(list, HttpStatus.OK);
        } catch (TheatreNotFoundException m) {
            String result = m.getMessage();
            return new ResponseEntity<String>(result, HttpStatus.OK);
        }
    }
}
