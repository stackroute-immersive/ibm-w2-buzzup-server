package com.stackroute.buzzup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.buzzup.kafka.model.User;

@Repository
public interface UserAuthenticationRepository extends JpaRepository<User, String> 
{
	//boolean saveUser(User user) throws UserAlreadyExistsException;
	User findByEmailIdAndPassword(String emailId, String password);
}