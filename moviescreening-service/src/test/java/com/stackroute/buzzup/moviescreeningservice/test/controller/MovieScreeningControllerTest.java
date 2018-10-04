package com.stackroute.buzzup.moviescreeningservice.test.controller;
import com.stackroute.buzzup.moviescreeningservice.model.MovieScreening;
import com.stackroute.buzzup.moviescreeningservice.model.Theater;

import java.util.ArrayList;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.buzzup.moviescreeningservice.controller.MovieScreeningController;


import com.stackroute.buzzup.moviescreeningservice.service.MovieScreeningService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class MovieScreeningControllerTest {

	@Autowired
	private MockMvc mockMvc;
	private MovieScreening moviescreening;

	@MockBean
	private MovieScreeningService moviescreeningservice;

	@InjectMocks
	MovieScreeningController moviescreeningcontroller;
	private List<MovieScreening> movieList;

	@Before
	public void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);


		Theater theater = new Theater();
		theater.setNoOfScreen(5);
		theater.setTheaterAddress("new road");
		theater.setTheaterId("10");
		theater.setTheaterCity("banglore");
		moviescreening = new MovieScreening();
		moviescreening.setMovieName("raees");
		moviescreening.setTheater(theater);
		
		movieList = new ArrayList<>();
	}

	@Test
	public void saveMovieScreeningSuccess() throws Exception {

		when(moviescreeningservice.saveMovieDetails(any())).thenReturn(moviescreening);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/movie").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(moviescreening))).andExpect(MockMvcResultMatchers.status().isCreated())
				.andDo(MockMvcResultHandlers.print());
		assertNotNull("abc");

	}

	@Test
	public void getMovieCity() throws Exception {
		when(moviescreeningservice.getTheaterByCity("banglore")).thenReturn(movieList);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/movie").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(moviescreening))).andExpect(MockMvcResultMatchers.status().isCreated())
				.andDo(MockMvcResultHandlers.print());
		assertNotNull("abc");
	}

	private static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
