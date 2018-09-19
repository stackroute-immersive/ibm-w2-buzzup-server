package com.stackroute.buzzup.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserProfile {

	@Id
    String userId;
    String userEmail;
    String userPassword;
    String userMobile;
    String userName;
    String userGender;
    String age;
    String city;
    String fburl;
    String twitterurl;
    String[] prefLang;
    String[] movieGenre; 
    String[] eventCategory;
    
    public UserProfile() {}

	public UserProfile(String userId, String userEmail, String userPassword, String userMobile, String userName,
			String userGender, String age, String city, String fburl, String twitterurl, String[] prefLang,
			String[] movieGenre, String[] eventCategory) {
		super();
		this.userId = userId;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.userMobile = userMobile;
		this.userName = userName;
		this.userGender = userGender;
		this.age = age;
		this.city = city;
		this.fburl = fburl;
		this.twitterurl = twitterurl;
		this.prefLang = prefLang;
		this.movieGenre = movieGenre;
		this.eventCategory = eventCategory;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
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

	public String getFburl() {
		return fburl;
	}

	public void setFburl(String fburl) {
		this.fburl = fburl;
	}

	public String getTwitterurl() {
		return twitterurl;
	}

	public void setTwitterurl(String twitterurl) {
		this.twitterurl = twitterurl;
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
    
	
    
    
}