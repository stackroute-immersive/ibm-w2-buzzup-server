package com.stackroute.Distributorservice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.Distributorservice.model.Movie;
import com.stackroute.Distributorservice.repository.MovieRepository;

//This service implementations gives the functionality
@Service
public class ServicesImpl implements Services {

	// Instance of repository
	@Autowired
	private MovieRepository movieRepositary;

	// @Autowired
	public ServicesImpl(MovieRepository movieRepository) {
		this.movieRepositary = movieRepositary;
	}

	// This saves the movie to database
	@Override
	public Movie saveMovie(Movie movie) {
		Movie savedMovie = movieRepositary.save(movie);
		return savedMovie;

	}

	// This gets the movie from database by movie title
	@Override
	public List<Movie> getByMovieTitle(String movieTitle) {
		List<Movie> movies = movieRepositary.getByMovieName(movieTitle);
		return movies;
	}

	// This gets all the movies from the database
	@Override
	public List<Movie> getAllMovies() {
		List<Movie> movies = (List<Movie>) movieRepositary.findAll();
		return movies;
	}
	@Override
    public Movie getByCity(String distributorCity) {
        Movie fetchedMovie = movieRepositary.getByCity(distributorCity);
        return fetchedMovie;
    }

}
