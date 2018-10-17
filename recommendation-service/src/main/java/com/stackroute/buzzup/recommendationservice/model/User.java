package com.stackroute.buzzup.recommendationservice.model;

import java.util.List;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class User {

	@Id
	
	
	private String emailId;
	private Long id;
	private String name;
	private String dateOfBirth;
	@Relationship(type = "livesIn", direction = Relationship.OUTGOING)
	private City city;
	@Relationship(type = "follows", direction = Relationship.OUTGOING)
	private List<Genre> genres;
	@Relationship(type = "preferredLanguage", direction = Relationship.OUTGOING)
	private List<Language> languages;

	public User() {
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String userName) {
		this.name = userName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<Genre> getGenres() {
		return genres;
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	public User(String name, String emailId, String dateOfBirth, City city, List<Genre> genres,
			List<Language> languages) {
		super();
		this.name = name;
		this.emailId = emailId;
		this.dateOfBirth = dateOfBirth;
		this.city = city;
		this.genres = genres;
		this.languages = languages;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", emailId=" + emailId + ", dateOfBirth=" + dateOfBirth + ", city=" + city
				+ ", genres=" + genres + ", languages=" + languages + "]";
	}

}
