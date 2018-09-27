package com.stackroute.buzzup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.buzzup.exceptions.UserAlreadyExistsException;
import com.stackroute.buzzup.exceptions.UserNotFoundException;
import com.stackroute.buzzup.model.User;
import com.stackroute.buzzup.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;

	/*For injecting the dependency in the UserRepository argument,
	 * @Autowired is used. Here the constructor based dependency
	 * is performed.
	 * */
	
	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	/*All methods of UserService interface are overridden and implemented
	 * */

	@Override
	public boolean createUser(User user) throws UserAlreadyExistsException {
		if(userRepository.insert(user) == null)
			throw new UserAlreadyExistsException("User Already Exists");
		return true;
	}

	@Override
	public boolean deleteUser(String emailId) throws UserNotFoundException {
		User user = userRepository.findById(emailId).get();
		if(user == null)
			throw new UserNotFoundException("User Not Found");
		userRepository.delete(user);
		return true;
	}

	@Override
	public User updateUser(String emailId, User user) throws UserNotFoundException {
		User u = userRepository.findById(emailId).get();
		if(u == null)
			throw new UserNotFoundException("User Not Found");
		if(user.getPassword() != null)
			u.setPassword(user.getPassword());
		if(user.getUserName() != null)
			u.setUserName(user.getUserName());
		userRepository.save(u);
		return u;
	}

	@Override
	public User getUser(String emailId) throws UserNotFoundException {
		User user = userRepository.findById(emailId).get();
		if(user == null)
			throw new UserNotFoundException("User Not Found");
		return user;
	}

}
