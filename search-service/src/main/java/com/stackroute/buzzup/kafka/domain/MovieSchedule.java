package com.stackroute.buzzup.kafka.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.stackroute.buzzup.searchservice.model.Seats;

public class MovieSchedule {
	private String theatreId;
	private String theatreName;
	private String emailId;
	private String theatreLocation;
	private String theatreCity;
	private String theatreLicenseNo;
	private String totalnumberOfSeats;
	private Seats seatLayout;
	private String[] typesOfSeats;
	private String[] numberOfSeats;
	public String id;
	private String movieName;
	private String moviePoster;
	private String actors;
	private String actress;
	private String directors;
	private String movieGenres;
	private String synopsis;
	private String format;
	private String languages;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private String movieDuration;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyy")
	private String movieReleaseDate;
	private int showNumbers;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private String showTimings;
	private String[] weekendsPrice;
	private String[] weekdaysPrice;

	public MovieSchedule() {
		super();
	}

	public MovieSchedule(String theatreId, String theatreName, String emailId, String theatreLocation,
			String theatreCity, String theatreLicenseNo, String totalnumberOfSeats, Seats seatLayout,
			String[] typesOfSeats, String[] numberOfSeats, String id, String movieName, String moviePoster,
			String actors, String actress, String directors, String movieGenres, String synopsis, String format,
			String languages, String movieDuration, String movieReleaseDate, int showNumbers, String showTimings,
			String[] weekendsPrice, String[] weekdaysPrice) {
		super();
		this.theatreId = theatreId;
		this.theatreName = theatreName;
		this.emailId = emailId;
		this.theatreLocation = theatreLocation;
		this.theatreCity = theatreCity;
		this.theatreLicenseNo = theatreLicenseNo;
		this.totalnumberOfSeats = totalnumberOfSeats;
		this.seatLayout = seatLayout;
		this.typesOfSeats = typesOfSeats;
		this.numberOfSeats = numberOfSeats;
		this.id = id;
		this.movieName = movieName;
		this.moviePoster = moviePoster;
		this.actors = actors;
		this.actress = actress;
		this.directors = directors;
		this.movieGenres = movieGenres;
		this.synopsis = synopsis;
		this.format = format;
		this.languages = languages;
		this.movieDuration = movieDuration;
		this.movieReleaseDate = movieReleaseDate;
		this.showNumbers = showNumbers;
		this.showTimings = showTimings;
		this.weekendsPrice = weekendsPrice;
		this.weekdaysPrice = weekdaysPrice;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
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

	public String getTheatreLicenseNo() {
		return theatreLicenseNo;
	}

	public void setTheatreLicenseNo(String theatreLicenseNo) {
		this.theatreLicenseNo = theatreLicenseNo;
	}

	public String getTotalnumberOfSeats() {
		return totalnumberOfSeats;
	}

	public void setTotalnumberOfSeats(String totalnumberOfSeats) {
		this.totalnumberOfSeats = totalnumberOfSeats;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMoviePoster() {
		return moviePoster;
	}

	public void setMoviePoster(String moviePoster) {
		this.moviePoster = moviePoster;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getActress() {
		return actress;
	}

	public void setActress(String actress) {
		this.actress = actress;
	}

	public String getDirectors() {
		return directors;
	}

	public void setDirectors(String directors) {
		this.directors = directors;
	}

	public String getMovieGenres() {
		return movieGenres;
	}

	public void setMovieGenres(String movieGenres) {
		this.movieGenres = movieGenres;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public String getMovieDuration() {
		return movieDuration;
	}

	public void setMovieDuration(String movieDuration) {
		this.movieDuration = movieDuration;
	}

	public String getMovieReleaseDate() {
		return movieReleaseDate;
	}

	public void setMovieReleaseDate(String movieReleaseDate) {
		this.movieReleaseDate = movieReleaseDate;
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

}
