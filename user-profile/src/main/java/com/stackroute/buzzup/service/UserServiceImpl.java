package com.stackroute.buzzup.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.stackroute.buzzup.configuration.KafkaConfiguration;
import com.stackroute.buzzup.exceptions.ProfileAlreadyExitsException;
import com.stackroute.buzzup.exceptions.UpdateFailedException;
import com.stackroute.buzzup.exceptions.UserDoesNotExistsException;
import com.stackroute.buzzup.kafka.model.InputUser;
import com.stackroute.buzzup.kafka.model.UserProfile;
import com.stackroute.buzzup.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	
	private UserRepository userRepository;
	private KafkaConfiguration kafkaConfig;

	
	@Autowired
	public UserServiceImpl(UserRepository userRepository, KafkaConfiguration kafkaConfig) {

		this.userRepository = userRepository;
		this.kafkaConfig = kafkaConfig;
	}

	String topic = kafkaConfig.getTopic();

	
	@Autowired
	private KafkaTemplate<String, InputUser> kafkaTemplate;

	
	@Override
	public InputUser saveUser(InputUser inputUser) throws ProfileAlreadyExitsException {
		if (userRepository.findByEmailId(inputUser.getEmailId()) == null) {
			kafkaTemplate.send(topic, inputUser);
			kafkaTemplate.send("details11", inputUser);
			inputUser.setPassword(null);
			InputUser userSaved = userRepository.save(inputUser);
			logger.info("Profile is saved into database-servicelayer");
			return userSaved;
		} else {
			
			logger.warn("Profile is not added into database-servicelayer");
			throw new ProfileAlreadyExitsException("Profile already exists");
		}

	}

	// this method is to view user from databases
	@Override
	public InputUser viewUser(String emailId) throws UserDoesNotExistsException {
		if (userRepository.findByEmailId(emailId) != null) {
			InputUser findUser = userRepository.findByEmailId(emailId);
			logger.info("Profile is viewd from database");
			return findUser;

		} else {
			// Error Handling
			logger.warn("Profile does not exits in database-servicelayer");
			throw new UserDoesNotExistsException("InputUser Does Not Exist");
		}
	}

	@Override
	public InputUser updateUser(String userId, UserProfile user)
			throws UpdateFailedException, UserDoesNotExistsException {
		// initilization of user domain object
		InputUser finduser = null;
		if (userRepository.findByEmailId(userId) != null) {
			finduser = userRepository.findByEmailId(userId);
			finduser.setAge(user.getAge());
			finduser.setMovieGenre(user.getMovieGenre());
			finduser.setPrefLang(user.getPrefLang());
			finduser.setCity(user.getCity());
			//finduser.setPaymentMethods(user.getPaymentMethods());
			logger.info("Profile is updated into database-servicelayer");
			return finduser;
		} else {
			// Error Handling
			logger.warn("Profile is not updated into database-servicelayer");
			throw new UserDoesNotExistsException("InputUser Does Not Exist");
		}

	}

}
