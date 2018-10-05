package com.stackroute.buzzup.moviescreeningservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.buzzup.kafka.model.MovieSchedule;
import com.stackroute.buzzup.moviescreeningservice.service.MovieScreeningService;

/*
 * Controller class to hit the api for SAVE,UPDATE AND GET
 *
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class MovieScreeningController {

	private MovieScreeningService movieScheduleService;

	@Autowired
	public MovieScreeningController(MovieScreeningService movieScheduleService) {
		this.movieScheduleService = movieScheduleService;
	}

	@PostMapping(value = "/save")
	public ResponseEntity<?> saveMovie(@RequestBody MovieSchedule movieSchedule) {

		MovieSchedule movieObj = movieScheduleService.addMovieSchedule(movieSchedule);

		return new ResponseEntity<MovieSchedule>(movieObj, HttpStatus.OK);

	}

	@GetMapping(value = "/movies")
	public ResponseEntity<List<MovieSchedule>> getAllMovies() {

		List<MovieSchedule> movieObj = movieScheduleService.getMoviesSchedule();
		return new ResponseEntity<List<MovieSchedule>>(movieObj, HttpStatus.OK);

	}

	@PutMapping(value = "/update")
	public ResponseEntity<?> updateMovie(@RequestParam String emailId, @RequestBody MovieSchedule movieSchedule) {

		MovieSchedule movieObj = movieScheduleService.updateMovieSchedule(emailId, movieSchedule);

		return new ResponseEntity<MovieSchedule>(movieObj, HttpStatus.OK);
	}

}
