package com.stackroute.buzzup.kafka.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document
public class TicketDetails {

	@Id
	private String bookingId;
	private String emailId;
	private String theatreName;
	private String showId;
	private String movieName;
	private List<String> bookedSeats;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private String time;
	private String city;
	private String price;
	private String bookingStatus;
	
	
	public TicketDetails(String bookingId, String emailId, String theatreName, String showId, String movieName,
			List<String> bookedSeats, String time, String city, String price, String bookingStatus) {
		super();
		this.bookingId = bookingId;
		this.emailId = emailId;
		this.theatreName = theatreName;
		this.showId = showId;
		this.movieName = movieName;
		this.bookedSeats = bookedSeats;
		this.time = time;
		this.city = city;
		this.price = price;
		this.bookingStatus = bookingStatus;
	}


	public String getBookingId() {
		return bookingId;
	}


	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getTheatreName() {
		return theatreName;
	}


	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}


	public String getShowId() {
		return showId;
	}


	public void setShowId(String showId) {
		this.showId = showId;
	}


	public String getMovieName() {
		return movieName;
	}


	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}


	public List<String> getBookedSeats() {
		return bookedSeats;
	}


	public void setBookedSeats(List<String> bookedSeats) {
		this.bookedSeats = bookedSeats;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	public String getBookingStatus() {
		return bookingStatus;
	}


	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}


	public TicketDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
