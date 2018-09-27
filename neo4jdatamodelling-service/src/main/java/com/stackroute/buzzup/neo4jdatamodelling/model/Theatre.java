package com.stackroute.buzzup.neo4jdatamodelling.model;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Theatre {
	@Relationship(type= "screened_at", direction=Relationship.INCOMING)
	private long id;
	private String Name;
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Theatre(String name) {
		super();
		Name = name;
	}
}
