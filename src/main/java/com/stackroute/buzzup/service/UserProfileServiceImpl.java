package com.stackroute.buzzup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.buzzup.exceptions.UserAlreadyExistsException;
import com.stackroute.buzzup.exceptions.UserNotFoundException;
import com.stackroute.buzzup.model.UserProfile;
import com.stackroute.buzzup.repository.UserProfileRepository;


/*
* Service classes are used here to implement additional business logic/validation.
* This class will perform CRUD operations for User Profile.
* */


@Service
public class UserProfileServiceImpl implements UserProfileService {

	@Autowired
	UserProfileRepository userProfileRepo;
	
	
	public UserProfileServiceImpl(UserProfileRepository userProfileRepo) {
		this.userProfileRepo = userProfileRepo;
	}

	public UserProfile registerUser(UserProfile user) throws UserAlreadyExistsException {
		UserProfile userProfile;
		userProfile=userProfileRepo.insert(user);
		if(userProfile!=null) {
			return userProfile;
		}
		else
		{
		throw new UserAlreadyExistsException("User already exists! Please Login!");
		}
	}

	
	public UserProfile updateUser(String userId, UserProfile user) throws UserNotFoundException {
		UserProfile updateUser= getUserById(userId);
		if(updateUser!=null) 
		{
			userProfileRepo.save(updateUser);
			return updateUser;			
		}
		else
			throw new UserNotFoundException("user does not exist");
		
	}

	
	public boolean deleteUser(String userId) throws UserNotFoundException {
		UserProfile deletedUser= getUserById(userId);
		if(deletedUser!=null) 
		{
			userProfileRepo.delete(deletedUser);
			return true;			
		}
		else
			throw new UserNotFoundException("User doesn't exist");
	}


	public UserProfile getUserById(String userId) throws UserNotFoundException {
		UserProfile displayUser=userProfileRepo.findById(userId).get();
		if(displayUser!=null) {
			return displayUser;
		}else
			throw new UserNotFoundException("user not found");
			
		
	}

}
