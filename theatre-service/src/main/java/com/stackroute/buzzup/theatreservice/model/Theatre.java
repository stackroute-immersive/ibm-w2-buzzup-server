package com.stackroute.buzzup.theatreservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document

public class Theatre {
	@Id
	private String theatreId;
	private String emailId;
	private String location;
	private String city;
	private String name;
	private String licenseNo;
	private String totalnumberOfSeats;
	private String[] screenedmovies;
	private String[] runningmovies;
	private Seats seatLayout;
	private String[] typesOfSeats;
	private String[] numberOfSeats;

	public Theatre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Theatre(String theatreId, String emailId, String location, String city, String name, String licenseNo,
			String totalnumberOfSeats, String[] screenedmovies, String[] runningmovies, Seats seatLayout,
			String[] typesOfSeats, String[] numberOfSeats) {
		super();
		this.theatreId = theatreId;
		this.emailId = emailId;
		this.location = location;
		this.city = city;
		this.name = name;
		this.licenseNo = licenseNo;
		this.totalnumberOfSeats = totalnumberOfSeats;
		this.screenedmovies = screenedmovies;
		this.runningmovies = runningmovies;
		this.seatLayout = seatLayout;
		this.typesOfSeats = typesOfSeats;
		this.numberOfSeats = numberOfSeats;
	}

	public String getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(String theatreId) {
		this.theatreId = theatreId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getTotalnumberOfSeats() {
		return totalnumberOfSeats;
	}

	public void setTotalnumberOfSeats(String totalnumberOfSeats) {
		this.totalnumberOfSeats = totalnumberOfSeats;
	}

	public String[] getScreenedmovies() {
		return screenedmovies;
	}

	public void setScreenedmovies(String[] screenedmovies) {
		this.screenedmovies = screenedmovies;
	}

	public String[] getRunningmovies() {
		return runningmovies;
	}

	public void setRunningmovies(String[] runningmovies) {
		this.runningmovies = runningmovies;
	}

	public Seats getSeatLayout() {
		return seatLayout;
	}

	public void setSeatLayout(Seats seatLayout) {
		this.seatLayout = seatLayout;
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
