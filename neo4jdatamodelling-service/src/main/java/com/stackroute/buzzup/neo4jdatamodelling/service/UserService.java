package com.stackroute.buzzup.neo4jdatamodelling.service;

import com.stackroute.buzzup.neo4jdatamodelling.exceptions.NodeNotCreatedException;

public interface UserService {
	//have to implement these methods in the correspoding service class
	
	String saveAll() throws NodeNotCreatedException;
}
