package com.stackroute.buzzup.ticketengine.service;

import java.text.ParseException;
import java.util.List;

import com.stackroute.buzzup.kafka.domain.MovieSchedule;
import com.stackroute.buzzup.kafka.domain.TicketDetails;
import com.stackroute.buzzup.kafka.domain.TriggerMessage;
import com.stackroute.buzzup.ticketengine.domain.Show;

public interface ShowService {

	public Show getById(String showId);

	public Iterable<Show> getAll();

	public Show updateBlocked(Show show);

	public Show updateBooked(Show show);

	public void delete(String showId);

	public void getDetails(MovieSchedule movieSchedule) throws ParseException;

	public void getBookedSeats(TicketDetails ticketDetails);

	public void getSchedulerTrigger(TriggerMessage object) throws ParseException;

	public Show delblocked(List<Integer> ipList, String showID);

}
