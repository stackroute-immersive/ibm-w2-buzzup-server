package com.stackroute.buzzup.ticketingengine.test.controller;

import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertNotEquals;
//import static org.junit.Assert.assertNotEquals;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.buzzup.ticketingengine.controller.TicketingEngineController;
import com.stackroute.buzzup.ticketingengine.exceptions.TicketCannotGenerateException;
import com.stackroute.buzzup.ticketingengine.model.TicketingEngine;
import com.stackroute.buzzup.ticketingengine.service.TicketingEngineService;


	@RunWith(SpringRunner.class)
	@WebMvcTest
	public class TicketingEngineControllerTest {
	    @Autowired
	    private MockMvc mockMvc;

	    private TicketingEngine ticketingEngine;

	    @MockBean
	    private TicketingEngineService ticketingEngineService;

	    @InjectMocks
	    private TicketingEngineController ticketingEngineController;

	   


	    @Before
	    public void setUp()
	    {
	        MockitoAnnotations.initMocks(this);
	        mockMvc = MockMvcBuilders.standaloneSetup(ticketingEngineController).build();
	        ticketingEngine = new TicketingEngine();
	        ticketingEngine.setId(8);
	        ticketingEngine.setName("vignesh");
	        ticketingEngine.setLocation("Chennai");
	        
	        


	    }

	    @Test
	    public void generateTicketSuccess() throws Exception
	    {
	    	assertNotNull("Hi");
	        when(ticketingEngineService.generateTicket(any())).thenReturn(ticketingEngine);
	        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/TicketingEngine").contentType
	                (MediaType.APPLICATION_JSON)
	                .content(asJsonString(ticketingEngine)))
	                .andExpect(MockMvcResultMatchers.status().isCreated())
	                .andDo(MockMvcResultHandlers.print());

	    }

	    @Test
	    public void createDistributorFailure() throws Exception
	    {
	    	assertNotNull("Hi");
	        when(ticketingEngineService.generateTicket(any())).thenThrow(TicketCannotGenerateException.class);
	        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/TicketingEngine").
	                contentType(MediaType.APPLICATION_JSON)
	                .content(asJsonString(ticketingEngine)))
	                .andExpect(MockMvcResultMatchers.status().isConflict())
	                .andDo(MockMvcResultHandlers.print());


	    }
	/*
	    @Test
	    public void deleteReminderSuccess() throws Exception
	    {
	        when(reminderService.deleteReminder(reminder.getReminderId())).thenReturn(true);
	        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/reminder/5b0509731764e3096984eae6").
	                contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isOk())
	                .andDo(MockMvcResultHandlers.print());


	    }

	    @Test
	    public void deleteReminderFailure() throws Exception
	    {
	        when(reminderService.deleteReminder(reminder.getReminderId())).thenThrow(ReminderNotFoundException.class);
	        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/reminder/5b0509731764e3096984eae6").
	                contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isNotFound())
	                .andDo(MockMvcResultHandlers.print());


	    }



	    @Test
	    public void updateReminderSuccess() throws Exception {

	        when(reminderService.updateReminder(any(), eq(reminder.getReminderId()))).thenReturn(reminder);
	        reminder.setReminderDescription("Send me email at 6:00PM");
	        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/reminder/5b0509731764e3096984eae6")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(asJsonString(reminder)))
	                .andExpect(MockMvcResultMatchers.status().isOk())
	                .andDo(MockMvcResultHandlers.print());


	    }

	    @Test
	    public void updateReminderFailure() throws Exception
	    {
	        when(reminderService.updateReminder(any(),eq(reminder.getReminderId()))).thenThrow(ReminderNotFoundException.class);
	        reminder.setReminderDescription("Send me email at 6:00PM");
	        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/reminder/5b0509731764e3096984eae6")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(asJsonString(reminder)))
	                .andExpect(MockMvcResultMatchers.status().isNotFound())
	                .andDo(MockMvcResultHandlers.print());

	    }*/

	    @Test
	    public void getReminderByIdSucccess() throws Exception
	    {
	    	assertNotNull("Hi");
	        when(ticketingEngineService.getByTicketId(ticketingEngine.getId())).thenReturn(ticketingEngine);
	        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/TicketingEngine/08")
	                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(ticketingEngine))).
	                andExpect(MockMvcResultMatchers.status().isAccepted())
	                .andDo(MockMvcResultHandlers.print());

	    }
/*
	    @Test
	    public void getReminderByIdFailure() throws Exception
	    {
	        when(reminderService.getReminderById(reminder.getReminderId())).thenThrow(ReminderNotFoundException.class);
	        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/reminder/5b0509731764e3096984eae6").
	                contentType(MediaType.APPLICATION_JSON).content(asJsonString(reminder)))
	                .andExpect(MockMvcResultMatchers.status().isNotFound())
	                .andDo(MockMvcResultHandlers.print());

	    }

	    @Test
	    public void getAllReminderById() throws Exception
	    {
	        when(reminderService.getAllReminders()).thenReturn(reminderList);
	        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/reminder").contentType(MediaType.APPLICATION_JSON)
	                .content(asJsonString(reminderList))).andExpect(MockMvcResultMatchers.status().isOk())
	                .andDo(MockMvcResultHandlers.print());

	    }    */              


	    private static String asJsonString(final Object obj) {
	        try {
	            return new ObjectMapper().writeValueAsString(obj);
	        } catch (Exception e) {
	            throw new RuntimeException(e);
	        }
	    }


		}
