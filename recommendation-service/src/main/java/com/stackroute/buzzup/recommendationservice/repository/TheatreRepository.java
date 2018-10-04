package com.stackroute.buzzup.recommendationservice.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.stackroute.buzzup.recommendationservice.model.Theatre;


public interface TheatreRepository extends Neo4jRepository<Theatre, String>{

}
