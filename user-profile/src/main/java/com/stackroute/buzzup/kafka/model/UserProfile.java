package com.stackroute.buzzup.kafka.model;

import java.util.Arrays;

import javax.persistence.Transient;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class UserProfile {

	@Id
	private String emailId;
	@Transient
	private String password;
	private String userMobile;
	private String userName;
	private String userGender;
	private String age;
	private String city;
	private String[] prefLang;
	private String[] movieGenre;
	private String[] eventCategory;
	private String userRole = "Consumer";
	@Override
	public String toString() {
		return "UserProfile [emailId=" + emailId + ", password=" + password + ", userMobile=" + userMobile
				+ ", userName=" + userName + ", userGender=" + userGender + ", age=" + age + ", city=" + city
				+ ", prefLang=" + Arrays.toString(prefLang) + ", movieGenre=" + Arrays.toString(movieGenre)
				+ ", eventCategory=" + Arrays.toString(eventCategory) + ", userRole=" + userRole + "]";
	}
	public UserProfile(String emailId, String password, String userMobile, String userName, String userGender,
			String age, String city, String[] prefLang, String[] movieGenre, String[] eventCategory, String userRole) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.userMobile = userMobile;
		this.userName = userName;
		this.userGender = userGender;
		this.age = age;
		this.city = city;
		this.prefLang = prefLang;
		this.movieGenre = movieGenre;
		this.eventCategory = eventCategory;
		this.userRole = userRole;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserMobile() {
		return userMobile;
	}
	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String[] getPrefLang() {
		return prefLang;
	}
	public void setPrefLang(String[] prefLang) {
		this.prefLang = prefLang;
	}
	public String[] getMovieGenre() {
		return movieGenre;
	}
	public void setMovieGenre(String[] movieGenre) {
		this.movieGenre = movieGenre;
	}
	public String[] getEventCategory() {
		return eventCategory;
	}
	public void setEventCategory(String[] eventCategory) {
		this.eventCategory = eventCategory;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	
	
	
	
}
