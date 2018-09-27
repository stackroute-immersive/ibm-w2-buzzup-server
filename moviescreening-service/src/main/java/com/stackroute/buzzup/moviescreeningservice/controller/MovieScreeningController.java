package com.stackroute.buzzup.moviescreeningservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.buzzup.moviescreeningservice.exception.MovieScreeningNotCreatedException;
import com.stackroute.buzzup.moviescreeningservice.exception.MovieScreeningNotFoundException;
import com.stackroute.buzzup.moviescreeningservice.model.MovieScreening;
import com.stackroute.buzzup.moviescreeningservice.service.MovieScreeningService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class MovieScreeningController {

	/*
	 * define get and post handler method for movie-screening
	 * 
	 */
	 private MovieScreeningService movieScreeningService;

	@Autowired
	public MovieScreeningController(MovieScreeningService movieScreeningService) {
		this.movieScreeningService = movieScreeningService;
	}

	@PostMapping("/movie")
	public ResponseEntity<?> saveMovieScreening(@RequestBody MovieScreening movieScreening) {
		ResponseEntity<?> responseEntity = null;
		try {
			MovieScreening ms = movieScreeningService.saveMovieDetails(movieScreening);
			responseEntity = new ResponseEntity<MovieScreening>(ms, HttpStatus.CREATED);
		} catch (MovieScreeningNotCreatedException e) {
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		}
		return responseEntity;
	}

	@GetMapping("/movie/{id}")
	public ResponseEntity<?> getTheaterDetails(@PathVariable("id") String id) {
		ResponseEntity<?> responseEntity = null;
		try {
			List<MovieScreening> mos = movieScreeningService.getTheaterByCity(id);
			responseEntity = new ResponseEntity<List<MovieScreening>>(mos, HttpStatus.OK);
		} catch (MovieScreeningNotFoundException e) {
			responseEntity = new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
}
