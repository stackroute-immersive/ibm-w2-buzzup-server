package com.stackroute.buzzup.neo4jdatamodelling.model;



import java.util.List;


/*This class has all the three  fields included in modelling the graph
 * Along with getter and setter methods*/

import org.neo4j.ogm.annotation.GeneratedValue;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class User {

	@Id @GeneratedValue
	private int id;
	private String name;
	private int age;
	private String gender;

	@Relationship(type="WATCHES",direction=Relationship.OUTGOING)
	private List<Movie> movies;
	@Relationship(type="PREFERS",direction=Relationship.OUTGOING)
	private List<Language> language;
	@Relationship(type="FOLLOWS",direction=Relationship.OUTGOING)
	private List<Genre> gen;
	

	
	public List<Language> getLanguage() {
		return language;
	}

	public void setLanguage(List<Language> language) {
		this.language = language;
	}

	public List<Genre> getGen() {
		return gen;
	}

	public void setGen(List<Genre> gen) {
		this.gen = gen;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		
		this.movies = movies;
	}

	public User(int id, String name, int age, String gender, List<Movie> movies, List<Language> language,
			List<Genre> gen) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.movies = movies;
		this.language = language;
		this.gen = gen;
	}

	

	}

	
	