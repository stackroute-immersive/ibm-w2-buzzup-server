package com.stackroute.buzzup.neo4jdatamodelling.exceptions;

public class NodeNotCreatedException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NodeNotCreatedException() {
        super("node could not be created");
    }
}
