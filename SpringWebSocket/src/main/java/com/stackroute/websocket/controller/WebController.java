package com.stackroute.websocket.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.stackroute.websocket.model.Seats;
import com.stackroute.websocket.model.User;
 
@Controller
public class WebController {

	/*@MessageMapping("/hello/demo")
	@SendTo("/topic/demo")
	public User greeting(User user) throws Exception {
		return user;
	}*/
	@MessageMapping("/hello")
	@SendTo("/topic/hi")
	public Seats greeting(Seats seats) throws Exception {
		return seats;
	}
}
