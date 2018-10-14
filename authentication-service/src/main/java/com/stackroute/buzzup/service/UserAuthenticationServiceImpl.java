package com.stackroute.buzzup.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.buzzup.exception.UserAlreadyExistsException;
import com.stackroute.buzzup.exception.UserIdAndPasswordMismatchException;
import com.stackroute.buzzup.exception.UserNotFoundException;
import com.stackroute.buzzup.kafka.model.User;
import com.stackroute.buzzup.repository.UserAuthenticationRepository;
import com.stackroute.buzzup.security.SecurityTokenGenerator;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class UserAuthenticationServiceImpl implements UserAuthenticationService 
{

	@Autowired
	private UserAuthenticationRepository authenticationRepository;

	@Override
	public Map<String, String> findByIdAndPassword(String emailId, String password) throws UserNotFoundException ,UserIdAndPasswordMismatchException{
		Map<String,String> map=new HashMap<>();
		User user = authenticationRepository.findByEmailIdAndPassword(emailId, password);
		if (user == null) {
			throw new UserNotFoundException("User Not Found");
		}
		if (!password.equals(user.getPassword())) {
			throw new UserIdAndPasswordMismatchException(
					"Invalid login credential, Please check username and password ");
		}
		// generating token
		SecurityTokenGenerator securityTokenGenrator = (User userDetails) -> {
		String jwtToken = "";
		jwtToken = Jwts.builder()
				.setId(user.getEmailId())
				.claim("name", user.getUserName())
				.setSubject(user.getUserRole())
				.setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256, "secretkey").compact();
		Map<String, String> map1 = new HashMap<>();
		map1.put("token", jwtToken);
		map1.put("message", "User successfully logged in");
		return map1;
		};
		map = securityTokenGenrator.generateToken(user);
		return map;
	}

	@Override
	public boolean saveUser(User user) throws UserAlreadyExistsException {
		Optional<User> fetchedUser = authenticationRepository.findById(user.getEmailId());
		if (fetchedUser.isPresent()) {
			throw new UserAlreadyExistsException("User with EmailId already exists");
		}
		authenticationRepository.save(user);
		return true;
	}

}
