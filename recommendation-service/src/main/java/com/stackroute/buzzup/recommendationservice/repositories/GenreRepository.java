package com.stackroute.buzzup.recommendationservice.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.buzzup.recommendationservice.model.Genre;


@Repository
public interface GenreRepository extends Neo4jRepository<Genre, Long> {

	public Genre findByName(String name);

}
