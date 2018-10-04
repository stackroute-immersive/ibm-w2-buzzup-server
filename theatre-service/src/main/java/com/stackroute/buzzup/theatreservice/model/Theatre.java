package com.stackroute.buzzup.theatreservice.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
import org.springframework.data.annotation.Id;

//import javax.persistence.*;
/*
 * Please note that this class is annotated with @Document annotation
 * @Document identifies a domain object to be persisted to MongoDB.
 *  */
@Document
public class Theatre {
	/*
	 * This class should have seven fields
	 * (Id,Name,city,address,category,noOfSeats,NoOfScreens). Out of these SEVEN
	 * fields, the field Id should be annotated with @Id. This class should also
	 * contain the getters and setters for the fields along with the no-arg ,
	 * parameterized constructor and toString method.
	 */
	@Id
	private String emailId;
	private String theaterId;
	private String theaterName;
	private String theaterCity;
	private String theaterAddress;
	private String[] theaterCategory;
	private String[] noOfSeats;
	private int noOfScreen;

	public Theatre() {
	   
		super();
	
	}

	public Theatre(String emailId, String theaterId, String theaterName, String theaterCity, String theaterAddress,
			String[] theaterCategory, String[] noOfSeats, int noOfScreen) {
		super();
		this.emailId = emailId;
		this.theaterId = theaterId;
		this.theaterName = theaterName;
		this.theaterCity = theaterCity;
		this.theaterAddress = theaterAddress;
		this.theaterCategory = theaterCategory;
		this.noOfSeats = noOfSeats;
		this.noOfScreen = noOfScreen;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(String theaterId) {
		this.theaterId = theaterId;
	}

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public String getTheaterCity() {
		return theaterCity;
	}

	public void setTheaterCity(String theaterCity) {
		this.theaterCity = theaterCity;
	}

	public String getTheaterAddress() {
		return theaterAddress;
	}

	public void setTheaterAddress(String theaterAddress) {
		this.theaterAddress = theaterAddress;
	}

	public String[] getTheaterCategory() {
		return theaterCategory;
	}

	public void setTheaterCategory(String[] theaterCategory) {
		this.theaterCategory = theaterCategory;
	}

	public String[] getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(String[] noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public int getNoOfScreen() {
		return noOfScreen;
	}

	public void setNoOfScreen(int noOfScreen) {
		this.noOfScreen = noOfScreen;
	}

	@Override
	public String toString() {
		return "Theatre [emailId=" + emailId + ", theaterId=" + theaterId + ", theaterName=" + theaterName
				+ ", theaterCity=" + theaterCity + ", theaterAddress=" + theaterAddress + ", theaterCategory="
				+ Arrays.toString(theaterCategory) + ", noOfSeats=" + Arrays.toString(noOfSeats) + ", noOfScreen="
				+ noOfScreen + "]";
	}

}