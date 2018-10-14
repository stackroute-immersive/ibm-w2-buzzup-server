package com.stackroute.buzzup.recommendationservice.model;

import java.io.File;
import java.util.Arrays;
import java.util.Map;
import org.springframework.data.annotation.Id;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.stackroute.buzzup.kafka.model.Seats;

public class Theatre {
	@Id
	private String theatreId;
	private String theatreName;
	private String theatreLocation;
	private String theatreCity;
	private Seats seatLayout;
	private int showNumbers;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private String showTimings;
	private int[] weekends_Price;
	private int[] weekdays_Price;
	private String[] typesOfSeats;
	private int[] numberOfSeats;
	private String[] screenedmovies;
	private String[] runningmovies;

	public Theatre(String theatreId, String theatreName, String theatreLocation, String theatreCity, Seats seatLayout,
			int showNumbers, String showTimings, int[] weekends_Price, int[] weekdays_Price, int[] numberOfSeats,
			String[] typesOfSeats, String[] screenedmovies, String[] runningmovies) {
		super();
		this.theatreId = theatreId;
		this.theatreName = theatreName;
		this.theatreLocation = theatreLocation;
		this.theatreCity = theatreCity;
		this.seatLayout = seatLayout;
		this.showNumbers = showNumbers;
		this.showTimings = showTimings;
		this.weekends_Price = weekends_Price;
		this.weekdays_Price = weekdays_Price;
		this.typesOfSeats = typesOfSeats;
		this.numberOfSeats = numberOfSeats;
		this.screenedmovies = screenedmovies;
		this.runningmovies = runningmovies;
	}

	public Theatre() {
		
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

	public String getTheatreCity() {
		return theatreCity;
	}

	public void setTheatreCity(String theatreCity) {
		this.theatreCity = theatreCity;
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

	public String getShowTimings() {
		return showTimings;
	}

	public void setShowTimings(String showTimings) {
		this.showTimings = showTimings;
	}

	public int[] getWeekends_Price() {
		return weekends_Price;
	}

	public void setWeekends_Price(int[] weekends_Price) {
		this.weekends_Price = weekends_Price;
	}

	public int[] getWeekdays_Price() {
		return weekdays_Price;
	}

	public void setWeekdays_Price(int[] weekdays_Price) {
		this.weekdays_Price = weekdays_Price;
	}

	public String[] getTypesOfSeats() {
		return typesOfSeats;
	}

	public void setTypesOfSeats(String[] typesOfSeats) {
		this.typesOfSeats = typesOfSeats;
	}

	public int[] getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int[] numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
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

	@Override
	public String toString() {
		return "Theatre [theatreId=" + theatreId + ", theatreName=" + theatreName + ", theatreLocation="
				+ theatreLocation + ", theatreCity=" + theatreCity + ", seatLayout=" + seatLayout + ", showNumbers="
				+ showNumbers + ", showTimings=" + showTimings + ", weekends_Price=" + Arrays.toString(weekends_Price)
				+ ", weekdays_Price=" + Arrays.toString(weekdays_Price) + ", typesOfSeats="
				+ Arrays.toString(typesOfSeats) + ", numberOfSeats=" + Arrays.toString(numberOfSeats)
				+ ", screenedmovies=" + Arrays.toString(screenedmovies) + ", runningmovies="
				+ Arrays.toString(runningmovies) + "]";
	}

}
