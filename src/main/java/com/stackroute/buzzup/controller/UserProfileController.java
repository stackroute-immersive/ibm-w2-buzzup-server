package com.stackroute.buzzup.controller;

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

import com.stackroute.buzzup.exceptions.UserAlreadyExistsException;
import com.stackroute.buzzup.model.UserProfile;
import com.stackroute.buzzup.service.UserProfileService;

@RestController
@CrossOrigin("*")
public class UserProfileController {

	UserProfileService userProfileService;
	
	@Autowired
	public UserProfileController(UserProfileService userProfileService) {
		super();
		this.userProfileService = userProfileService;
	}
	
	/*
	 * This is a handler method which will create a specific user by reading the
	 * Serialized object from request body and save the user details in the
	 * database. This handler method returns any one of the status messages
	 * basis on different situations:
	 * 1. 201(CREATED) - If the user created successfully. 
	 * 2. 409(CONFLICT) - If the userId conflicts with any existing user
	 * 
	 * This handler method should map to the URL "/api/v1/userprofile" using HTTP POST method
	 */
	
	@PostMapping("/api/v1/userprofile")
	public ResponseEntity<?> register(@RequestBody UserProfile userProfile){
		try{		
			userProfileService.registerUser(userProfile);
			return new ResponseEntity<UserProfile>(userProfile,HttpStatus.CREATED);
			
		}catch(UserAlreadyExistsException e) 
		{
			return new ResponseEntity<String>("User Already Exists",HttpStatus.CONFLICT);
			
		}
	}

	/*
	 *This is a  handler method which will update a specific user by reading the
	 * Serialized object from request body and save the updated user details in a
	 * database. This handler method will return any one of the status messages
	 * basis on different situations: 
	 * 1. 200(OK) - If the user updated successfully.
	 * 2. 404(NOT FOUND) - If the user with specified userId is not found.
	 * 
	 * This handler method maps to the URL "/api/v1/userprofile/{id}" using HTTP PUT method.
	 */
	
	@PutMapping("/api/v1/userprofile/{id}")
    public ResponseEntity<?> updateUser(@RequestBody UserProfile userProfile) {
        try {
           
            UserProfile userUpdated = userProfileService.updateUser(userProfile.getUserId(), userProfile);
            if (userUpdated != null) {
                return new ResponseEntity<UserProfile>(userProfile, HttpStatus.OK);
            }
            else
                return new ResponseEntity<String>("Not Found", HttpStatus.NOT_FOUND);
        }  catch (Exception e) {
            return new ResponseEntity<String>("Not Found", HttpStatus.NOT_FOUND);
        }
    }

	/*
	 * This is a handler method which will delete a user from a database.
	 * This handler method will return any one of the status messages based on
	 * different situations: 
	 * 1. 200(OK) - If the user deleted successfully from database. 
	 * 2. 404(NOT FOUND) - If the user with specified userId is not found.
	 *
	 * This handler method maps to the URL "/api/v1/userprofile/{id}" using HTTP Delete
	 * method".
	 */
	
	@DeleteMapping("/api/v1/userprofile/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable String id) {
        try {
        	boolean userDel=userProfileService.deleteUser(id);
       
                if(userDel!=false)
                {
                    return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
            }
            else {
            	 return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
            }
        } catch(Exception e) {
            return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
        }
    }
	
	/*
	 * This is a  handler method which shows details of a specific user. This
	 * handler method will return any one of the status messages based on
	 * different situations: 
	 * 1. 200(OK) - If the user found successfully. 
	 * 2. 404(NOT FOUND) - If the user with specified userId is not found. 
	 * This handler method swill map to the URL "/api/v1/userprofile/{id}" using HTTP GET method .
	 */
	@GetMapping("/api/v1/userprofile/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") String id) {
        try {
           
            	UserProfile getuser=userProfileService.getUserById(id);
                if(getuser==null)
                	 return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
                else
                    return new ResponseEntity<UserProfile>(getuser, HttpStatus.OK);
            }
           
        catch(Exception e) {
            return new ResponseEntity<String>("User not found", HttpStatus.NOT_FOUND);
        }
    }

}
