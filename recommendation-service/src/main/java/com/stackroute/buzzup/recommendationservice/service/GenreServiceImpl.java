package com.stackroute.buzzup.recommendationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.buzzup.recommendationservice.model.Genre;
import com.stackroute.buzzup.recommendationservice.repository.GenreRepository;

@Service
public class GenreServiceImpl implements GenreService {

	private GenreRepository genreRepository;

	@Autowired
	public GenreServiceImpl(GenreRepository genreRepository) {
		super();
		this.genreRepository = genreRepository;
	}

	@Override
	public Genre findByName(String name) {
		return genreRepository.findByName(name);
	}

}
