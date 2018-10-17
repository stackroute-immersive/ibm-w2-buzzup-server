package com.stackroute.buzzup.ticketengine.domain;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("Shows")
public class Show implements Runnable {

	@Id
	private String showId;
	private String city;
	private String movieName;
	private String theatreName;
	private int bookingDate;
	private Date releseDate;
	private Date showDate;
	private String slot;
	private Boolean status;
	private List<Integer> bookedSeats;
	private List<Integer> blockedSeats;
	private int totalRow;
	private int totalCol;
	private List<Integer> rowValues;
	private List<Integer> colValues;

	public String getShowId() {
		return showId;
	}

	public void setShowId(String showId) {
		this.showId = showId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public int getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(int bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Date getReleseDate() {
		return releseDate;
	}

	public void setReleseDate(Date releseDate) {
		this.releseDate = releseDate;
	}

	public Date getShowDate() {
		return showDate;
	}

	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public List<Integer> getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(List<Integer> bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	public List<Integer> getBlockedSeats() {
		return blockedSeats;
	}

	public void setBlockedSeats(List<Integer> blockedSeats) {
		this.blockedSeats = blockedSeats;
	}

	public int getTotalRow() {
		return totalRow;
	}

	public void setTotalRow(int totalRow) {
		this.totalRow = totalRow;
	}

	public int getTotalCol() {
		return totalCol;
	}

	public void setTotalCol(int totalCol) {
		this.totalCol = totalCol;
	}

	public List<Integer> getRowValues() {
		return rowValues;
	}

	public void setRowValues(List<Integer> rowValues) {
		this.rowValues = rowValues;
	}

	public List<Integer> getColValues() {
		return colValues;
	}

	public void setColValues(List<Integer> colValues) {
		this.colValues = colValues;
	}

	public Show(String showId, String city, String movieName, String theatreName, int bookingDate, Date releseDate,
			Date showDate, String slot, Boolean status, List<Integer> bookedSeats, List<Integer> blockedSeats,
			int totalRow, int totalCol, List<Integer> rowValues, List<Integer> colValues) {
		super();
		this.showId = showId;
		this.city = city;
		this.movieName = movieName;
		this.theatreName = theatreName;
		this.bookingDate = bookingDate;
		this.releseDate = releseDate;
		this.showDate = showDate;
		this.slot = slot;
		this.status = status;
		this.bookedSeats = bookedSeats;
		this.blockedSeats = blockedSeats;
		this.totalRow = totalRow;
		this.totalCol = totalCol;
		this.rowValues = rowValues;
		this.colValues = colValues;
	}

	public Show() {
		super();
	}

	@Override
	public String toString() {
		return "Show [showId=" + showId + ", city=" + city + ", movieName=" + movieName + ", theatreName=" + theatreName
				+ ", bookingDate=" + bookingDate + ", releseDate=" + releseDate + ", showDate=" + showDate + ", slot="
				+ slot + ", status=" + status + ", bookedSeats=" + bookedSeats + ", blockedSeats=" + blockedSeats
				+ ", totalRow=" + totalRow + ", totalCol=" + totalCol + ", rowValues=" + rowValues + ", colValues="
				+ colValues + "]";
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
