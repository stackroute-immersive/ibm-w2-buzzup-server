package com.stackroute.buzzup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.stackroute.buzzup.kafka.model.EventDetails;
import com.stackroute.buzzup.model.EmailDetails;

@Service
public class EmailNotificationService {
	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private SpringTemplateEngine templateEngine;

	/*@Autowired
	public EmailNotificationService(JavaMailSender javaMailSender, SpringTemplateEngine templateEngine) {
		
		this.javaMailSender = javaMailSender;
		this.templateEngine = templateEngine;
	}*/

	EmailDetails emailDetails = new EmailDetails();
	String emailBody;
	String eventName;
	Date eventDate;
	String url = "www.google.co.in";

	@KafkaListener(topics = "rsvpEvent")
	public void sendNotification(EventDetails event) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setTo(event.getRecipientEmail());
		helper.setSubject("RSVP INVITATION!!");
		this.emailBody = event.getDescription();
		this.eventName = event.getEventName();
		this.eventDate = event.getStartDate();

		helper.setText("<html>" + "<head>" + "<body> " + "<h3>Hello there !</h3><br>" + "<p>You are invited for a RSVP Event "
				+ eventName +  emailBody + " happening on " + eventDate + "</p><br>"
				+ "        </body></head></html>", true);
		System.out.println(message.toString());
		javaMailSender.send(message);
	}
}
