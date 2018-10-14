package com.stackroute.buzzup.ticketengine.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.buzzup.ticketengine.domain.Show;

@Repository
public interface ShowRepository extends CrudRepository<Show, String>{

}
