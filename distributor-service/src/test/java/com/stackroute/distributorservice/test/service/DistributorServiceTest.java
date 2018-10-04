package com.stackroute.distributorservice.test.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.stackroute.distributorservice.exceptions.DistributorNotCreatedException;
import com.stackroute.distributorservice.model.Distributor;
import com.stackroute.distributorservice.repository.DistributorRepository;
import com.stackroute.distributorservice.service.DistributorServiceImpl;



public class DistributorServiceTest {

	 @Mock
	 private DistributorRepository distributorRepository;


	 private Distributor distributor;

	    @InjectMocks
	    private DistributorServiceImpl distributorService;
	    
	    @Before
	    public void setUp() {
	        MockitoAnnotations.initMocks(this);

	        distributor = new Distributor();
	        distributor.setEmailId("Vignesh008");
	        distributor.setDistributorName("vignesh");
	        distributor.setDistributorLocation("Chennai");
	      

	    }

	    @Test
	    public void registerDistributorSuccess() throws DistributorNotCreatedException {
	        when(distributorRepository.insert((Distributor) any())).thenReturn(distributor);
	        Distributor distributorSaved = distributorService.createDistributor(distributor);
	        assertEquals(distributor, distributorSaved);

	    }

	    @Test(expected = DistributorNotCreatedException.class       )
	    public void registerDistributorFailure() throws DistributorNotCreatedException {
	        when(distributorRepository.insert((Distributor) any())).thenReturn(null);
	        Distributor distributorSaved = distributorService.createDistributor(distributor);
	        assertEquals(distributor, distributorSaved);

	    }

/*	   @Test
	    public void updateDistributorLocation() throws DistributorNotFoundException {
	        when(distributorRepository.findById(distributor.getDistributorId()));
	        distributor.setDistributorLocation("Chennai");
	        Distributor fetchedDistributor = distributorService.distributorLocation(location)(distributor.getDistributorLocation(), distributor));
	        assertEquals(distributor, fetchedDistributor);

	    }

	  private String location(String distributorLocation, Distributor distributor2) {
		// TODO Auto-generated method stub
		return null;
	}*/



 	   /* @Test
 
	    public void getDistributorByLocation() throws DistributorNotFoundException {

	        when(distributorRepository.findById(distributorRepository.getBydistributorLocation(location)));

	        Distributor fetchedDistributor = distributorService.distributorLocation(distributor.getDistributorLocation());

	        assertEquals(distributor, fetchedDistributor);

	    }*/


	}
