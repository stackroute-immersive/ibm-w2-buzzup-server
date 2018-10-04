package com.stackroute.buzzup.moviescreeningservice.test.service;

import static org.mockito.ArgumentMatchers.any;

import static org.mockito.Mockito.when;

import java.util.ArrayList;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.stackroute.buzzup.moviescreeningservice.model.MovieScreening;
import com.stackroute.buzzup.moviescreeningservice.model.Theater;
import com.stackroute.buzzup.moviescreeningservice.repository.MovieScreeningRepository;
import com.stackroute.buzzup.moviescreeningservice.service.MovieScreeningServiceImpl;

public class MovieScreeningServiceImplTest {

	private MovieScreening moviescreening;
	@Mock
	private MovieScreeningRepository moviescreeningrepository;
	@InjectMocks
	private MovieScreeningServiceImpl moviescreeningserviceimpl;
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
	public void saveMovieScreeningTestSuccess() throws Exception {
		when(moviescreeningrepository.insert((MovieScreening) any())).thenReturn(moviescreening);
		MovieScreening savedmovie = moviescreeningserviceimpl.saveMovieDetails(moviescreening);
		Assert.assertEquals(moviescreening, savedmovie);
	}
	
	@Test(expected=Exception.class)
	public void saveMovieScreeningTestFailure() throws Exception
	{
		when(moviescreeningrepository.insert((MovieScreening) any())).thenReturn(null);	
		MovieScreening savedmovie = moviescreeningserviceimpl.saveMovieDetails(moviescreening);
		Assert.assertEquals(moviescreening, savedmovie);
	}
	@Test
	public void getAllMovie() throws Exception
	{
		when(moviescreeningrepository.getByCity("banglore")).thenReturn(movieList);
		List<MovieScreening> mov=moviescreeningserviceimpl.getTheaterByCity("banglore");
		Assert.assertEquals(movieList, mov);
		
	} 
	
}
