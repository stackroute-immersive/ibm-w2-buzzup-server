package com.stackroute.buzzup.service;

import com.stackroute.buzzup.exceptions.UserAlreadyExistsException;
import com.stackroute.buzzup.exceptions.UserNotFoundException;
import com.stackroute.buzzup.model.User;

public interface UserService {

	boolean createUser(User user) throws UserAlreadyExistsException;
	
	boolean deleteUser(String eamilId) throws UserNotFoundException;
	
	User updateUser(String emailId, User user) throws UserNotFoundException;
	
	User getUser(String emailId) throws UserNotFoundException;
	
}
