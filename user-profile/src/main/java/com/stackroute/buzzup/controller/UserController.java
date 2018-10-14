package com.stackroute.buzzup.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.buzzup.exceptions.ProfileAlreadyExitsException;
import com.stackroute.buzzup.exceptions.UpdateFailedException;
import com.stackroute.buzzup.exceptions.UserDoesNotExistsException;
import com.stackroute.buzzup.kafka.model.InputUser;
import com.stackroute.buzzup.kafka.model.UserProfile;
import com.stackroute.buzzup.service.UserService;

@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/v1/userProfile")
@RestController
public class UserController {

	
	private UserService userService;


	private final Logger logger = LoggerFactory.getLogger(this.getClass());


	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	
	@RequestMapping(value = "/regestration", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody InputUser inputUser) throws ProfileAlreadyExitsException {
		
		try {
			InputUser userobj = userService.saveUser(inputUser);
			System.out.println(inputUser.getPrefLang());
			System.out.println(inputUser.getAge());
			logger.info("movie is saved into database");
			return new ResponseEntity<InputUser>(userobj, HttpStatus.CREATED);
		} catch (ProfileAlreadyExitsException m) {
			
			String result = m.getMessage();
			logger.warn("movie is not added into database");
			return new ResponseEntity<String>(result, HttpStatus.CONFLICT);
		}

	}

	@RequestMapping(value = "/user/{userid}", method = RequestMethod.GET)
	public ResponseEntity<?> viewuser(@PathVariable String userid) throws UserDoesNotExistsException {
		try {
			InputUser userobj = userService.viewUser(userid);
			logger.info("InputUser retrived from database");
			return new ResponseEntity<InputUser>(userobj, HttpStatus.FOUND);
		} catch (UserDoesNotExistsException m) {
			
			String result = m.getMessage();
			logger.warn("movie is not found in database");
			return new ResponseEntity<String>(result, HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "/user/{userid}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateuser(@PathVariable String userid, @RequestBody UserProfile user)
			throws UpdateFailedException, UserDoesNotExistsException {
		try {
			InputUser userobj = userService.updateUser(userid, user);
			logger.info("InputUser updated");
			return new ResponseEntity<InputUser>(userobj, HttpStatus.OK);
		} catch (UserDoesNotExistsException m) {
			
			String result = m.getMessage();
			logger.warn("movie is not updated");
			return new ResponseEntity<String>(result, HttpStatus.NOT_MODIFIED);
		}

	}

}
