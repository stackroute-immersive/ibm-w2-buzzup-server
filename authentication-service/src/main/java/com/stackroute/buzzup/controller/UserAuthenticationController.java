
package com.stackroute.buzzup.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.buzzup.exception.UserIdAndPasswordMismatchException;
import com.stackroute.buzzup.exception.UserNotFoundException;
import com.stackroute.buzzup.exception.UserNullException;
import com.stackroute.buzzup.kafka.model.User;
import com.stackroute.buzzup.service.UserAuthenticationService;


/* As the application is made of RESTful web services, this class is annotated with @RestController annotation.
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class UserAuthenticationController 
{
	@Autowired
	private UserAuthenticationService authicationService;
	/*
	 * This handler method is used to create a user and it calls the corresponding
	 * UserService methods to store the user information in a database.
	 */
	
	
//	@SuppressWarnings("rawtypes")
//	@PostMapping("/v1/auth/register")
//	public ResponseEntity registerUser(@RequestBody User user) {
//		ResponseEntity responseEntity = null;
//		try 
//		{
//			authicationService.saveUser(user);
//			responseEntity = new ResponseEntity<User>(user, HttpStatus.CREATED);
//		} catch (UserAlreadyExistsException exception) {
//			responseEntity = new ResponseEntity<String>("{ \"message\": \"" + exception.getMessage() + "\"}",
//					HttpStatus.CONFLICT);
//		}
//		return responseEntity;
//	}


	/*
	 * This handler method is used to authenticate the user based on the credentials
	 * provided(emailId,password). Once authentication is done, a JWT token is
	 * returned to the client.
	 */
	
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/login")
	public ResponseEntity loginUser(@RequestBody User loginDetails)
	{
		try
		{
			String userId = loginDetails.getEmailId();
			String password = loginDetails.getPassword();
			if (userId == null || password == null) {
				throw new UserNullException("Userid and Password cannot be empty");
			}
			Map<String, String> map = authicationService.findByIdAndPassword(userId, password);
			return new ResponseEntity<>(map, HttpStatus.OK);
		} 
		catch (UserNullException | UserNotFoundException | UserIdAndPasswordMismatchException exception) 
		{
			return new ResponseEntity<>("{ \"message\": \"" + exception.getMessage() + "\"}", HttpStatus.UNAUTHORIZED);
		}
	}
}
