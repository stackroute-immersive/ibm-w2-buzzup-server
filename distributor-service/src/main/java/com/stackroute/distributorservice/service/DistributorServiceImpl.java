package com.stackroute.distributorservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.distributorservice.exceptions.DistributorNotCreatedException;
import com.stackroute.distributorservice.exceptions.DistributorNotFoundException;
import com.stackroute.distributorservice.model.Distributor;
import com.stackroute.distributorservice.repository.DistributorRepository;

@Service
public class DistributorServiceImpl implements DistributorService {
	
	private DistributorRepository distributorRepository;
	   /*
     * Autowiring should be implemented for the DistributorRepository. (Use
     * Constructor-based autowiring) Please note that we should not create any
     * object using the new keyword.
     */
@Autowired
public DistributorServiceImpl(DistributorRepository distributorRepository) {
	this.distributorRepository=distributorRepository;
}
/*
 * This method should be used to register a new Distributor.Call the corresponding
 * method of Repository interface.
 */
public Distributor createDistributor(Distributor distributor)throws DistributorNotCreatedException{

	Distributor ds=distributorRepository.insert(distributor);
	if(ds==null)
	{
		throw new DistributorNotCreatedException("already");
	}
	return ds;
}
/*
 * This method should be used to get a Distributor by Location.Call the
 * corresponding method of Respository interface.
 */
public Distributor distributorLocation(String location) throws DistributorNotFoundException
{
	Distributor dis=distributorRepository.getBydistributorLocation(location);
	if(dis==null)
	{
		throw new DistributorNotFoundException("not found");
	}
	return dis;
}


	}