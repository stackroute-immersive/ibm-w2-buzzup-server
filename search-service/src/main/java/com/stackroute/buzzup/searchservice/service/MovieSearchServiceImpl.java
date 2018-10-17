package com.stackroute.buzzup.searchservice.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.stackroute.buzzup.kafka.domain.MovieSchedule;
import com.stackroute.buzzup.searchservice.model.City;
import com.stackroute.buzzup.searchservice.model.Movie;
import com.stackroute.buzzup.searchservice.model.Theatre;
import com.stackroute.buzzup.searchservice.repository.CityRepository;
import com.stackroute.buzzup.searchservice.repository.MovieRepository;

/*
 * Annotate the class with @Service annotation which contains additional business logic to be 
 * implemented. 
 */

@Service
public class MovieSearchServiceImpl implements MovieSearchService {

	private MovieRepository movieRepository;
	private CityRepository cityRepository;

	/*
	 * We use Constructor-based Autowiring for SearchService class. (No use of new
	 * keyword for creating an object)
	 */

	@Autowired
	public MovieSearchServiceImpl(MovieRepository movieRepository, CityRepository cityrepository) {
		this.movieRepository = movieRepository;
		this.cityRepository = cityrepository;
	}

	/*
	 * This method is used to save a new city.
	 */

	@Override
	public String saveCity(City city) {
		cityRepository.save(city);
		List<Movie> movies = convertcitytomovie(city);

		for (Iterator<Movie> iterator = movies.iterator(); iterator.hasNext();) {
			Movie movie = (Movie) iterator.next();
			movieRepository.save(movie);
		}

		return "saved";

	}

	/*
	 * This method is used to fetch all the movie details for a particular city.
	 */

	private List<Movie> convertcitytomovie(City city) {
		List<Movie> movies = city.getMovieList();
		return movies;
	}

	/*
	 * This method should be used to get movie by city by calling the corresponding
	 * method of repository interface.
	 */

	@Override
	public City getByCity(String city) {
		City list = cityRepository.getBycityName(city);
		return list;

	}

	/*
	 * This method should be used to get movie by movieName by calling the
	 * corresponding method of repository interface.
	 */

	@Override
	public List<Movie> getByTitle(String movieName) {

		List<Movie> list = movieRepository.getBymovieName(movieName);
		return list;

	}

	@Override
	@KafkaListener(topics = "screening-details", groupId = "search", containerFactory = "kafkaListenerContainerFactory")
	public void consumeKafka(MovieSchedule movieschedule) {

		boolean flag = false;
		int i;
		int k = 0;
		City cities;
		Movie movie;
		Movie tempMovie;
		List<Movie> movies = new ArrayList<Movie>();
		List<Theatre> theaters = new ArrayList<Theatre>();
		List<Theatre> newtheater;
		Theatre theater;
		Theatre theatre1;
		String cityname = movieschedule.getTheatreCity();
		if (cityRepository.findBycityName(cityname) != null) {
			cities = cityRepository.findBycityName(cityname);
			movies = cities.getMovieList();
			Iterator<Movie> iterator = movies.iterator();
			i = 0;
			while (iterator.hasNext()) {
				movie = iterator.next();
				i++;
				if (movie.getMovieName().equals(movieschedule.getMovieName())) {
					flag = true;
					k = i;
					break;
				} else {
					flag = false;
				}
			}
			if (flag) {
				movie = movies.get(k - 1);
				theaters = movie.getTheatres();
				Iterator<Theatre> iterator1 = theaters.iterator();
				while (iterator1.hasNext()) {
					theater = iterator1.next();

					if (theater.getTheatreName().equals(movieschedule.getTheatreName())) {

					} else {
						theatre1 = new Theatre();
						theatre1.setTheatreId(movieschedule.getTheatreId());
						theatre1.setTheatreName(movieschedule.getTheatreName());
						theatre1.setTheatreLocation(movieschedule.getTheatreLocation());
						theatre1.setSeatLayout(movieschedule.getSeatLayout());
						theatre1.setShowNumbers(movieschedule.getShowNumbers());
						String show = movieschedule.getShowTimings().trim();
						String[] showtiming = show.split(",");
						theatre1.setShowTimings(showtiming);
						theatre1.setWeekdaysPrice(movieschedule.getWeekendsPrice());
						theatre1.setWeekdaysPrice(movieschedule.getWeekdaysPrice());
						theatre1.setTypesOfSeats(movieschedule.getTypesOfSeats());
						theatre1.setNumberOfSeats(movieschedule.getNumberOfSeats());
						theaters.add(theatre1);
						cityRepository.save(cities);
						movieRepository.save(movie);
					}
				}
			} else {
				theatre1 = new Theatre();
				theatre1 = new Theatre();
				theatre1.setTheatreId(movieschedule.getTheatreId());
				theatre1.setTheatreName(movieschedule.getTheatreName());
				theatre1.setTheatreLocation(movieschedule.getTheatreLocation());
				theatre1.setSeatLayout(movieschedule.getSeatLayout());
				theatre1.setShowNumbers(movieschedule.getShowNumbers());
				String show = movieschedule.getShowTimings().trim();
				String[] showtiming = show.split(",");
				theatre1.setShowTimings(showtiming);
				theatre1.setWeekendsPrice(movieschedule.getWeekendsPrice());
				theatre1.setWeekdaysPrice(movieschedule.getWeekdaysPrice());
				theatre1.setTypesOfSeats(movieschedule.getTypesOfSeats());
				theatre1.setNumberOfSeats(movieschedule.getNumberOfSeats());
				newtheater = new ArrayList<Theatre>();
				newtheater.add(theatre1);
				tempMovie = new Movie(movieschedule.getId(), movieschedule.getMovieName(),
						movieschedule.getMoviePoster(), movieschedule.getSynopsis(),
						movieschedule.getMovieReleaseDate(), movieschedule.getMovieDuration(),
						movieschedule.getLanguages(), movieschedule.getMovieGenres(), movieschedule.getFormat(),
						movieschedule.getActors(), movieschedule.getActress(), movieschedule.getDirectors(),
						newtheater);
				movies.add(tempMovie);
				cityRepository.save(cities);
				movieRepository.save(tempMovie);
			}
		} else {
			theater = new Theatre();
			theater.setTheatreId(movieschedule.getTheatreId());
			theater.setTheatreName(movieschedule.getTheatreName());
			theater.setTheatreLocation(movieschedule.getTheatreLocation());
			theater.setSeatLayout(movieschedule.getSeatLayout());
			theater.setShowNumbers(movieschedule.getShowNumbers());
			String show = movieschedule.getShowTimings().trim();
			String[] showtiming = show.split(",");
			theater.setShowTimings(showtiming);
			theater.setWeekendsPrice(movieschedule.getWeekendsPrice());
			theater.setWeekdaysPrice(movieschedule.getWeekdaysPrice());
			theater.setTypesOfSeats(movieschedule.getTypesOfSeats());
			theater.setNumberOfSeats(movieschedule.getNumberOfSeats());
			theaters = new ArrayList<Theatre>();
			theaters.add(theater);
			movie = new Movie(movieschedule.getId(), movieschedule.getMovieName(), movieschedule.getMoviePoster(),
					movieschedule.getSynopsis(), movieschedule.getMovieReleaseDate(), movieschedule.getMovieDuration(),
					movieschedule.getLanguages(), movieschedule.getMovieGenres(), movieschedule.getFormat(),
					movieschedule.getActors(), movieschedule.getActress(), movieschedule.getDirectors(), theaters);
			movies = new ArrayList<>();
			movies.add(movie);
			cities = new City(cityname, movies);
			cityRepository.save(cities);
			movieRepository.save(movie);
		}

	}
}
