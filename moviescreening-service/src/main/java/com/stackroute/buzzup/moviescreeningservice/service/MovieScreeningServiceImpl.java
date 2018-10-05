package com.stackroute.buzzup.moviescreeningservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.stackroute.buzzup.kafka.model.MovieSchedule;
import com.stackroute.buzzup.moviescreeningservice.config.KafkaProducerConfig;
import com.stackroute.buzzup.moviescreeningservice.repository.MovieScreeningRepository;


/*
 * This class implements the methods of the service interface
 * 
 */
@Service
public class MovieScreeningServiceImpl implements MovieScreeningService {

	private MovieScreeningRepository movieScheduleRepo;
	private String topic = KafkaProducerConfig.getTopic();
	private String topic1 = KafkaProducerConfig.getTopic1();
	private String topic2 = KafkaProducerConfig.getTopic2();
	private String topic4 = KafkaProducerConfig.getTopic3();
	
	@Autowired
	private KafkaTemplate<String, MovieSchedule> kafkaTemplate;

	@Autowired
	public MovieScreeningServiceImpl(MovieScreeningRepository movieScheduleRepo) {

		this.movieScheduleRepo = movieScheduleRepo;
	}

	@Override
	public MovieSchedule addMovieSchedule(MovieSchedule movieShow) {
		MovieSchedule addMovie = movieScheduleRepo.save(movieShow);
		kafkaTemplate.send(topic, movieShow);
		kafkaTemplate.send(topic1, movieShow);
		kafkaTemplate.send(topic2, movieShow);
		kafkaTemplate.send(topic4, movieShow);
		return addMovie;
	}

	@Override
	public List<MovieSchedule> getMoviesSchedule() {
		List<MovieSchedule> getMovies = (List<MovieSchedule>) movieScheduleRepo.findAll();
		return getMovies;

	}

	@Override
	public MovieSchedule updateMovieSchedule(String email, MovieSchedule updateMovie) {

		if (movieScheduleRepo.getByEmailId(email) != null) {

			MovieSchedule movie = movieScheduleRepo.getByEmailId(email);
			movie.setMovieName(updateMovie.getMovieName());
			movie.setId(updateMovie.getId());
			movie.setActors(updateMovie.getActors());
			movie.setActress(updateMovie.getActress());
			movie.setDirectors(updateMovie.getDirectors());
			movie.setLanguages(updateMovie.getLanguages());
			movie.setMovieDuration(updateMovie.getMovieDuration());
			movie.setMovieReleaseDate(updateMovie.getMovieReleaseDate());
			movie.setMoviePoster(updateMovie.getMoviePoster());
			movie.setMovieGenres(updateMovie.getMovieGenres());
			movie.setSynopsis(updateMovie.getSynopsis());
			movie.setFormat(updateMovie.getFormat());
			movie.setShowNumbers(updateMovie.getShowNumbers());
			movie.setShowTimings(updateMovie.getShowTimings());
			movie.setWeekdaysPrice(updateMovie.getWeekdaysPrice());

			movie.setWeekdaysPrice(updateMovie.getWeekdaysPrice());
			System.out.println("" + movie.getTheatreName() + "" + movie.getShowNumbers());
			movieScheduleRepo.save(movie);
			kafkaTemplate.send(topic, movie);
			kafkaTemplate.send(topic1, movie);
			kafkaTemplate.send(topic2, movie);
			kafkaTemplate.send(topic4, movie);
		} else
			System.out.println("Something went wrong");
		return updateMovie;
	}

}
