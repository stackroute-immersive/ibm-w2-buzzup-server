package com.stackroute.buzzup.moviescreeningservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.buzzup.kafka.model.MovieSchedule;

/*
 * MovieScreeningrepository extends the mongo repository which provides the functions for CRUD operations 
 * here we have 3 additional methods to be used in service class 
 */
@Repository
public interface MovieScreeningRepository extends MongoRepository<MovieSchedule, Integer> {

	
	public MovieSchedule getByTheatreName(String theatreName);
	
	public MovieSchedule getByTheatreId(String theatreId);
	
	public MovieSchedule getByEmailId(String email);

}
