package com.stackroute.buzzup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.stackroute.buzzup.config.KafkaConfiguration;
import com.stackroute.buzzup.kafka.model.EventDetails;
import com.stackroute.buzzup.repository.EventRepository;

@Service
public class EventDetailsServiceImpl implements EventDetailsService {

	private EventRepository eventRepository;

	String topic =KafkaConfiguration.getTopic();

	
	public KafkaTemplate<String, EventDetails> kafkaTemplate;

	
	@Autowired
	public EventDetailsServiceImpl(EventRepository eventRepository, KafkaTemplate<String, EventDetails> kafkaTemplate) {
		super();
		this.eventRepository = eventRepository;
		this.kafkaTemplate = kafkaTemplate;
	}

	public EventDetails createEvent(EventDetails eventDetails) {
		kafkaTemplate.send(topic,eventDetails );
		EventDetails savedEvent = eventRepository.save(eventDetails);
		return savedEvent;
	}

	public EventDetails eventData(String eventName) {
		EventDetails eventData = eventRepository.getByEventName(eventName);
		return eventData;
	}

	public List<EventDetails> getDetails() {
		List<EventDetails> eventDetailsList = (List<EventDetails>) eventRepository.findAll();
		return eventDetailsList;
	}

/*	public List<EventDetails> getEvent(String emailId) {
		List<EventDetails> eventList = eventRepository.getByEmailId(emailId);
		return eventList;
	}*/

	public EventDetails getEvent(String emailId) {
		EventDetails eventList = eventRepository.getByEmailId(emailId);
		return eventList;
	}
	
	public boolean deletedEvent(String emailId)
	{
		EventDetails deletedEvent = eventRepository.getByEmailId(emailId);
		eventRepository.delete(deletedEvent);
		return true;
	}
	
	public boolean deleteEvent(String id) {
		EventDetails ed = getUserById(id);
		if (ed != null) {
			eventRepository.delete(ed);
			return true;
		} else
			return false;

	}

	private EventDetails getUserById(String id) {
		EventDetails displayEvent = eventRepository.findById(id).get();

		return displayEvent;
	}

}

/*
 * public EventDetails deleteEventbyName(String eventName) { EventDetails ed =
 * eventRepository.getByEventName(eventName); EventDetails deletedEvent =
 * eventRepository.delete(ed); return deletedEvent;
 * 
 * }
 * 
 * public EventDetails deleteEventByEmail(String emailId) { List<EventDetails>
 * ed = eventRepository.getByEmailId(emailId); EventDetails deletedEvent =
 * eventRepository.deleteById(ed); return deletedEvent;
 * 
 * }
 */
