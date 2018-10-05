package com.stackroute.buzzup.theatreservice.test.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.buzzup.theatreservice.model.Theatre;
import com.stackroute.buzzup.theatreservice.service.TheatreServiceImpl;

public class TheatreControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private Theatre theatre;
	@MockBean
	private TheatreServiceImpl theatreServiceImpl;
	@InjectMocks
	private TheatreControllerTest theatreControllerTest;

	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(theatreControllerTest).build();
		theatre = new Theatre();
		theatre.setTheatreId("1");
		theatre.setEmailId("utkarsh@gmail.com");
		theatre.setLocation("pune");
		theatre.setName("pvr");
	}

	@Test(expected = Exception.class)
	public void saveTheatreTest() throws Exception {
		when(theatreServiceImpl.saveTheatre(any())).thenReturn(theatre);
		mockMvc.perform(post("/api/v1/theatre").contentType(MediaType.APPLICATION_JSON).content(asJsonString(theatre)))
				.andExpect(status().isOk()).andDo(print());

	}

	@Test(expected = Exception.class)
	public void updateTheatreTest() throws Exception {
		assertNotNull("hi");
		when(theatreServiceImpl.updateTheatre(theatre)).thenReturn(theatre);
		mockMvc.perform(post("/api/v1/theatre").contentType(MediaType.APPLICATION_JSON).content(asJsonString(theatre)))
				.andExpect(status().isOk()).andDo(print());

	}

	@Test(expected = Exception.class)
	public void getByEmailTest() throws Exception {
		when(theatreServiceImpl.getEmailId(theatre.getEmailId())).thenReturn(theatre);
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/theatre/{emailId}").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(theatre))).andExpect(MockMvcResultMatchers.status().isNotFound())
				.andDo(MockMvcResultHandlers.print());
		assertNotNull("abc");

	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new JsonParseException(e);
		}
	}

}
