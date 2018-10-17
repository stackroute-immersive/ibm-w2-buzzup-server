package com.stackroute.buzzup.recommendationservice.repositories;


import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.buzzup.recommendationservice.model.User;



@Repository
public interface UserRepository extends Neo4jRepository<User, Long> {
}
