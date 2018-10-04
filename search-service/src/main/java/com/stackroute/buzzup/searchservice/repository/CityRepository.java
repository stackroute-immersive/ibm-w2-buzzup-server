package com.stackroute.buzzup.searchservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.buzzup.searchservice.model.City;

@Repository
public interface CityRepository extends CrudRepository<City, String> {

	public City getBycityName(String city);

	public City findBycityName(String cityName);

}