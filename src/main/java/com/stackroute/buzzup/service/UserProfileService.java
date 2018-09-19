package com.stackroute.buzzup.service;

import com.stackroute.buzzup.exceptions.UserAlreadyExistsException;
import com.stackroute.buzzup.exceptions.UserNotFoundException;
import com.stackroute.buzzup.model.UserProfile;

public interface UserProfileService {

	 UserProfile registerUser(UserProfile user) throws UserAlreadyExistsException;

	    UserProfile updateUser(String userId,UserProfile user) throws UserNotFoundException;

	    boolean deleteUser(String userId) throws UserNotFoundException;

	    UserProfile getUserById(String userId) throws UserNotFoundException;
}
