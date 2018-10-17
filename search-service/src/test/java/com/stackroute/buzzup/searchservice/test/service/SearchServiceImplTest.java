package com.stackroute.buzzup.searchservice.test.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.stackroute.buzzup.searchservice.exceptions.MovieNotFoundException;
import com.stackroute.buzzup.searchservice.model.City;
import com.stackroute.buzzup.searchservice.model.Movie;

import com.stackroute.buzzup.searchservice.model.Theatre;
import com.stackroute.buzzup.searchservice.repository.CityRepository;
import com.stackroute.buzzup.searchservice.repository.MovieRepository;
import com.stackroute.buzzup.searchservice.service.MovieSearchServiceImpl;


public class SearchServiceImplTest {


    private City city;
    private Movie movie;
    private Theatre theatre;

    @Mock
    private MovieRepository movierepository;
    private CityRepository cityrepository;

    @InjectMocks
    private MovieSearchServiceImpl searchServiceImpl;
    private List<Movie> movieList;
    
    @Before
    public void setUp() throws Exception {

        
        Movie movie = new Movie();
        movie.setId("2");
        movie.setMovieName("incidious");
        movie.setMoviePoster("src/images/im1.jpg");
        movie.setMovieGenre("horror");
        movie.setLanguages("english");
        
         City city=new City();
         city.setId("1");
         city.setCityName("bangalore");
         city.setMovieList(movieList);
 
        
         movieList = new ArrayList<>(); 
    }

     @Test(expected=Exception.class)
    public void getMovieByTitleTest() throws Exception {
     
    	when(movierepository.findByMovieName(movie.getMovieName())).thenReturn(movie);
        
    	List<Movie> fetchedMovie = searchServiceImpl.getByTitle("Jak De India");

        assertEquals(movie, fetchedMovie);

    }
    @Test(expected=Exception.class)
    public void getMovieByCityTest() throws Exception {

    	when(cityrepository.findBycityName(city.getCityName())).thenReturn(city);

        City fetchedMovie = searchServiceImpl.getByCity("Bangalore");

        assertEquals(city, fetchedMovie);
    }
    }
 
