package com.stackroute.buzzup.moviescreeningservice.service;

import java.util.List;

import com.stackroute.buzzup.kafka.domain.MovieSchedule;
import com.stackroute.buzzup.kafka.domain.Theatre;

public interface MovieScheduleService {

	public MovieSchedule addMovieSchedule(MovieSchedule movieSchedule);
	public List<MovieSchedule> getMoviesSchedule();

	public MovieSchedule updateMovieSchedule(String email, MovieSchedule updateMovie);
	public void consumeKafka(Theatre theatre);
	

}
