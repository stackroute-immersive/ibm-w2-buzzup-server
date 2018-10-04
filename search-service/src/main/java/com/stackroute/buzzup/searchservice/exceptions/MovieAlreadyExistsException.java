package com.stackroute.buzzup.searchservice.exceptions;

public class MovieAlreadyExistsException extends Exception
{
	
private static final long serialVersionUID= 1L;
	
	public MovieAlreadyExistsException(String message) 
	{
		super(message);
	}

}
