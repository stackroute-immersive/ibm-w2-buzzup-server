package com.stackroute.buzzup.recommendationservice.services;

import java.util.List;

import com.stackroute.buzzup.kafka.model.InputUser;



public interface UserService {

	public void getUserNode(InputUser user);

}
