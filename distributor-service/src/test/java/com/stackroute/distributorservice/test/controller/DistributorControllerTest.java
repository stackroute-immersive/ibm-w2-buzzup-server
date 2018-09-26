package com.stackroute.distributorservice.test.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import com.stackroute.distributorservice.controller.DistributorController;
import com.stackroute.distributorservice.exceptions.DistributorNotCreatedException;
import com.stackroute.distributorservice.exceptions.DistributorNotFoundException;
import com.stackroute.distributorservice.model.Distributor;
import com.stackroute.distributorservice.model.Movies;
import com.stackroute.distributorservice.service.DistributorService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;

@RunWith(SpringRunner.class)
@WebMvcTest
public class DistributorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private Distributor distributor;

    @MockBean
    private DistributorService distributorService;

    @InjectMocks
    private DistributorController distributorController;

    private List<Movies> movies=null;


    @Before
    public void setUp()
    {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(distributorController).build();
        distributor = new Distributor();
        distributor.setEmailId("Vignesh008");
        distributor.setDistributorName("vignesh");
        distributor.setDistributorLocation("Chennai");
        movies = new ArrayList<>();
       


    }

    @Test
    public void createDistributorSuccess() throws Exception
    {
        when(distributorService.createDistributor(any())).thenReturn(distributor);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/distributor").contentType
                (MediaType.APPLICATION_JSON)
                .content(asJsonString(distributor)))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void createDistributorFailure() throws Exception
    {
        when(distributorService.createDistributor(any())).thenThrow(DistributorNotCreatedException.class);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/distributor").
                contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(distributor)))
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

    }

    @Test
    public void getReminderByIdSucccess() throws Exception
    {
        when(reminderService.getReminderById(reminder.getReminderId())).thenReturn(reminder);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/reminder/5b0509731764e3096984eae6")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(reminder))).
                andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }

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