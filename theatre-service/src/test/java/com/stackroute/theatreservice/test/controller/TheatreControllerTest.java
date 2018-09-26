package com.stackroute.theatreservice.test.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
/*import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;*/
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.any;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.buzzup.theatreservice.TheatreServiceApplication;
import com.stackroute.buzzup.theatreservice.controller.TheatreController;
import com.stackroute.buzzup.theatreservice.exception.TheatreAlreadyExistsException;
import com.stackroute.buzzup.theatreservice.exception.TheatreNotFoundException;
import com.stackroute.buzzup.theatreservice.model.Theatre;
import com.stackroute.buzzup.theatreservice.service.TheatreService;

@RunWith(SpringRunner.class)
@WebMvcTest
@ContextConfiguration(classes={TheatreServiceApplication.class})
public class TheatreControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private Theatre theatre;
	@MockBean
	private TheatreService theatreService;
	@InjectMocks
	private TheatreController theatreController;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(theatreController).build();
		String category[] = {};
		String noOfSeats[] = {};
		theatre = new Theatre();
		theatre.setEmailId("yoga30@gmail.com");
		theatre.setTheaterId("Jhon123");
		theatre.setTheaterName("PVR");
		theatre.setTheaterCity("chennai");
		theatre.setTheaterAddress("1/3, vasant vihar");
		theatre.setTheaterCategory(category);
		theatre.setNoOfSeats(noOfSeats);
		theatre.setNoOfScreen(4);
	}

	@Test
	public void registerTheatreSuccess() throws Exception {

		when(theatreService.registerTheatre(theatre)).thenReturn(theatre);
		assertNotNull("hi");
		mockMvc.perform(post("/api/v1/theatre").contentType(MediaType.APPLICATION_JSON).content(asJsonString(theatre)))
				.andExpect(status().isCreated()).andDo(print());

	}

	@Test
	public void registerTheatreFailure() throws Exception {

		when(theatreService.registerTheatre(any())).thenThrow(TheatreAlreadyExistsException.class);
		assertNotNull("hi");
		mockMvc.perform(post("/api/v1/theatre").contentType(MediaType.APPLICATION_JSON).content(asJsonString(theatre)))
				.andExpect(status().isConflict()).andDo(print());

	}

	@Test
	public void updateTheatreSuccess() throws Exception {
		theatre.setTheaterName("gold");
		assertNotNull("hi");
		when(theatreService.updateTheatre(eq(theatre.getTheaterId()), any())).thenReturn(theatre);
		mockMvc.perform(
				put("/api/v1/theatre/Jhon123").contentType(MediaType.APPLICATION_JSON).content(asJsonString(theatre)))
				.andExpect(status().isOk()).andDo(print());

	}

	/*
	 * @Test public void updateTheatreFailure() throws Exception {
	 * theatre.setName("pvr");
	 * when(theatreService.updateTheatre(eq(theatre.getId()),
	 * any())).thenThrow(TheatreNotFoundException.class);
	 * mockMvc.perform(put("/api/v1/theatre/Jhon123")
	 * .contentType(MediaType.APPLICATION_JSON).content(asJsonString(theatre)))
	 * .andExpect(status().isNotFound()).andDo(MockMvcResultHandlers.print());
	 * 
	 * }
	 */

	@Test
	public void deleteTheatreSuccess() throws Exception {

		when(theatreService.deleteTheatre("Jhonny123")).thenReturn(true);
		assertNotNull("hi");
		mockMvc.perform(delete("/api/v1/theatre/Jhon123").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void deleteTheatreFailure() throws Exception {

		when(theatreService.deleteTheatre("Jhonny123")).thenThrow(TheatreNotFoundException.class);
		assertNotNull("hi");
		mockMvc.perform(delete("/api/v1/theatre/Jhonny123").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound()).andDo(print());
	}

	/*
	 * @Test public void getTheatreByemailIdSuccess() throws Exception {
	 * when(theatreService.getTheatreByemailId(theatre.getEmailId())).thenReturn(
	 * theatre); mockMvc.perform(get("/api/v1/theatre/Jhonny123@gmail.com")
	 * .contentType(MediaType.APPLICATION_JSON)) .andExpect(status().isOk()); }
	 */
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new JsonParseException(e);
		}
	}

}