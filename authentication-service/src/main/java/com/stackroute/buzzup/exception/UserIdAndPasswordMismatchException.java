package com.stackroute.buzzup.exception;

public class UserIdAndPasswordMismatchException extends Exception {
	private static final long serialVersionUID = 1L;
	public UserIdAndPasswordMismatchException(String message) {
		super(message);
	}

}
