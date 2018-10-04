package com.stackroute.buzzup.consumerservicelistener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.stackroute.buzzup.exception.UserAlreadyExistsException;
import com.stackroute.buzzup.model.User;
import com.stackroute.buzzup.service.UserAuthenticationService;

@Service
public class KafkaConsumerListener 
{
	@Autowired
	private UserAuthenticationService userAuthenticationService;
	
	@KafkaListener(topics = "userData")
	public void consumeJson(@Payload User user)
	{
		try 
		{
			userAuthenticationService.saveUser(user);
		} catch (UserAlreadyExistsException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
