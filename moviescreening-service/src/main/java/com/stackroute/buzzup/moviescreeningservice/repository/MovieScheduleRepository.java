package com.stackroute.buzzup.moviescreeningservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.buzzup.kafka.domain.MovieSchedule;

@Repository
public interface MovieScheduleRepository extends MongoRepository<MovieSchedule, Integer> {

	public MovieSchedule getByTheatreName(String theatreName);
	
	public MovieSchedule getByTheatreId(String theatreId);
	
	public MovieSchedule getByEmail(String email);

}
