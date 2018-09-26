package com.stackroute.distributorservice.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.distributorservice.model.Distributor;

@Repository
public interface DistributorRepository extends MongoRepository<Distributor, String> {

	public Distributor getBydistributorLocation(String location);
	
}


