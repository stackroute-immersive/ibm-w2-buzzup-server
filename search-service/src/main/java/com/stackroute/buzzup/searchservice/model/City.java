package com.stackroute.buzzup.searchservice.model;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class City 
{

	@Id
	public String id;
	private String cityName;
	private List<Movie> movieList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public List<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}

	// All Arguments constructor
	public City(String id, String cityName, List<Movie> movieList) {
		super();
		this.id = id;
		this.cityName = cityName;
		this.movieList = movieList;
	}

	public City(String cityName, List<Movie> movieList) {
		super();

		this.cityName = cityName;
		this.movieList = movieList;
	}

	public City() {
		super();
	}
}
