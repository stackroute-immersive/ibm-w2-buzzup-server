package com.stackroute.buzzup.theatreservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.buzzup.theatreservice.exception.TheatreAlreadyExistsException;
import com.stackroute.buzzup.theatreservice.exception.TheatreNotFoundException;
import com.stackroute.buzzup.theatreservice.model.Theatre;
import com.stackroute.buzzup.theatreservice.service.TheatreService;

/*
 * As in this assignment, we are working on creating RESTful web service, hence annotate
 * the class with @RestController annotation. A class annotated with the @Controller annotation
 * has handler methods which return a view. However, if we use @ResponseBody annotation along
 * with @Controller annotation, it will return the data directly in a serialized 
 * format. Starting from Spring 4 and above, we can use @RestController annotation which 
 * is equivalent to using @Controller and @ResposeBody annotation
 */
@CrossOrigin("*")
@RestController
public class TheatreController {

	private TheatreService theatreService;

	/*
	 * Autowiring should be implemented for the TheatreService. (Use
	 * Constructor-based autowiring) Please note that we should not create an object
	 * using the new keyword
	 */
	@Autowired
	public TheatreController(TheatreService theatreService) {

		this.theatreService = theatreService;
	}

	/*
	 * Define a handler method which will register a specific theatre by reading the
	 * Serialized object from request body and save the user details in the
	 * database. This handler method should return any one of the status messages
	 * basis on different situations: 1. 201(CREATED) - If the theatre created
	 * successfully. 2. 409(CONFLICT) - If the Id conflicts with any existing
	 * theatre
	 * 
	 * This handler method should map to the URL "/api/v1/theatre" using HTTP POST
	 * method
	 */

	@PostMapping("/api/v1/theatre")
	public ResponseEntity<?> register(@RequestBody Theatre theatre) throws TheatreAlreadyExistsException {
		try {
			theatreService.registerTheatre(theatre);
			return new ResponseEntity<Theatre>(theatre, HttpStatus.CREATED);

		} catch (TheatreAlreadyExistsException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}

	/*
	 * Define a handler method which will delete a user from a database. This
	 * handler method should return any one of the status messages basis on
	 * different situations: 1. 200(OK) - If the theatre deleted successfully from
	 * database. 2. 404(NOT FOUND) - If the theatre with specified Id is not found.
	 *
	 * This handler method should map to the URL "/api/v1/theatre//{theaterId}"
	 * using HTTP Delete method" where "id" should be replaced by a valid Id without
	 * {}
	 */
	@DeleteMapping("/api/v1/theatre/{theaterId}")
	public ResponseEntity<?> deleteTheatre(@PathVariable() String theaterId) throws TheatreNotFoundException {
		ResponseEntity<?> responseEntity = null;

		try {
			theatreService.deleteTheatre(theaterId);
			responseEntity = new ResponseEntity<>("Successfully Deleted Theatre with id: " + theaterId, HttpStatus.OK);

		} catch (TheatreNotFoundException e) {
			responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}

	/*
	 * Define a handler method which will update a specific user by reading the
	 * Serialized object from request body and save the updated user details in a
	 * database. This handler method should return any one of the status messages
	 * basis on different situations: 1. 200(OK) - If the theatre updated
	 * successfully. 2. 404(NOT FOUND) - If the user with specified Id is not found.
	 * 
	 * This handler method should map to the URL "/api/v1/theatre/{emailId}" using
	 * HTTP PUT method.
	 */

	@PutMapping("/api/v1/theatre/{emailId}")
	public ResponseEntity<?> updateTheatre(@PathVariable() String emailId, @RequestBody Theatre theatre)
			throws TheatreNotFoundException {

		ResponseEntity<?> responseEntity = null;

		try {
			Theatre fetchedTheatre = theatreService.updateTheatre(emailId, theatre);
			responseEntity = new ResponseEntity<>(fetchedTheatre, HttpStatus.OK);
		} catch (TheatreNotFoundException exception) {

			responseEntity = new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);

		}

		return responseEntity;
	}

	/*
	 * Define a handler method which will get us the theatre by a emailId.
	 * 
	 * This handler method should return any one of the status messages basis on
	 * different situations: 1. 200(OK) - If the theatre found successfully.
	 * 
	 * 
	 * This handler method should map to the URL "/api/v1/theatre/{emailId}" using
	 * HTTP GET method
	 */

	@GetMapping("/api/v1/theatre/{emailId}")
	public ResponseEntity<?> getTheatreByemailId(@PathVariable String emailId) throws TheatreNotFoundException {
		try {

			Theatre getuser = theatreService.getTheatreByemailId(emailId);
			if (getuser == null)
				return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
			else
				return new ResponseEntity<Theatre>(getuser, HttpStatus.OK);
		}

		catch (TheatreNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}