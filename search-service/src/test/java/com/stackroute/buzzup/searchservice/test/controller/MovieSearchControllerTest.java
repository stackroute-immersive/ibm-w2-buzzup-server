package com.stackroute.buzzup.searchservice.test.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.buzzup.searchservice.model.City;
import com.stackroute.buzzup.searchservice.model.Movie;
import com.stackroute.buzzup.searchservice.model.Theatre;
import com.stackroute.buzzup.searchservice.service.MovieSearchServiceImpl;

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

import static org.mockito.ArgumentMatchers.any;
import static org.junit.Assert.assertNotNull;

import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest


public class MovieSearchControllerTest 
{
	
	    
	    @Autowired
	    private MockMvc mockMvc;
	    @MockBean
	    private Movie movie;
	    @MockBean
	    private Theatre theatre;
	    @MockBean
	    private City city;
	    @MockBean
	    private MovieSearchServiceImpl MovieSearchServiceImpl;
	    @InjectMocks
	    private MovieSearchControllerTest MovieSearchController;
	    
	    private List<Movie> movieList;

	    
	    @Before
	    public void setUp()
	    {
	    	MockitoAnnotations.initMocks(this);
	    	mockMvc = MockMvcBuilders.standaloneSetup(MovieSearchController).build();
		    movie = new Movie();
	        movie.setId("2");
	        movie.setMovieName("incidious");
	        movie.setMoviePoster("src/images/im1.jpg");
	        movie.setSynopsis("src/images/im2.jpg");
	        movie.setMovieReleasedate("horror");
	        movie.setMovieDuration("english");
	        movie.setLanguages("English");
	        movie.setMovieGenre("horror");
	        theatre.setTheatreId("pvr123");
	        city=new City();
	        city.setId("3");
	        city.setCityName("chennai");
	    }
	  
	    @Test
	    public void getMovieByNameTest() throws Exception 
	    {
	        when(MovieSearchServiceImpl.getByTitle("incidious")).thenReturn(movieList);
	        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/movie/incidious").contentType(MediaType.APPLICATION_JSON)
	                .content(asJsonString(movie))).andExpect(MockMvcResultMatchers.status().isNotFound())
	                .andDo(MockMvcResultHandlers.print());
	        assertNotNull("abc");
	        
	    }
	    
	    @Test
	    public void getMovieByCityTest() throws Exception 
	    {
	        when(MovieSearchServiceImpl.getByCity("bangalore")).thenReturn(city);
	        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/city/bangalore").contentType(MediaType.APPLICATION_JSON)
	                .content(asJsonString(city))).andExpect(MockMvcResultMatchers.status().isNotFound())
	                .andDo(MockMvcResultHandlers.print());
	        assertNotNull("abc");
	        
	    }
	    @Test
	    public void saveCityTest() throws Exception {

	        when(MovieSearchServiceImpl.saveCity(any(City.class))).thenReturn("saved");
	        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/city")
	                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(city)))
	                .andExpect(MockMvcResultMatchers.status().isNotFound())
	                .andDo(MockMvcResultHandlers.print());
	        assertNotNull("abc");
	    }
	    public static String asJsonString(final Object obj) 
	    {
	        try 
	        {
	            return new ObjectMapper().writeValueAsString(obj);
	        } 
	        catch (Exception e) 
	        {
	            throw new JsonParseException(e);
	        }
	    }
}