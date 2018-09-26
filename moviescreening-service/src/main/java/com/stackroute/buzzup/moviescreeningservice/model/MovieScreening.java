package com.stackroute.buzzup.moviescreeningservice.model;

import java.util.Arrays;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document
public class MovieScreening {
	/*
	 * this class contains member some additional member variables for
	 * movieScreening and an theater reference variable.
	 */
	@Id
	private String theaterScreeningId;
	private Theater theater;
	private String movieName;
	private String[] timeSlot;
	private String[] ticketPrice;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date movieDate;
	private String city;

	public MovieScreening(String theaterScreeningId, Theater theater, String movieName, String[] timeSlot,
			String[] ticketPrice, Date movieDate, String city) {
		super();
		this.theaterScreeningId = theaterScreeningId;
		this.theater = theater;
		this.movieName = movieName;
		this.timeSlot = timeSlot;
		this.ticketPrice = ticketPrice;
		this.movieDate = movieDate;
		this.city = city;
	}

	public MovieScreening() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTheaterScreeningId() {
		return theaterScreeningId;
	}

	public void setTheaterScreeningId(String theaterScreeningId) {
		this.theaterScreeningId = theaterScreeningId;
	}

	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String[] getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(String[] timeSlot) {
		this.timeSlot = timeSlot;
	}

	public String[] getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(String[] ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public Date getMovieDate() {
		return movieDate;
	}

	public void setMovieDate(Date movieDate) {
		this.movieDate = movieDate;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "MovieScreening [theaterScreeningId=" + theaterScreeningId + ", theater=" + theater + ", movieName="
				+ movieName + ", timeSlot=" + Arrays.toString(timeSlot) + ", ticketPrice="
				+ Arrays.toString(ticketPrice) + ", movieDate=" + movieDate + ", city=" + city + "]";
	}

}
