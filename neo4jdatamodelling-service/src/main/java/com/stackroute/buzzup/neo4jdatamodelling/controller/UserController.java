package com.stackroute.buzzup.neo4jdatamodelling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.buzzup.neo4jdatamodelling.exceptions.NodeNotCreatedException;
import com.stackroute.buzzup.neo4jdatamodelling.service.UserServiceImpl;

@RestController
@RequestMapping("/api/v1/rest")
public class UserController {
	private UserServiceImpl userService;

	@Autowired
	public UserController(UserServiceImpl userservice) {

		this.userService = userservice;
	}

	@PostMapping("/neo4j")
/**This handler method should map to url "/api/v1/rest/neo4j" using HTTP Post Method**/
	public String saveAllNodes() {
		String user = null;
		try {
			user = userService.saveAll();
		} catch (NodeNotCreatedException e) {
			e.getMessage();
		}
		return user;
	}
}