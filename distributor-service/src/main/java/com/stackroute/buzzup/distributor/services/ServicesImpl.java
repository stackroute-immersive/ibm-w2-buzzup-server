package com.stackroute.buzzup.distributor.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.buzzup.distributor.domain.Movie;
import com.stackroute.buzzup.distributor.repository.MovieRepositary;

@Service
public class ServicesImpl implements Services {

	
	@Autowired
	private MovieRepositary movieRepositary;

	
	public ServicesImpl(MovieRepositary movieRepository) {
		this.movieRepositary = movieRepositary;
	}

	
	@Override
	public Movie saveMovie(Movie movie) {
		Movie savedMovie = movieRepositary.save(movie);
		return savedMovie;

	}

	
	@Override
	public List<Movie> getByMovieTitle(String movieTitle) {
		List<Movie> movies = movieRepositary.getByMovieName(movieTitle);
		return movies;
	}


	@Override
	public List<Movie> getAllMovies() {
		List<Movie> movies = (List<Movie>) movieRepositary.findAll();
		return movies;
	}

}
