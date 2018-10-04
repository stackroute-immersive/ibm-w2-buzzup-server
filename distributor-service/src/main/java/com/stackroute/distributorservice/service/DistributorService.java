package com.stackroute.distributorservice.service;
import com.stackroute.distributorservice.exceptions.DistributorNotCreatedException;
import com.stackroute.distributorservice.exceptions.DistributorNotFoundException;
import com.stackroute.distributorservice.model.Distributor;

public interface DistributorService {
	public Distributor createDistributor(Distributor distributor)throws DistributorNotCreatedException;
	//boolean deleteDistributor(String distributorId)throws DistributorNotFoundException;
	//public Distributor getDistributorById(String DistributorId) throws DistributorNotFoundException;
	//public List<Movies> getAllMoviesByDistributorLocation(String DistributorLocation);
	//Distributor updateDistributor(String distributorId, Distributor distributor) throws DistributorNotFoundException;
	public Distributor distributorLocation(String location) throws DistributorNotFoundException;
	

}
