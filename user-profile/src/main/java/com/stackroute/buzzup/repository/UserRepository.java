package com.stackroute.buzzup.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.buzzup.model.User;

/*Marking this class as @Repository as it will interact with the MongoDB
 * */

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
