package com.stackroute.buzzup.searchservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.stackroute.buzzup.searchservice.model.Movie;

public interface MovieRepository extends MongoRepository<Movie, Integer> {

	public List<Movie> getBymovieName(String movieName);

	public Movie findByMovieName(String movieName);

	public boolean existsByMovieName(String movieName);

	//public Movie getByMovieId(String movieId);
}
