package com.stackroute.buzzup.searchservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document
public class Theatre {
	@Id
	private String theatreId;
	private String theatreName;
	private String theatreLocation;
	private Seats seatLayout;
	private int showNumbers;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private String[] showTimings;
	private String[] weekendsPrice;
	private String[] weekdaysPrice;
	private String[] typesOfSeats;
	private String[] numberOfSeats;

	
	
	
	public Theatre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Theatre(String theatreId, String theatreName, String theatreLocation, Seats seatLayout, int showNumbers,
			String[] showTimings, String[] weekendsPrice, String[] weekdaysPrice, String[] typesOfSeats,
			String[] numberOfSeats) {
		super();
		this.theatreId = theatreId;
		this.theatreName = theatreName;
		this.theatreLocation = theatreLocation;
		this.seatLayout = seatLayout;
		this.showNumbers = showNumbers;
		this.showTimings = showTimings;
		this.weekendsPrice = weekendsPrice;
		this.weekdaysPrice = weekdaysPrice;
		this.typesOfSeats = typesOfSeats;
		this.numberOfSeats = numberOfSeats;
	}

	public String getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(String theatreId) {
		this.theatreId = theatreId;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public String getTheatreLocation() {
		return theatreLocation;
	}

	public void setTheatreLocation(String theatreLocation) {
		this.theatreLocation = theatreLocation;
	}

	public Seats getSeatLayout() {
		return seatLayout;
	}

	public void setSeatLayout(Seats seatLayout) {
		this.seatLayout = seatLayout;
	}

	public int getShowNumbers() {
		return showNumbers;
	}

	public void setShowNumbers(int showNumbers) {
		this.showNumbers = showNumbers;
	}

	public String[] getShowTimings() {
		return showTimings;
	}

	public void setShowTimings(String[] showTimings) {
		this.showTimings = showTimings;
	}

	public String[] getWeekendsPrice() {
		return weekendsPrice;
	}

	public void setWeekendsPrice(String[] weekendsPrice) {
		this.weekendsPrice = weekendsPrice;
	}

	public String[] getWeekdaysPrice() {
		return weekdaysPrice;
	}

	public void setWeekdaysPrice(String[] weekdaysPrice) {
		this.weekdaysPrice = weekdaysPrice;
	}

	public String[] getTypesOfSeats() {
		return typesOfSeats;
	}

	public void setTypesOfSeats(String[] typesOfSeats) {
		this.typesOfSeats = typesOfSeats;
	}

	public String[] getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(String[] numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

}
