package com.stackroute.Distributorservice.test.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.stackroute.Distributorservice.model.Movie;
import com.stackroute.Distributorservice.repository.MovieRepository;
import com.stackroute.Distributorservice.service.ServicesImpl;



public class ServicesImplTest 
{

    private Movie movie;

    @Mock
    private MovieRepository movierepository;

    @InjectMocks
    private ServicesImpl serviceImpl;
    private List<Movie> movieList;
    Optional<Movie> options;
    
    @Before
    public void setUp() throws Exception {

        

        Movie movie = new Movie();
        movie.setId("1");
        movie.setMovieName("Raazi");
        movie.setMoviePoster("src/images/im1.jpg");
        movie.setMovieGenres("horror");
        movie.setLanguages("english");
        
        
         movieList = new ArrayList<>(); 
         options = Optional.of(movie); 
    }

     @Test(expected=Exception.class)
     public void saveMovieSuccess() throws Exception {
         
    	 when(movierepository.save((Movie) any())).thenReturn(movie);
        
         Movie movieSaved = serviceImpl.saveMovie(movie);
         
         assertEquals(movie, movieSaved);

     }
   
     @Test(expected=Exception.class)
     public void getByMovieTitleTest() throws Exception {
     
    	when(movierepository.getByMovieName(movie.getMovieName())).thenReturn(movieList);
        
    	List<Movie> fetchedMovie = serviceImpl.getByMovieTitle("Raazi");

        assertEquals(movie, fetchedMovie);

    }
    
    @Test(expected=Exception.class)
    public void getAllMoviesTest() {
        when(movierepository.findAll()).thenReturn(movieList);
        List<Movie> movies = serviceImpl.getAllMovies();
        Assert.assertEquals(movieList, movies);
    }
}
