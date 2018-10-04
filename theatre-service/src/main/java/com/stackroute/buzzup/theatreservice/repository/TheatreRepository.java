package com.stackroute.buzzup.theatreservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.buzzup.theatreservice.model.Theatre;
/*
* This class is implementing the MongoRepository interface for Theatre.
* Annotate this class with @Repository annotation
* */
@Repository
public interface TheatreRepository extends MongoRepository<Theatre, String>
{
	/*
	 * Apart from the standard CRUD methods already available in Mongo Repository,
	 * based on our requirements, we might need to create few methods for getting
	 * specific data from the datasource.
	 */
}