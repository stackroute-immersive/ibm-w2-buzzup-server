package com.stackroute.buzzup.recommendationservice.exceptions;

public class NoMoviesFoundException extends Exception{
	private static final long serialVersionUID = 1L;    
	public NoMoviesFoundException(String message) {
        super(message);
    }
}
