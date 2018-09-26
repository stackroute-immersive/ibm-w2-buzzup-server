package com.stackroute.buzzup.neo4jdatamodelling.model;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;



@NodeEntity
public class City {
	@Relationship(type= "located_at", direction=Relationship.INCOMING)
	private String Name;
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public City(String name) {
		super();
		Name = name;
	}
	
	
	
}
