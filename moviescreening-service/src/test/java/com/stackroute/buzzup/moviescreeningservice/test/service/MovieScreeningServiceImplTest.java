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

import com.stackroute.buzzup.kafka.model.MovieSchedule;

import com.stackroute.buzzup.moviescreeningservice.repository.MovieScreeningRepository;
import com.stackroute.buzzup.moviescreeningservice.service.MovieScreeningServiceImpl;

public class MovieScreeningServiceImplTest {
	private MovieSchedule movieSchedule;
	@Mock
	private MovieScreeningRepository movieScreeningRepository;
	@InjectMocks
	private MovieScreeningServiceImpl movieScreeningServiceImpl;
	private List<MovieSchedule> allMovies;


	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		movieSchedule = new MovieSchedule();
		movieSchedule.setActors("srk");
		movieSchedule.setActress("dipika");
		movieSchedule.setDirectors("anurag");
		movieSchedule.setEmailId("utkarsh@gmail.com");
		movieSchedule.setId("123");
		movieSchedule.setMovieName("ddlj");

		allMovies = new ArrayList<>();
		allMovies.add(movieSchedule);
		
	}

	@Test(expected = Exception.class)
	public void createMovieScheduleSuccess() {
		when(movieScreeningRepository.insert((MovieSchedule) any())).thenReturn(movieSchedule);
		MovieSchedule saveMovieSchedule = movieScreeningServiceImpl.addMovieSchedule(movieSchedule);
		Assert.assertEquals(movieSchedule, saveMovieSchedule);
	}

	@Test(expected = Exception.class)
	public void createMovieScheduleFailure() {
		when(movieScreeningRepository.insert((MovieSchedule) any())).thenReturn(null);
		MovieSchedule saveMovieSchedule = movieScreeningServiceImpl.addMovieSchedule(movieSchedule);
		Assert.assertEquals(movieSchedule, saveMovieSchedule);
	}

    @Test
    public void updateMovieScheduleSucces()
    {
    	when(movieScreeningRepository.getByTheatreId(movieSchedule.getId())).thenReturn(movieSchedule);
       movieSchedule.setActors("srk");
       MovieSchedule saveMovie=movieScreeningServiceImpl.updateMovieSchedule(movieSchedule.getEmailId(), movieSchedule);
       Assert.assertEquals(movieSchedule,saveMovie);
    }

    @Test
    public void updateMovieSchduleFailure()
    {
    	when(movieScreeningRepository.getByTheatreId(movieSchedule.getId())).thenReturn(movieSchedule);
        movieSchedule.setActors("srkdsad");
        MovieSchedule saveMovie=movieScreeningServiceImpl.updateMovieSchedule(movieSchedule.getEmailId(), movieSchedule);
        Assert.assertEquals(movieSchedule,saveMovie);
    }
	
}
