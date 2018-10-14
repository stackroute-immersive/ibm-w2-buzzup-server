package com.stackroute.buzzup.service;

import com.stackroute.buzzup.exceptions.ProfileAlreadyExitsException;
import com.stackroute.buzzup.exceptions.UpdateFailedException;
import com.stackroute.buzzup.exceptions.UserDoesNotExistsException;
import com.stackroute.buzzup.kafka.model.InputUser;
import com.stackroute.buzzup.kafka.model.UserProfile;

public interface UserService {

	public InputUser saveUser(InputUser inputUser) throws ProfileAlreadyExitsException ;

	public InputUser viewUser(String userId) throws UserDoesNotExistsException;
	
	public InputUser updateUser(String userId, UserProfile user) throws UpdateFailedException,UserDoesNotExistsException;
	
	
}
