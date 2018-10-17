package com.stackroute.buzzup.recommendationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.buzzup.recommendationservice.model.Movie;
import com.stackroute.buzzup.recommendationservice.services.MovieService;




@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class RecommendationServiceController {

	 MovieService movieService;


	@Autowired
	public RecommendationServiceController(MovieService movieService) {
		super();
		this.movieService = movieService;

	}




	@GetMapping("/getGenreBasedMoviesForUser/{emailId}")
	public ResponseEntity<List<Movie>> getGenreBasedMoviesForUser(@PathVariable String emailId) {
		System.out.println("hello"+ emailId);
		return new ResponseEntity<List<Movie>>(movieService.getGenreBasedMoviesForUser(emailId), HttpStatus.OK);
	}

	@GetMapping("/getLanguageBasedMoviesForUser/{emailId}")
	public ResponseEntity<List<Movie>> getLanguageBasedMoviesForUser(@PathVariable String emailId) {
		System.out.println("hello language");
		return new ResponseEntity<List<Movie>>(movieService.getLanguageBasedMoviesForUser(emailId), HttpStatus.OK);
	}
	
	@GetMapping("/getGenreLanguageBasedMoviesForUser/{emailId}")
	public ResponseEntity<List<Movie>> getGenreLanguageBasedMoviesForUser(@PathVariable String emailId) {
		System.out.println("hello genre");
		return new ResponseEntity<List<Movie>>(movieService.getGenreLanguageBasedMoviesForUser(emailId), HttpStatus.OK);
	}
	@GetMapping("/getTrendingMovies")
	public ResponseEntity<List<Movie>> getTrendingMovies(){
		System.out.println("hello genre");
		return new ResponseEntity<List<Movie>>(movieService.getTrendingMovies(), HttpStatus.OK);
	}
}