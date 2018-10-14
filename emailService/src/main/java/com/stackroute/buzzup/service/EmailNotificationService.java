package com.stackroute.buzzup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.core.io.Resource;
import org.thymeleaf.context.Context;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring5.SpringTemplateEngine;

import java.util.Date;
import java.util.Locale;

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
	private String emailBody;
	private String eventName;
	private Date eventDate;
	byte[] imageBytes;
	String imageContentType;
    private String EMAIL_TEMPLATE_NAME = "./resources/MailTemplate";

	private String eventLocation;
	String imageResourceName;
	Locale locale;

	@KafkaListener(topics = "rsvpEventFinal")
	public void sendNotification(EventDetails event) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setTo(event.getRecipientEmail());
		helper.setSubject("RSVP INVITATION!!");
		this.emailBody = event.getDescription();
		this.eventName = event.getEventName();
		this.eventDate = event.getStartDate();
		this.eventLocation=event.getLocation();
		Context ctx = new Context();
		ctx.setVariable("eventName",eventName);
		ctx.setVariable("eventDate", eventDate);
		ctx.setVariable("eventLocation", eventLocation);
		ctx.setVariable("eventLocation",eventLocation);
		ctx.setVariable("imageResourceName", imageResourceName); // so that we can reference it from HTML

		String htmlContent = this.templateEngine.process(EMAIL_TEMPLATE_NAME, ctx);
        helper.setText(htmlContent, true /* isHtml */);

        // Add the inline image, referenced from the HTML code as "cid:${imageResourceName}"
        InputStreamSource imageSource = new ByteArrayResource(imageBytes);
        helper.addInline(imageResourceName, imageSource, imageContentType);
		javaMailSender.send(message);
	}
	
/*	public void sendNotification(EventDetails event) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		helper.setTo(event.getRecipientEmail());
		helper.setSubject("RSVP INVITATION!!");
		this.emailBody = event.getDescription();
		this.eventName = event.getEventName();
		this.eventDate = event.getStartDate();
		this.eventLocation=event.getLocation();
		
		javaMailSender.send(message);
	}*/
	
/*	public void sendNotification(EventDetails event) throws MessagingException {
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
	}*/
}
