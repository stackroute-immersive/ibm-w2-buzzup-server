package com.stackroute.buzzup.recommendationservice.services;

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
import com.stackroute.buzzup.recommendationservice.repositories.CityRepository;
import com.stackroute.buzzup.recommendationservice.repositories.GenreRepository;
import com.stackroute.buzzup.recommendationservice.repositories.LanguageRepository;
import com.stackroute.buzzup.recommendationservice.repositories.UserRepository;


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
	@KafkaListener(topics = "details11", groupId = "user")
	public void getUserNode(InputUser user) {
		System.out.println("entering getnode");
		User userObj = new User();
		System.out.println("hello1");
		userObj.setName(user.getUserName());
		userObj.setEmailId(user.getEmailId());
		System.out.println("hello2");
		userObj.setDateOfBirth(user.getAge());
		City city = new City(user.getCity());
		System.out.println("hello3");
		userObj.setCity(city);
		List<Genre> genres = new ArrayList<Genre>();
		System.out.println("hello4");
		List<Language> languages = new ArrayList<Language>();
		System.out.println("hello5");
		for(String s:user.getMovieGenre()) {
			System.out.println("hello6");
		Genre genre=new Genre(s);
		genres.add(genre);
		System.out.println(genres);
		userObj.setGenres(genres);
		
		}
		for(String s:user.getPrefLang()) {
			System.out.println("hello7");
			Language lang=new Language(s);
			languages.add(lang);
			userObj.setLanguages(languages);
			}
		System.out.println(userObj);
		userRepository.save(userObj);
		
	}
}


