package com.stackroute.distributorservice.model;

public class Movies {

	private String movieId;
	private String movieName;
	private String movieDescription;
	private String movieGenre;
	private String movieReleaseDate;
	private String movieLocation;

	public Movies(String movieId, String movieName, String movieDescription, String movieGenre, String movieReleaseDate,
			String movieLocation) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.movieDescription = movieDescription;
		this.movieGenre = movieGenre;
		this.movieReleaseDate = movieReleaseDate;
		this.movieLocation = movieLocation;
	}

	public Movies() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDescription() {
		return movieDescription;
	}

	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	public String getMovieReleaseDate() {
		return movieReleaseDate;
	}

	public void setMovieReleaseDate(String movieReleaseDate) {
		this.movieReleaseDate = movieReleaseDate;
	}

	public String getMovieLocation() {
		return movieLocation;
	}

	public void setMovieLocation(String movieLocation) {
		this.movieLocation = movieLocation;
	}

	@Override
	public String toString() {
		return "Movies [movieId=" + movieId + ", movieName=" + movieName + ", movieDescription=" + movieDescription
				+ ", movieGenre=" + movieGenre + ", movieReleaseDate=" + movieReleaseDate + ", movieLocation="
				+ movieLocation + "]";
	}

}
