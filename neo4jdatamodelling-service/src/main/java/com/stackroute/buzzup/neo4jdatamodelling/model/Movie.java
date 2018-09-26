package com.stackroute.buzzup.neo4jdatamodelling.model;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;


@NodeEntity
public class Movie {
	
	@Id @GeneratedValue
	private int id;
	private String movieName;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Movie(String movieName) {
		super();
		this.movieName = movieName;
	}
	
	
}