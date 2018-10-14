package com.stackroute.buzzup.kafka.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document
public class BookingDetails {
private String emailId;
private String theatreName;
@JsonFormat(pattern="yyyy-MM-dd")
private Date date;
private String time;
private String city;
private String bookingStatus;
private BigDecimal price;
private String showId;
private String movieName;
private List<String> bookTickets;
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
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
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
public String getBookingStatus() {
	return bookingStatus;
}
public void setBookingStatus(String bookingStatus) {
	this.bookingStatus = bookingStatus;
}
public BigDecimal getPrice() {
	return price;
}
public void setPrice(BigDecimal price) {
	this.price = price;
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
public List<String> getBookTickets() {
	return bookTickets;
}
public void setBookTickets(List<String> bookTickets) {
	this.bookTickets = bookTickets;
}
public BookingDetails(String emailId, String theatreName, Date date, String time, String city, String bookingStatus,
		BigDecimal price, String showId, String movieName, List<String> bookTickets) {
	super();
	this.emailId = emailId;
	this.theatreName = theatreName;
	this.date = date;
	this.time = time;
	this.city = city;
	this.bookingStatus = bookingStatus;
	this.price = price;
	this.showId = showId;
	this.movieName = movieName;
	this.bookTickets = bookTickets;
}
public BookingDetails() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "BookingDetails [emailId=" + emailId + ", theatreName=" + theatreName + ", date=" + date + ", time=" + time
			+ ", city=" + city + ", bookingStatus=" + bookingStatus + ", price=" + price + ", showId=" + showId
			+ ", movieName=" + movieName + ", bookTickets=" + bookTickets + "]";
}


}
