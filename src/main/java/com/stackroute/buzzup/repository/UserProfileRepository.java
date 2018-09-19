package com.stackroute.buzzup.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.buzzup.model.UserProfile;

/*
* This class is implementing the MongoRepository interface for UserProfile.
* */
@Repository
public interface UserProfileRepository extends MongoRepository<UserProfile, String> {

}