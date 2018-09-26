package com.stackroute.distributorservice.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Distributor {

	@Id
	private String emailId;
	@Transient
	private String password;
	private String distributorName;
	private String distributorLocation;
	private List<Movies> movies;

	public Distributor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Distributor(String emailId, String password, String distributorName, String distributorLocation,
			List<Movies> movies) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.distributorName = distributorName;
		this.distributorLocation = distributorLocation;
		this.movies = movies;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDistributorName() {
		return distributorName;
	}

	public void setDistributorName(String distributorName) {
		this.distributorName = distributorName;
	}

	public String getDistributorLocation() {
		return distributorLocation;
	}

	public void setDistributorLocation(String distributorLocation) {
		this.distributorLocation = distributorLocation;
	}

	public List<Movies> getMovies() {
		return movies;
	}

	public void setMovies(List<Movies> movies) {
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "Distributor [emailId=" + emailId + ", password=" + password + ", distributorName=" + distributorName
				+ ", distributorLocation=" + distributorLocation + ", movies=" + movies + "]";
	}

}