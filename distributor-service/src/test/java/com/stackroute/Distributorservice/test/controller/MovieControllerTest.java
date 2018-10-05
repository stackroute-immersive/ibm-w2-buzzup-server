package com.stackroute.Distributorservice.test.controller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
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
import com.stackroute.Distributorservice.model.Movie;
import com.stackroute.Distributorservice.service.ServicesImpl;

public class MovieControllerTest 
{

	@Autowired
    private MockMvc mockMvc;
	@MockBean
    private Movie movie;
	@MockBean
    private ServicesImpl ServiceImpl;
	@InjectMocks
    private MovieControllerTest MovieSearchController;
  
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
        movie.setFormat("mpeg");
        movie.setDirectors("Atlee");
   }
    @Test(expected=NullPointerException.class)
    public void SaveCityTest() throws Exception {

        when(ServiceImpl.saveMovie(any())).thenReturn(movie);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/jak de india")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(movie)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
    @Test(expected=NullPointerException.class)
    public void getMovieByTitleFromDB() throws Exception{
        when(ServiceImpl.getByMovieTitle("incidious")).thenReturn(movieList);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/movie/incidious").contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(movie))).andExpect(MockMvcResultMatchers.status().isFound())
                .andDo(MockMvcResultHandlers.print());
        assertNotNull("abc");
    }
    @Test(expected=NullPointerException.class)
    public void getAllMovies() throws Exception{
        when(ServiceImpl.getAllMovies()).thenReturn(movieList);
         mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/incidious").contentType(MediaType.APPLICATION_JSON)
                    .content(asJsonString(movie))).andExpect(MockMvcResultMatchers.status().isOk())
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
