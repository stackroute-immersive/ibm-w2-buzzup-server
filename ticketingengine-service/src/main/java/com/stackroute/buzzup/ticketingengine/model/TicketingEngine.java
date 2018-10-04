package com.stackroute.buzzup.ticketingengine.model;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.data.annotation.Id;

//import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;


@Document
public class TicketingEngine {
	
	@Id
	private int id;
	private String name;
    @JsonFormat(pattern="yyyy-MM-dd")
	private Date date;
	private String localDate;
	private String time;
	private String city;
	private String location;
	private String backGroundPoster;
	private String cardPoster;
	private String type;
	private int capacity;
	private int remainingSeats;
	private String description;
	private BigDecimal price;
	private String performers;
	private String termsAndConditions;
	private String notes;
	private String username;
	public TicketingEngine() {
		super();
	}
	public TicketingEngine(int id, String name, Date date, String localDate, String time, String city,
			String location, String backGroundPoster, String cardPoster, String type, int capacity, int remainingSeats,
			String description, BigDecimal price, String performers, String termsAndConditions, String notes,
			String username) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
		this.localDate = localDate;
		this.time = time;
		this.city = city;
		this.location = location;
		this.backGroundPoster = backGroundPoster;
		this.cardPoster = cardPoster;
		this.type = type;
		this.capacity = capacity;
		this.remainingSeats = remainingSeats;
		this.description = description;
		this.price = price;
		this.performers = performers;
		this.termsAndConditions = termsAndConditions;
		this.notes = notes;
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(java.util.Date date2) {
		this.date = date2;
	}
	public String getLocalDate() {
		return localDate;
	}
	public void setLocalDate(String localDate) {
		this.localDate = localDate;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getBackGroundPoster() {
		return backGroundPoster;
	}
	public void setBackGroundPoster(String backGroundPoster) {
		this.backGroundPoster = backGroundPoster;
	}
	public String getCardPoster() {
		return cardPoster;
	}
	public void setCardPoster(String cardPoster) {
		this.cardPoster = cardPoster;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getRemainingSeats() {
		return remainingSeats;
	}
	public void setRemainingSeats(int remainingSeats) {
		this.remainingSeats = remainingSeats;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getPerformers() {
		return performers;
	}
	public void setPerformers(String performers) {
		this.performers = performers;
	}
	public String getTermsAndConditions() {
		return termsAndConditions;
	}
	public void setTermsAndConditions(String termsAndConditions) {
		this.termsAndConditions = termsAndConditions;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
