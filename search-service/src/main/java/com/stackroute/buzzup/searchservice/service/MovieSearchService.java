package com.stackroute.buzzup.searchservice.service;

import java.util.List;

import com.stackroute.buzzup.kafka.model.MovieSchedule;
import com.stackroute.buzzup.searchservice.model.City;
import com.stackroute.buzzup.searchservice.model.Movie;



public interface MovieSearchService {
	public String saveCity(City city);

	public City getByCity(String city);

	public List<Movie> getByTitle(String movieName)  ;

	public void consumeKafka(MovieSchedule movieschedule);

	
}
