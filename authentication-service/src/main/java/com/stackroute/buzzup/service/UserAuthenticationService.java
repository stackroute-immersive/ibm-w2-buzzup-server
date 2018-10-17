package com.stackroute.buzzup.service;

import java.util.Map;

import com.stackroute.buzzup.exception.UserAlreadyExistsException;
import com.stackroute.buzzup.exception.UserIdAndPasswordMismatchException;
import com.stackroute.buzzup.exception.UserNotFoundException;
import com.stackroute.buzzup.kafka.model.User;

public interface UserAuthenticationService {

	public Map<String,String> findByIdAndPassword(String emailId, String password) throws UserNotFoundException, UserIdAndPasswordMismatchException;

	boolean saveUser(User user) throws UserAlreadyExistsException;

}
