package com.stackroute.buzzup.ticketengine.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.buzzup.ticketengine.domain.Show;
import com.stackroute.buzzup.ticketengine.service.ShowService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/ticket")
public class TicketController {

	private ShowService showService;
	private final SimpMessagingTemplate template;
	Runnable runnable;
	Thread thread;

	@Autowired
	public TicketController(ShowService showService, SimpMessagingTemplate template) {

		this.showService = showService;
		this.template = template;

	}

	@MessageMapping("/message")
	public void seat(String message) throws IOException {
		System.out.println(message);
		ObjectMapper objectMapper = new ObjectMapper();
		Show json = objectMapper.readValue(message, Show.class);
		showService.updateBlocked(json);
		showService.getById(json.getShowId());
		this.template.convertAndSend("/movie", showService.getById(json.getShowId()));
		// ScheduledExecutorService executor =
		// Executors.newSingleThreadScheduledExecutor();
		// Runnable task = showService.delblocked(json.getBlockedSeats(),
		// json.getShowId());
		// executor.schedule(task, 50, TimeUnit.SECONDS);
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				showService.delblocked(json.getBlockedSeats(), json.getShowId());
				System.out.println("Hello !!!");
			}
		};
		Timer timer = new Timer();
		long delay = 5 * 60 * 1000;
		long intevalPeriod = 100000000;
		// schedules the task to be run in an interval
		timer.scheduleAtFixedRate(task, delay, intevalPeriod);
	}

	@PutMapping("/update/{showId}")
	public ResponseEntity<?> test(@PathVariable String showId, @RequestBody ArrayList<Integer> blockedSeats) {

		System.out.println("hi...!");
		System.out.println(showId);
		System.out.println(blockedSeats.get(0));
		// Show local = showService.getById(showId);
		for (int i = 0; i < blockedSeats.size(); i++) {
			System.out.println(blockedSeats.get(i));
		}
		Show updatedShow = showService.delblocked(blockedSeats, showId);
		return new ResponseEntity<Show>(updatedShow, HttpStatus.OK);

	}

	// get all
	@GetMapping("/shows")
	public ResponseEntity<?> getAllShows() {
		return new ResponseEntity<Iterable<Show>>(showService.getAll(), HttpStatus.OK);
	}

	@GetMapping("/layout/{showid}")
	public ResponseEntity<?> getLayout(@PathVariable String showid) {
		Show localshow = showService.getById(showid);
		return new ResponseEntity<Show>(localshow, HttpStatus.OK);
	}

	// get id
	@GetMapping("/show/{id}")
	public ResponseEntity<?> getById(@PathVariable String id) {
		return new ResponseEntity<Show>(showService.getById(id), HttpStatus.OK);
	}

	// Deleting
	@DeleteMapping("/show/{showId}")
	public String delShow(@PathVariable String showId) {
		showService.delete(showId);
		return "show deleted";
	}

}
