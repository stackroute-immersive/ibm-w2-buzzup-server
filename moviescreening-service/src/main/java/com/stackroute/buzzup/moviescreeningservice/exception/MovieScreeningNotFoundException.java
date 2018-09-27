package com.stackroute.buzzup.moviescreeningservice.exception;

/*
 * Exception class if the movie screening searched for is not found or present
 */
public class MovieScreeningNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public MovieScreeningNotFoundException(String message) {
		super("movie screening not found");
	}
}
