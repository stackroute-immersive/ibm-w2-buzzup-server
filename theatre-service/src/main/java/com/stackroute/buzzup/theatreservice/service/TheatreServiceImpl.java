package com.stackroute.buzzup.theatreservice.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.buzzup.theatreservice.exception.TheatreAlreadyExistsException;
import com.stackroute.buzzup.theatreservice.exception.TheatreNotFoundException;
import com.stackroute.buzzup.theatreservice.model.*;
import com.stackroute.buzzup.theatreservice.repository.TheatreRepository;

/*
 * Service classes are used here to implement additional business logic/validation 
 * This class has to be annotated with @Service annotation.
 * @Service - It is a specialization of the component annotation. It doesn't currently 
 * provide any additional behavior over the @Component annotation, but it's a good idea 
 * to use @Service over @Component in service-layer classes because it specifies intent 
 * better. Additionally, tool support and additional behavior might rely on it in the 
 * future.
*/
@Service
public class TheatreServiceImpl implements TheatreService {
	private TheatreRepository theatreRepository;

	/*
	 * Autowiring should be implemented for the TheatreRepository. (Use
	 * Constructor-based autowiring) Please note that we should not create any
	 * object using the new keyword.
	 */
	@Autowired
	public TheatreServiceImpl(TheatreRepository theatreRepository) {
		this.theatreRepository = theatreRepository;
	}
	/*
	 * This method should be used to register a new theatre.Call the corresponding
	 * method of Repository interface.
	 */

	public Theatre registerTheatre(Theatre theatre) throws TheatreAlreadyExistsException {
		Theatre theatre1 = theatreRepository.insert(theatre);
		if (theatre1 == null) {
			throw new TheatreAlreadyExistsException("Unable to create new Theatre");
		}
		return theatre1;
	}

	/*
	 * This method should be used to delete an existing theatre.Call the
	 * corresponding method of Repository interface.
	 */
	public boolean deleteTheatre(String theaterId) throws TheatreNotFoundException {
		boolean status = false;
		Theatre fetchedTheatre = theatreRepository.findById(theaterId).get();
		if (fetchedTheatre == null) {
			throw new TheatreNotFoundException("Theatre with given name does not exists");

		} else {
			theatreRepository.delete(fetchedTheatre);
			status = true;
		}
		return status;
	}

	/*
	 * This method should be used to update a existing theatre.Call the
	 * corresponding method of Repository interface.
	 */
	public Theatre updateTheatre(String theaterId, Theatre theatre) throws TheatreNotFoundException {

		try {
			Theatre fecthedTheatre = theatreRepository.findById(theaterId).get();
			fecthedTheatre.setEmailId(theatre.getEmailId());
			fecthedTheatre.setTheaterId(theatre.getTheaterId());
			fecthedTheatre.setTheaterName(theatre.getTheaterName());
			fecthedTheatre.setTheaterCity(theatre.getTheaterCity());
			fecthedTheatre.setTheaterAddress(theatre.getTheaterAddress());
			fecthedTheatre.setTheaterCategory(theatre.getTheaterCategory());
			fecthedTheatre.setNoOfSeats(theatre.getNoOfSeats());
			fecthedTheatre.setNoOfScreen(theatre.getNoOfScreen());

			theatreRepository.save(fecthedTheatre);
			return fecthedTheatre;

		} catch (NoSuchElementException exception) {

			throw new TheatreNotFoundException("Theatre does not exists");
		}
	}

	/*
	 * This method should be used to get a theatre by Id.Call the corresponding
	 * method of Respository interface.
	 */
	public Theatre getTheatreByemailId(String emailId) throws TheatreNotFoundException {

		Theatre fetchedTheatre = theatreRepository.findById(emailId).get();
		if (fetchedTheatre != null)
			return fetchedTheatre;
		else
			throw new TheatreNotFoundException("Theatre does not exists");
	}

	/*
	 * This method should be used to get a theatre by city.Call the corresponding
	 * method of Respository interface.
	 */
	/*
	 * public Theatre getTheatreByCity(String city) throws TheatreNotFoundException
	 * {
	 * 
	 * try { Theatre fetchedTheatre = theatreRepository.findById(city).get();
	 * 
	 * return fetchedTheatre; } catch (NoSuchElementException e) { throw new
	 * TheatreNotFoundException("Theatre does not exists"); }
	 */
}