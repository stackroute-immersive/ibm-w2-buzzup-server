package com.stackroute.buzzup.recommendationservice.services;

import com.stackroute.buzzup.recommendationservice.model.Genre;

public interface GenreService {
	public Genre findByName(String genreName);

	
}
