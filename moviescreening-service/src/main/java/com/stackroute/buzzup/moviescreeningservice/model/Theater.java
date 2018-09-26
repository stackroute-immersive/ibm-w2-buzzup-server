package com.stackroute.buzzup.moviescreeningservice.model;

import java.util.Arrays;
public class Theater {
	/*
	 * This model class has all the details for theater class which may be required
	 * in movieScreening service
	 */

	private String emailId;
	private String theaterId;
	private String theaterName;
	private String theaterCity;
	private String theaterAddress;
	private String[] theaterCategory;
	private String[] noOfSeats;
	private int noOfScreen;

	public Theater() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Theater(String emailId, String theaterId, String theaterName, String theaterCity, String theaterAddress,
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
		return "Theater [emailId=" + emailId + ", theaterId=" + theaterId + ", theaterName=" + theaterName
				+ ", theaterCity=" + theaterCity + ", theaterAddress=" + theaterAddress + ", theaterCategory="
				+ Arrays.toString(theaterCategory) + ", noOfSeats=" + Arrays.toString(noOfSeats) + ", noOfScreen="
				+ noOfScreen + "]";
	}

}
