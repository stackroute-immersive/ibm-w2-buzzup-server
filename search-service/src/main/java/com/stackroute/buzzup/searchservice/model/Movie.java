package com.stackroute.buzzup.searchservice.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Movie {
	@Id
	private String id;
	private String movieName;
	private String moviePoster;
	private String synopsis;
	private String movieReleasedate;
	private String movieDuration;
	private String languages;
	private String movieGenre;
	private String format;
	private String actors;
	private String actress;
	private String director;
	private List<Theatre> theatres;
	
	public Movie() {
		super();
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

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public String getMovieReleasedate() {
		return movieReleasedate;
	}

	public void setMovieReleasedate(String movieReleasedate) {
		this.movieReleasedate = movieReleasedate;
	}

	public String getMovieDuration() {
		return movieDuration;
	}

	public void setMovieDuration(String movieDuration) {
		this.movieDuration = movieDuration;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public String getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(String movieGenre) {
		this.movieGenre = movieGenre;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
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

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public List<Theatre> getTheatres() {
		return theatres;
	}

	public void setTheatres(List<Theatre> theatres) {
		this.theatres = theatres;
	}

	public Movie(String id, String movieName, String moviePoster, String synopsis, String movieReleasedate,
			String movieDuration, String languages, String movieGenre, String format, String actors, String actress,
			String director, List<Theatre> theatres) {
		super();
		this.id = id;
		this.movieName = movieName;
		this.moviePoster = moviePoster;
		this.synopsis = synopsis;
		this.movieReleasedate = movieReleasedate;
		this.movieDuration = movieDuration;
		this.languages = languages;
		this.movieGenre = movieGenre;
		this.format = format;
		this.actors = actors;
		this.actress = actress;
		this.director = director;
		this.theatres = theatres;
	}
	


}
