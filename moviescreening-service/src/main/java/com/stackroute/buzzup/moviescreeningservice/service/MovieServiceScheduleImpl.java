package com.stackroute.buzzup.moviescreeningservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.stackroute.buzzup.kafka.domain.MovieSchedule;
import com.stackroute.buzzup.kafka.domain.Theatre;
import com.stackroute.buzzup.moviescreeningservice.config.KafkaProducerConfig;
import com.stackroute.buzzup.moviescreeningservice.repository.MovieScheduleRepository;



@Service
public class MovieServiceScheduleImpl implements MovieScheduleService {

	private MovieScheduleRepository movieScheduleRepo;

	@Autowired
	public MovieServiceScheduleImpl(MovieScheduleRepository movieScheduleRepo) {

		this.movieScheduleRepo = movieScheduleRepo;
	}

	String topic = KafkaProducerConfig.getTopic();
	String topic1 = KafkaProducerConfig.getTopic1();
	String topic2 = KafkaProducerConfig.getTopic2();
	String topic4 = KafkaProducerConfig.getTopic3();

	@Autowired
	private KafkaTemplate<String, MovieSchedule> kafkaTemplate;


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
		
		if (movieScheduleRepo.getByEmail(email) != null) {

			MovieSchedule movie = movieScheduleRepo.getByEmail(email);
			System.out.println("" + email);
			System.out.println("" + movie.getTheatreName());
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
			movie.setWeekdays_Price(updateMovie.getWeekdays_Price());
			movie.setWeekends_Price(updateMovie.getWeekends_Price());
			System.out.println("" + movie.getTheatreName() + "" + movie.getShowNumbers());
			movieScheduleRepo.save(movie);
			kafkaTemplate.send(topic, movie);
			kafkaTemplate.send(topic1, movie);
			kafkaTemplate.send(topic2, movie);
			kafkaTemplate.send(topic4, movie);
		} else
			System.out.println("error");
		return updateMovie;
	}

	
	@Override
	@KafkaListener(topics = "theater-details", groupId = "grpid", containerFactory = "kafkaListenerContainerFactory")
	public void consumeKafka(Theatre theatre) {
		MovieSchedule addTheatre = new MovieSchedule();

		if (movieScheduleRepo.getByTheatreName(theatre.getTheatreName()) == null) {

			addTheatre.setEmail(theatre.getEmail());
			addTheatre.setTheatreName(theatre.getTheatreName());
			addTheatre.setTheatreLocation(theatre.getTheatreLocation());
			addTheatre.setTheatreId(theatre.getTheatreId());
			addTheatre.setTheatreCity(theatre.getTheatreCity());
			addTheatre.setTheatreLicenseNo(theatre.getTheatreLicenseNo());
			addTheatre.setSeatLayout(theatre.getSeatLayout());
			addTheatre.setTypesOfSeats(theatre.getTypesOfSeats());
			addTheatre.setNumberOfSeats(theatre.getNumberOfSeats());
			addTheatre.setScreenedmovies(theatre.getScreenedmovies());
			addTheatre.setRunningmovies(theatre.getRunningmovies());
			movieScheduleRepo.save(addTheatre);
		}

	}

}
