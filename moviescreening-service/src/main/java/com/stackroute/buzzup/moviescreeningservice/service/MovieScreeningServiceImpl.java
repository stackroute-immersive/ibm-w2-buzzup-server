package com.stackroute.buzzup.moviescreeningservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.buzzup.moviescreeningservice.exception.MovieScreeningNotCreatedException;
import com.stackroute.buzzup.moviescreeningservice.exception.MovieScreeningNotFoundException;
import com.stackroute.buzzup.moviescreeningservice.model.MovieScreening;
import com.stackroute.buzzup.moviescreeningservice.repository.MovieScreeningRepository;

@Service
public class MovieScreeningServiceImpl implements MovieScreeningService {

	/*
	 * This Class implements the methods of MovieServiceInterface
	 * 
	 */

	private MovieScreeningRepository movieScreeningRepository;

	@Autowired
	public MovieScreeningServiceImpl(MovieScreeningRepository moviescreeningrepo) {
		this.movieScreeningRepository = moviescreeningrepo;
	}

	public MovieScreening saveMovieDetails(MovieScreening movieScreening) throws MovieScreeningNotCreatedException {
		MovieScreening mov = movieScreeningRepository.insert(movieScreening);
		if (mov == null) {
			throw new MovieScreeningNotCreatedException("Screening Not Created");
		}
		return mov;
	}

	/*
	 * public MovieScreening getTheaterById(String theaterScreeningId) throws
	 * MovieScreeningNotFoundException { MovieScreening ms =
	 * moviescreeningrepo.findById(theaterScreeningId).get(); if (ms == null) {
	 * throw new MovieScreeningNotFoundException("Movie Screening Not Found"); }
	 * return ms; }
	 */

	public List<MovieScreening> getTheaterByCity(String city) throws MovieScreeningNotFoundException {
		List<MovieScreening> movieScreening = movieScreeningRepository.getByCity(city);
		if (movieScreening== null) {
			throw new MovieScreeningNotFoundException("movie Screening not found");
		}
		return movieScreening;
	}

}
