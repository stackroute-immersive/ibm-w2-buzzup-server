//Authentication Service

package com.stackroute.buzzup.kafka.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;




@Entity
public class User {
	@Id
	@Column(name="emailId")
	private String emailId;
	@Column(name="password")
	private String password;
	@Column(name="userName")
	private String userName;
	@Column(name="userRole")
	private String userRole = "consumer";
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String emailId, String password, String userName, String userRole) {
		super();
		this.emailId = emailId;
		this.password = password;
		this.userName= userName;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	@Override
	public String toString() {
		return "User [emailId=" + emailId + ", password=" + password + ", userName=" + userName + ", userRole=" + userRole + "]";
	}

}