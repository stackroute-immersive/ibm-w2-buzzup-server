package com.stackroute.buzzup.kafka.model;

import java.util.Date;

// import lombok.AllArgsConstructor;
// import lombok.NoArgsConstructor;


public class EventDetails {

	
	private String eventName;	
	private Date startDate;
	private String startTime;
	private Date endDate;
	private String endTime;
	private String city;
	private String location;
	private String poster;
	private String type;
	private String description;
	private int numberOfGuests;
	private boolean isCompleted;
	private String artist;
	private String[] recipientEmail;
	public EventDetails(String eventName, Date startDate, String startTime, Date endDate, String endTime, String city,
			String location, String poster, String type, String description, int numberOfGuests, boolean isCompleted,
			String artist, String[] recipientEmail) {
		super();
		this.eventName = eventName;
		this.startDate = startDate;
		this.startTime = startTime;
		this.endDate = endDate;
		this.endTime = endTime;
		this.city = city;
		this.location = location;
		this.poster = poster;
		this.type = type;
		this.description = description;
		this.numberOfGuests = numberOfGuests;
		this.isCompleted = isCompleted;
		this.artist = artist;
		this.recipientEmail = recipientEmail;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getNumberOfGuests() {
		return numberOfGuests;
	}
	public void setNumberOfGuests(int numberOfGuests) {
		this.numberOfGuests = numberOfGuests;
	}
	public boolean isCompleted() {
		return isCompleted;
	}
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String[] getRecipientEmail() {
		return recipientEmail;
	}
	public void setRecipientEmail(String[] recipientEmail) {
		this.recipientEmail = recipientEmail;
	}
	
	
}
