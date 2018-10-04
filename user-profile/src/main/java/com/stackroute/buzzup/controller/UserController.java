package com.stackroute.buzzup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.buzzup.model.User;
import com.stackroute.buzzup.service.UserService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class UserController {

	private UserService userService;
	// Adding for Kafka Connection. 2 Lines.
	private KafkaTemplate<String, User> kafkaTemplate;
	private String BOOT_TOPIC = "userData";

	/*
	 * @Autowired for injecting constructor based dependency in UserService
	 * argument.
	 */

	@Autowired
	// Add Kafka Template in Constructor.
	public UserController(UserService userService, KafkaTemplate<String, User> kafkaTemplate) 
	{
		super();
		this.userService = userService;
		this.kafkaTemplate = kafkaTemplate;
	}

	/*
	 * A method is created for registering the User and mapped with api "/user". On
	 * successful creation of user return HttpStatus as 201 Created and if the user
	 * is already present return HttpStatus as 409 CONFLICT.
	 */

	@PostMapping("/user")
	public ResponseEntity<?> registerUser(@RequestBody User user) 
	{
		ResponseEntity<?> responseEntity;
		try {
			if (user.getEmailId().matches("^[a-zA-Z0-9]+@[a-zA-Z0-9-]*.[a-zA-Z0-9-]*")) 
			{
				kafkaTemplate.send(BOOT_TOPIC, user);
				userService.createUser(user);
				responseEntity = new ResponseEntity<User>(user, HttpStatus.CREATED);
			} else
				responseEntity = new ResponseEntity<String>("Email Id not valid", HttpStatus.NOT_ACCEPTABLE);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>("User Already Exists", HttpStatus.CONFLICT);
		}
		return responseEntity;
	}

	/*
	 * Method for deleting a User with the specified userID and map this method with
	 * the api "/user/{id}". On successful deletion return HttpStatus 200 OK and if
	 * the user is not found return status as 404 NOT_FOUND
	 */

	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable String id) {
		ResponseEntity<?> responseEntity;
		try {
			userService.deleteUser(id);
			responseEntity = new ResponseEntity<String>("User Deleted", HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>("User Not Found", HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}

	/*
	 * Update method for updation of a user with a specific id with a mapping
	 * "/user/{id}". On successful updation return HttpStatus as 200 OK and if the
	 * user with the id is not found then return HttpStatus as 404 NOT_FOUND
	 */

	@PutMapping("/user/{id}")
	public ResponseEntity<?> updateUser(@PathVariable String id, User user) {
		ResponseEntity<?> responseEntity;
		try {
			User u = userService.updateUser(id, user);
			responseEntity = new ResponseEntity<User>(u, HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>("USer Not Found", HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}

	/*
	 * Get method for getting a user with a specific id with a mapping "/user/{id}".
	 * if getting the user is successful return HttpStatus as 200 OK and if the user
	 * with the id is not found then return HttpStatus as 404 NOT_FOUND
	 */

	@GetMapping("/user/{id}")
	public ResponseEntity<?> getUser(@PathVariable String id) {
		ResponseEntity<?> responseEntity;
		try {
			User u = userService.getUser(id);
			responseEntity = new ResponseEntity<User>(u, HttpStatus.OK);
		} catch (Exception e) {
			responseEntity = new ResponseEntity<String>("User Not Found", HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}

}
