package com.stackroute.buzzup.exceptions;

public class UserAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserAlreadyExistsException(String msg)
	{ super(msg);
	
	}
}
