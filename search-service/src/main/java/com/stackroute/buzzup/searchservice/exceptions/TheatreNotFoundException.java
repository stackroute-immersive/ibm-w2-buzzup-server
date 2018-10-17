package com.stackroute.buzzup.searchservice.exceptions;

public class TheatreNotFoundException extends Exception 
{
    private static final long serialVersionUID = 1L;

    public TheatreNotFoundException(String message) {
       super(message);
   }
}