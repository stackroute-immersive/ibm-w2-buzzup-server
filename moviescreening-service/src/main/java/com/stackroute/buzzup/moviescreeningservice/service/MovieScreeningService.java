package com.stackroute.buzzup.moviescreeningservice.service;

import java.util.List;

import com.stackroute.buzzup.moviescreeningservice.exception.MovieScreeningNotCreatedException;
import com.stackroute.buzzup.moviescreeningservice.exception.MovieScreeningNotFoundException;
import com.stackroute.buzzup.moviescreeningservice.model.MovieScreening;

public interface MovieScreeningService {

	/*
	 * this is an interface for Crud methods and will be implemented by ServiceImpl
	 * class and has one method to get all the movies in a particular city
	 */

	MovieScreening saveMovieDetails(MovieScreening movieScreening) throws MovieScreeningNotCreatedException;

	List<MovieScreening> getTheaterByCity(String city) throws MovieScreeningNotFoundException;
}
