package com.stackroute.buzzup.searchservice.controller;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.buzzup.searchservice.model.City;
import com.stackroute.buzzup.searchservice.model.Movie;
import com.stackroute.buzzup.searchservice.service.MovieSearchServiceImpl;

/*
 *As we are working with Restful services,we annotate this class with @RestController.
 *If we use @ResponseBody annotation along with @Controller annotation, it will return the data 
 *directly in a serialized format since @RestController annotation is equivalent to using @Controller 
 *and @ResponseBody.
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/v1")

public class MovieSearchController {
	private MovieSearchServiceImpl searchService;

	/*
	 * We use Constructor-based Autowiring for SearchController class. (No use of
	 * new keyword for creating an object)
	 */

	@Autowired
	public MovieSearchController(MovieSearchServiceImpl searchService) {
		this.searchService = searchService;
	}

	/*
	 * The below handler method is mapped to the URL "/api/v1/city" inorder to save
	 * the city details. It must return any one of the status messages based on the
	 * the retrieved result: 1.201(CREATED) - If the city is found
	 */

	@PostMapping(value = "/city")
	public ResponseEntity<?> saveCity(@RequestBody City city) {

		String response = searchService.saveCity(city);
		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	/*
	 * The below handler method is mapped to the URL "/api/v1/movie/{movieName}"
	 * inorder to get all movie details by a particular movie name. It must return
	 * any one of the status messages based on the the retrieved result: 1.200(OK) -
	 * If the movie is found
	 */

	@GetMapping(value = "/movie/{movieName}")
	public ResponseEntity<?> getMovieByName(@PathVariable String movieName) {

		List<Movie> movie = searchService.getByTitle(movieName);
		return new ResponseEntity<List<Movie>>(movie, HttpStatus.OK);

	}

	/*
	 * The below handler method is mapped to the URL "/api/v1/city/{cityName}" in
	 * order to get all movie details by a particular city name. It must return any
	 * one of the status messages based on the the retrieved result: 1.200(OK) - If
	 * the movie is found
	 */

	@GetMapping(value = "/city/{cityName}")
	public ResponseEntity<?> getCityByName(@PathVariable String cityName) {

		City city = searchService.getByCity(cityName);
		return new ResponseEntity<City>(city, HttpStatus.OK);

	}

}
