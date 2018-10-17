package com.stackroute.buzzup.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.buzzup.kafka.model.InputUser;

@Repository
public interface UserRepository extends MongoRepository<InputUser,Integer> {

	public InputUser findByEmailId(String string);
}
