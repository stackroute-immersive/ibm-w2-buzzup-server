package com.stackroute.buzzup.distributor.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.buzzup.distributor.domain.Movie;
import com.stackroute.buzzup.distributor.services.Services;



@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/api/v1/")
public class MovieController {

	private Services movieServices;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public MovieController(Services movieServices) {
		this.movieServices = movieServices;
	}

	
	@RequestMapping(value = "/movie", method = RequestMethod.POST)
	public ResponseEntity<?> saveMovie(@RequestBody Movie movie) {
		Movie savedMovie;
		savedMovie = movieServices.saveMovie(movie);
		logger.info("movie is saved into database");
		return new ResponseEntity<Movie>(savedMovie, HttpStatus.OK);

	}


	@RequestMapping(value = "/movies", method = RequestMethod.GET)

	public ResponseEntity<List<Movie>> getAllMovies() {
		List<Movie> movies = movieServices.getAllMovies();
		logger.info("retrived all movies from database");
		return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
	}


	@RequestMapping(value = "/getbytitle/movie", method = RequestMethod.GET)
	public ResponseEntity<?> getMovieByTitleFromDB(@RequestParam String movieTitle) {
		List<Movie> movie = movieServices.getByMovieTitle(movieTitle);
		if (!movie.isEmpty()) {
			logger.info("retrived a movies of given titile");
			return new ResponseEntity<List<Movie>>(movie, HttpStatus.FOUND);
		} else {
			logger.warn("No movies of given titile in database");
			return new ResponseEntity<String>("{ \"message\": \"" + "no movies with this name" + "\"}", HttpStatus.OK);
		}
	}



}
