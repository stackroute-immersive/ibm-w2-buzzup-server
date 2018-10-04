package com.stackroute.buzzup.recommendationservice.service;

import com.stackroute.buzzup.recommendationservice.model.Genre;

public interface GenreService {
	public Genre findByName(String genreName);

	
}
