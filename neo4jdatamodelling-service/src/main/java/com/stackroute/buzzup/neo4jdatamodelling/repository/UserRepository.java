package com.stackroute.buzzup.neo4jdatamodelling.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.stackroute.buzzup.neo4jdatamodelling.model.User;
//This represents implementing neo4j repository 

public interface UserRepository extends Neo4jRepository<User, String> {

	@Query("CREATE (b:User{name:'Anu',id:20,age:21,gender:'female'})CREATE(c:Movie{movieName:'IMKN',id:50})CREATE(b)-[:WATCHES{rates:'60'}]->(c) CREATE(e:Language{lang:'English'}) CREATE(p:Genre{Name:'Drama'}) CREATE(d:Movie{movieName:'VTV',id:51}) CREATE(b)-[:WATCHES{rates:'62'}]->(d) CREATE(b)-[:PREFERS{likes:'60'}]->(e) CREATE(b)-[:FOLLOWS{actor:'kk'}]->(p)")
	String saveAllUser();

}
