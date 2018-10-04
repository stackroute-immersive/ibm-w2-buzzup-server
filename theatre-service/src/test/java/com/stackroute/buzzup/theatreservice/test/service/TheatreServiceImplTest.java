package com.stackroute.buzzup.theatreservice.test.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.stackroute.buzzup.theatreservice.exception.TheatreAlreadyExistsException;
import com.stackroute.buzzup.theatreservice.exception.TheatreNotFoundException;
import com.stackroute.buzzup.theatreservice.model.Theatre;
import com.stackroute.buzzup.theatreservice.repository.TheatreRepository;
import com.stackroute.buzzup.theatreservice.service.TheatreServiceImpl;

import static org.mockito.Mockito.any;

public class TheatreServiceImplTest {

	@Mock
	private TheatreRepository theatreRepository;
	private Theatre theatre;

	@InjectMocks
	private TheatreServiceImpl theatreService;

	private Optional<Theatre> options;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

		theatre = new Theatre();
		String category[] = {};
		String noOfSeats[] = {};
		theatre.setEmailId("yoga30@gmail.com");
		theatre.setTheaterId("John123");
		theatre.setTheaterCity("bangalore");
		theatre.setTheaterName("john");
		theatre.setTheaterAddress("2/1 john street");
		theatre.setTheaterCategory(category);
		theatre.setNoOfSeats(noOfSeats);
		theatre.setNoOfScreen(4);

		options = Optional.of(theatre);

	}

	@Test
	public void registerTheatreSuccess() throws TheatreAlreadyExistsException {
		when(theatreRepository.insert((Theatre) any())).thenReturn(theatre);
		Theatre theatreSaved = theatreService.registerTheatre(theatre);
		assertEquals(theatre, theatreSaved);

	}

	@Test(expected = TheatreAlreadyExistsException.class)
	public void registerTheatreFailure() throws TheatreAlreadyExistsException {
		when(theatreRepository.insert((Theatre) any())).thenReturn(null);
		Theatre theatreSaved = theatreService.registerTheatre(theatre);
		assertEquals(theatre, theatreSaved);

	}

	@Test
	public void updateTheatre() throws TheatreNotFoundException {
		when(theatreRepository.findById(theatre.getTheaterId())).thenReturn(options);
		theatre.setTheaterName("gold");
		Theatre fetchtheatre = theatreService.updateTheatre(theatre.getTheaterId(), theatre);
		assertEquals(theatre, fetchtheatre);

	}

	@Test
	public void deleteTheatreSuccess() throws TheatreNotFoundException {
		when(theatreRepository.findById(theatre.getTheaterId())).thenReturn(options);
		boolean flag = theatreService.deleteTheatre(theatre.getTheaterId());
		assertEquals(true, flag);

	}

	@Test
	public void getTheatreByemailId() throws TheatreNotFoundException {

		when(theatreRepository.findById(theatre.getEmailId())).thenReturn(options);

		Theatre fetchedTheatre = theatreService.getTheatreByemailId(theatre.getEmailId());

		assertEquals(theatre, fetchedTheatre);

	}

}
