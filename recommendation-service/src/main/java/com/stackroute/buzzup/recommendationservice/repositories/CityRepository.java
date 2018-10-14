package com.stackroute.buzzup.recommendationservice.repositories;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stackroute.buzzup.recommendationservice.model.City;



@Repository
public interface CityRepository extends Neo4jRepository<City, Long> {

	@Query("MATCH (c:City) WHERE c.name ={name} RETURN c")
	City findByName(@Param("name") String name);
}
