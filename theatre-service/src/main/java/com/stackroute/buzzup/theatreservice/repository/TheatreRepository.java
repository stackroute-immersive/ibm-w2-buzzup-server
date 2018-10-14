package com.stackroute.buzzup.theatreservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.buzzup.kafka.domain.Theatre;

@Repository
public interface TheatreRepository extends CrudRepository<Theatre, Integer> {

	public Theatre getByTheatreName(String theatre);
	
	public Theatre getByEmail(String email);
	
	public boolean existsByTheatreName(String theatreName);
	
}
