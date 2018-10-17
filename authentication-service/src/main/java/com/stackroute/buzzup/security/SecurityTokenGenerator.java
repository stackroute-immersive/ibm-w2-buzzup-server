package com.stackroute.buzzup.security;

import java.util.Map;

import com.stackroute.buzzup.kafka.model.User;

/* SecurityTokenGenerator is an interface which contains one abstract method called generateToken.
 * This method accepts an User object and returns a HashMap which will contain the JWTToken.
*/
@FunctionalInterface
public interface SecurityTokenGenerator {
Map<String, String> generateToken(User user);

}
