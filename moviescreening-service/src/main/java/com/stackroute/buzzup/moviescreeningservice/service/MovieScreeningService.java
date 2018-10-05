package com.stackroute.buzzup.moviescreeningservice.service;

import java.util.List;

import com.stackroute.buzzup.kafka.model.MovieSchedule;

/*
 * this interface contains methods which are to be implemented in serviceImpl class
 */
public interface MovieScreeningService {

	
	public MovieSchedule addMovieSchedule(MovieSchedule movieSchedule);

	public List<MovieSchedule> getMoviesSchedule();
	
	public MovieSchedule updateMovieSchedule(String email, MovieSchedule updateMovie);
	
	
}
