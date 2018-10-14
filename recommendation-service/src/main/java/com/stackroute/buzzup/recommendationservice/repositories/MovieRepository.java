package com.stackroute.buzzup.recommendationservice.repositories;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stackroute.buzzup.recommendationservice.model.Movie;



@Repository
public interface MovieRepository extends Neo4jRepository<Movie, Long> {

	@Query("Match (u:User)-[:follows]->(g:Genre)<-[:isTypeOf]-(r:Movie) where u.emailId={emailId} Match (r)-[:releasedIn]->(c:City)<-[:livesIn]-(u) return (r)")
	List<Movie> getGenreBasedMoviesForUser(@Param("emailId") String emailId);
	@Query("Match (u:User)-[:follows]->(g:Genre)<-[:isTypeOf]-(r:Movie) where u.emailId={emailId} Match (r)-[:releasedIn]->(c:City)<-[:livesIn]-(u)  Match (r)-[:LanguageType]->(l:Language)<-[:preferredLanguage]-(u) return (r)")
    public List<Movie> getGenreLanguageBasedMoviesForUser(@Param("emailId") String emailId);
	@Query("Match (u:User)-[:preferredLanguage]->(l:Language)<-[:LanguageType]-(r:Movie) where u.emailId={emailId} Match (r)-[:releasedIn]->(c:City)<-[:livesIn]-(u) return (r)")
	List<Movie> getLanguageBasedMoviesForUser(@Param("emailId") String emailId);
	@Query("MATCH (m:Movie) WHERE m.name ={name} RETURN m")
	Movie findByName(@Param("name") String name);
	@Query ("MATCH (m:Movie) WHERE m.name ={name} RETURN m")
	List<Movie> getTrendingMovie();
}
