package com.stackroute.distributorservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.distributorservice.model.Distributor;
import com.stackroute.distributorservice.service.DistributorService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class DistributorController {
	
	private DistributorService distributorService;
	/*
	 * Autowiring should be implemented for the DistributorService. (Use Constructor-based
	 * autowiring) Please note that we should not create an object using the new
	 * keyword
	 */
	@Autowired
	public DistributorController(DistributorService distributorService) {
		//super();
		this.distributorService = distributorService;
	}
	 /*
	 * Define a handler method which will register a specific distributor by reading the
	 * Serialized object from request body and save the user details in the
	 * database. This handler method should return any one of the status messages
	 * basis on different situations:
	 * 1. 201(CREATED) - If the distributor created successfully. 
	 * 2. 409(CONFLICT) - If the Id conflicts with any existing distributor
	 * 
	 * This handler method should map to the URL "/api/v1/distributor" using HTTP POST method
	 */
 
	@PostMapping("/distributor")
	public ResponseEntity<?>createDistributor(@RequestBody Distributor distributor){
		ResponseEntity<?>responseEntity= null;
		try {
			Distributor dis=distributorService.createDistributor(distributor);
			responseEntity = new ResponseEntity<Distributor>(dis,HttpStatus.CREATED);
		}
		catch(Exception e){
			responseEntity=new ResponseEntity<String>("already",HttpStatus.CONFLICT);
		}
		return responseEntity;
	}
	
	/*
 	 * Define a handler method which will get us the distributors by a Id.
 	 * 
 	 * This handler method should return any one of the status messages basis on
 	 * different situations: 1. 200(OK) - If the distributors found successfully. 
 	 * 
 	 * 
 	 * This handler method should map to the URL "/api/v1/distributor/{id}" using HTTP GET method
 	 */
	@GetMapping("/distributor/{id}")
	public ResponseEntity<?> getDistributorDetails(@PathVariable("id") String id)
	{
		ResponseEntity<?> responseEntity=null;
		try {
		Distributor ds=distributorService.distributorLocation(id);
		responseEntity = new ResponseEntity<Distributor>(ds, HttpStatus.OK);
		}
		catch(Exception e)
		{
			responseEntity = new ResponseEntity<String>("Not found", HttpStatus.NOT_FOUND);
		}
		return responseEntity;	
	}
	

}
