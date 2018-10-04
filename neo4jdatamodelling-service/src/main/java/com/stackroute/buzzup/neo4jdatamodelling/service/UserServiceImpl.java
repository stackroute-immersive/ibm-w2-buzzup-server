package com.stackroute.buzzup.neo4jdatamodelling.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.buzzup.neo4jdatamodelling.exceptions.NodeNotCreatedException;
import com.stackroute.buzzup.neo4jdatamodelling.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userrepository;
	private String node;

	@Autowired
	public UserServiceImpl(UserRepository userrepository) {

		this.userrepository = userrepository;
	}
	//This method is used to save new node for repository corresponding service
	public String saveAll() throws NodeNotCreatedException {

		node = userrepository.saveAllUser();
		if (node != null)
			return node;
		else
			throw new NodeNotCreatedException();
	}

}
