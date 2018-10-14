package com.stackroute.buzzup.model;

public class EmailDetails {

	private String[] toEmailId;
	private String[] emailCc;
	private String subject;
	private String body;
	private String eventName;
	private String eventDate;
	private String eventLocation;
	public String[] getToEmailId() {
		return toEmailId;
	}
	public void setToEmailId(String[] toEmailId) {
		this.toEmailId = toEmailId;
	}
	public String[] getEmailCc() {
		return emailCc;
	}
	public void setEmailCc(String[] emailCc) {
		this.emailCc = emailCc;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventDate() {
		return eventDate;
	}
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	public String getEventLocation() {
		return eventLocation;
	}
	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}
	public EmailDetails() {
		super();
	}
	public EmailDetails(String[] toEmailId, String[] emailCc, String subject, String body, String eventName,
			String eventDate, String eventLocation) {
		super();
		this.toEmailId = toEmailId;
		this.emailCc = emailCc;
		this.subject = subject;
		this.body = body;
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.eventLocation = eventLocation;
	}

	
	
}
