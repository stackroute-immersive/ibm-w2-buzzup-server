package com.stackroute.buzzup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.buzzup.kafka.model.EventDetails;
import com.stackroute.buzzup.service.EventDetailsService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value ="api/v1")
public class EventDetailsController {

private EventDetailsService eventDetailsService;
	
	
	@Autowired
	public EventDetailsController(EventDetailsService eventDetailsService){
	this.eventDetailsService =eventDetailsService;

	}	
	

	@PostMapping("/event")
	public ResponseEntity<?> createEvent(@RequestBody EventDetails eventDetails) {
		EventDetails savedEvent = eventDetailsService.createEvent(eventDetails);
		return new ResponseEntity<EventDetails>(savedEvent, HttpStatus.OK);
	}

	/*@GetMapping(value = "/event/get")
	public ResponseEntity<?> getEvent(@RequestParam String emailId){
		List<EventDetails>existingEvent =eventDetailsService.getEvent(emailId);
		return new ResponseEntity<List<EventDetails>>(existingEvent, HttpStatus.OK);
	}*/
	
	@GetMapping("/event/getByEmail/{emailId}")
	public ResponseEntity<?> getEvent(@PathVariable String emailId){
		EventDetails existingEvent =eventDetailsService.getEvent(emailId);
		return new ResponseEntity <EventDetails>(existingEvent, HttpStatus.OK);
	}
	
	@GetMapping("/event/{eventName}")
	public ResponseEntity<?> giveEvent(@PathVariable String eventName) {
	 
		EventDetails presentEvent = eventDetailsService.eventData(eventName);
		return new ResponseEntity<EventDetails>(presentEvent, HttpStatus.OK);
	}
	@GetMapping("/events")
	public ResponseEntity<?> AllEvent() {
	 
		List<EventDetails>eventList = eventDetailsService.getDetails();
		return new ResponseEntity<List<EventDetails>>(eventList, HttpStatus.OK);
	}
	
	@DeleteMapping("/event/{emailId}")
	public ResponseEntity<?> deleteEvent(@PathVariable String emailId) {
	{
		boolean eventDel=eventDetailsService.deletedEvent(emailId);
		if(eventDel)
		{
			return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
			
		}
		else
       	 return new ResponseEntity<String>("Event not found", HttpStatus.NOT_FOUND);
			
	}
}

}