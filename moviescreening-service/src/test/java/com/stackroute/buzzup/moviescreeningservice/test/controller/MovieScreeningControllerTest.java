package com.stackroute.buzzup.moviescreeningservice.test.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.buzzup.kafka.model.MovieSchedule;
import com.stackroute.buzzup.moviescreeningservice.controller.MovieScreeningController;
import com.stackroute.buzzup.moviescreeningservice.service.MovieScreeningServiceImpl;




@RunWith(SpringRunner.class)
@WebMvcTest
public class MovieScreeningControllerTest {

	@Autowired
	private MockMvc mockMvc;
	private MovieSchedule movieSchedule;

	@MockBean
	private MovieScreeningServiceImpl moviescreeningserviceImpl;

	@InjectMocks
	private MovieScreeningController moviescreeningcontroller;
	

	@Before
	public void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);


		movieSchedule = new MovieSchedule();
		movieSchedule = new MovieSchedule();
		movieSchedule.setActors("srk");
		movieSchedule.setActress("dipika");
		movieSchedule.setDirectors("anurag");
		movieSchedule.setEmailId("utkarsh@gmail.com");
		movieSchedule.setId("123");
		movieSchedule.setMovieName("ddlj");

	
	}

	@Test
	public void saveMovieScreeningTest() throws Exception {
		when(moviescreeningserviceImpl.addMovieSchedule(any())).thenReturn(movieSchedule);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/movie").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(movieSchedule))).andExpect(MockMvcResultMatchers.status().isNotFound())
				.andDo(MockMvcResultHandlers.print());
		assertNotNull("abc");
	}

	@Test
	public void saveMovieScreeningTestFailure() throws Exception {
		when(moviescreeningserviceImpl.addMovieSchedule(any())).thenReturn(null);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/movie").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(movieSchedule))).andExpect(MockMvcResultMatchers.status().isNotFound())
				.andDo(MockMvcResultHandlers.print());
		assertNotNull("abc");
	}      
	
	
	private static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new JsonParseException(e);
		}
	}

}
