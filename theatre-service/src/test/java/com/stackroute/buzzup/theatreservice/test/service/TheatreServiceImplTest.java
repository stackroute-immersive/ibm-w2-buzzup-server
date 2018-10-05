package com.stackroute.buzzup.theatreservice.test.service;


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

import com.stackroute.buzzup.theatreservice.exception.TheatreNotFoundException;
import com.stackroute.buzzup.theatreservice.model.Theatre;
import com.stackroute.buzzup.theatreservice.repository.TheatreRepository;
import com.stackroute.buzzup.theatreservice.service.TheatreServiceImpl;

//import com.stackroute.keepnote.model.Category;
public class TheatreServiceImplTest {

	private Theatre theatre;

	@Mock
	private  TheatreRepository theatrerepository;

	@InjectMocks
	private TheatreServiceImpl theatreserviceimpl;
	private List<Theatre> allTheatre;
	Optional<Theatre> options;

	@Before
	public void Setup() throws Exception
	{
		MockitoAnnotations.initMocks(this);

		 theatre=new Theatre();
		theatre.setTheatreId("1");
		theatre.setEmailId("utkarsh@gmail.com");
		theatre.setCity("pune");
		theatre.setLicenseNo("qw12");
		theatre.setName("pvr");
		allTheatre=new ArrayList<>();
		allTheatre.add(theatre);
		options=Optional.of(theatre);
	}

	
	
	@Test
	public void getByEmailTest() throws Exception
	{
		when(theatrerepository.getByEmailId(theatre.getEmailId())).thenReturn(theatre);
		Theatre savedTheatre =theatreserviceimpl.getEmailId("utkarsh@gmail.com");
		Assert.assertEquals(theatre,savedTheatre);
	}


	@Test
	public void getTheatreByTheatreTitleTest() throws TheatreNotFoundException
	{
		when(theatrerepository.getByName(theatre.getName())).thenReturn(theatre);
		Theatre saveTheatre =theatreserviceimpl.getTheatreByTheatreTitle("pvr");
		Assert.assertEquals(theatre,saveTheatre);
	}
	
}