package com.stackroute.buzzup.recommendationservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.stackroute.buzzup.kafka.model.InputUser;
import com.stackroute.buzzup.recommendationservice.model.City;
import com.stackroute.buzzup.recommendationservice.model.Genre;
import com.stackroute.buzzup.recommendationservice.model.Language;
import com.stackroute.buzzup.recommendationservice.model.User;
import com.stackroute.buzzup.recommendationservice.repository.CityRepository;
import com.stackroute.buzzup.recommendationservice.repository.GenreRepository;
import com.stackroute.buzzup.recommendationservice.repository.LanguageRepository;
import com.stackroute.buzzup.recommendationservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	private GenreRepository genreRepository;
	private LanguageRepository languageRepository;
	private CityRepository cityRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository, GenreRepository genreRepository,
			LanguageRepository languageRepository, CityRepository cityRepository) {
		super();
		this.userRepository = userRepository;
		this.genreRepository = genreRepository;
		this.languageRepository = languageRepository;
		this.cityRepository = cityRepository;
	}

	@Override
	@KafkaListener(topics = "details10", groupId = "user")
	public void getUserNode(InputUser user) {

		User userObj = new User();
		userObj.setName(user.getUserName());
		userObj.setEmailId(user.getEmailId());
		userObj.setDateOfBirth(user.getDateOfBirth());
		City city = new City(user.getLocation());
		userObj.setCity(city);
		List<Genre> genres = new ArrayList<Genre>();
		List<Language> languages = new ArrayList<Language>();
		for (String s : user.getGenre()) {
			Genre genre = new Genre(s);
			genres.add(genre);
			userObj.setGenres(genres);

		}
		for (String s : user.getLanguagesKnown()) {
			Language lang = new Language(s);
			languages.add(lang);
			userObj.setLanguages(languages);
		}
		userRepository.save(userObj);

	}
}
