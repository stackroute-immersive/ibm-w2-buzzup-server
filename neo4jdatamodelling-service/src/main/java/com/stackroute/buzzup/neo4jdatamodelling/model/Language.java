package com.stackroute.buzzup.neo4jdatamodelling.model;

import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Language {
	private String lang;

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public Language(String lang) {
		super();
		this.lang = lang;
	}
	

}
