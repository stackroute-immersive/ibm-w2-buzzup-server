package com.stackroute.buzzup.moviescreeningservice.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.buzzup.moviescreeningservice.model.MovieScreening;

@Repository
public interface MovieScreeningRepository extends MongoRepository<MovieScreening, String> {
	/*
	 * this is an interface which performs CRUD operations using MongoRepository
	 * Interface and there is an additional method for listing out all the movies on
	 * the basis of cities
	 */
	List<MovieScreening> getByCity(String city);
}
