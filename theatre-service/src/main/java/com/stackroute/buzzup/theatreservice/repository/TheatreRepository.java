package com.stackroute.buzzup.theatreservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.buzzup.theatreservice.model.Theatre;

@Repository
public interface TheatreRepository extends MongoRepository<Theatre, Integer> {

	public Theatre getByName(String name);

	public Theatre getByEmailId(String emailId);

	public boolean existsByName(String name);

}
