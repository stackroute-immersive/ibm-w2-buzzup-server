package com.stackroute.buzzup.recommendationservice.model;

import java.util.List;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class City {
	@Id
	private String name;
	@Relationship(type = "releasedIn", direction = Relationship.INCOMING)
	private List<Movie> movies;
	@Relationship(type = "livesIn", direction = Relationship.INCOMING)
	private List<User> users;

	public City() {
		super();
	}

	
	public City(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}


	@Override
	public String toString() {
		return "City [name=" + name + ", movies=" + movies + ", users=" + users + "]";
	}

}
