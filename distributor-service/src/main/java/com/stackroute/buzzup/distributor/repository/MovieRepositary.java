package com.stackroute.buzzup.distributor.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.buzzup.distributor.domain.Movie;


@Repository
public interface MovieRepositary extends MongoRepository<Movie, String> {

	
	public List<Movie> getByMovieName(String movieName);

	public Movie getById(String id);

}
