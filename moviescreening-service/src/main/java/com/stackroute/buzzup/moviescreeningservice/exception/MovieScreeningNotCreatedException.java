package com.stackroute.buzzup.moviescreeningservice.exception;

/*
 * Exception class for movie screening not created properly
 */
public class MovieScreeningNotCreatedException extends Exception {
	private static final long serialVersionUID = 1L;

	public MovieScreeningNotCreatedException(String message) {
		super("movie screening not created ");
	}
}
