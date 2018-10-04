package com.stackroute.buzzup.neo4jdatamodelling.model;



import org.neo4j.ogm.annotation.NodeEntity;


@NodeEntity
public class Genre {
	
	private String Name;
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Genre(String name) {
		super();
		Name = name;
	}

}
