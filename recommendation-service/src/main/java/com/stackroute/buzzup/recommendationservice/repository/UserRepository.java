package com.stackroute.buzzup.recommendationservice.repository;


import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.buzzup.recommendationservice.model.User;


@Repository
public interface UserRepository extends Neo4jRepository<User, Long> {
//	@Query("MATCH (u:User)-[:livesIn]->(c:City) where u.name={userName} return c")
//	public City getCityOfUser(@Param("userName") String userName);
//
//	@Query("MATCH (u:User)-[:follows]->(g:Genre) where u.name={userName} return c")
//	public Genre getGenreOfUser(@Param("userName") String userName);
//
//	@Query("MATCH (u:User)-[:preferredLanguage]->(l:Language) where u.name={userName} return c")
//	public Language getLanguageOfUser(@Param("userName") String userName);
//
//	@Query("Match (u:User)-[:follows]->(g:Genre)<-[:isTypeOf]-(r:Movie) where u.name={userName}  Match (r)-[:releasedIn]->(c:City)<-[:livesIn]-(u) return (r)")
//	public List<Movie> getGenreBasedMoviesForUser(String userName);
//
//	@Query("Match (u:User)-[:preferredLanguage]->(l:Language)<-[:languageType]-(r:Movie) where u.name={userName}  Match (r)-[:releasedIn]->(c:City)<-[:livesIn]-(u) return (r)")
//	public List<Movie> getLanguageBasedMoviesForUser(@Param("userName") String userName);
//	@Query("Match (u:User)-[:preferredLanguage]->(l:Language)<-[:languageType]-(r:Movie) where u.name={userName}  Match (r)-[:releasedIn]->(c:City)<-[:livesIn]-(u) return (r)")
//	public List<Movie> getGenreLanguageBasedMoviesForUser(String userName);
}
