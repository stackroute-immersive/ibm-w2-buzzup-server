package com.stackroute.buzzup.service.test;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.stackroute.buzzup.exceptions.UserAlreadyExistsException;
import com.stackroute.buzzup.exceptions.UserNotFoundException;
import com.stackroute.buzzup.model.User;
import com.stackroute.buzzup.repository.UserRepository;
import com.stackroute.buzzup.service.UserServiceImpl;

public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;


    private User user;

    @InjectMocks
    private UserServiceImpl userService;

    private Optional<User> options;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        user = new User();
        user.setEmailId("jhonsimon@gmail.com");
        user.setUserName("john");
        user.setPassword("johnpass");

        options = Optional.of(user);

    }

    @Test
    public void registerUserSuccess() throws UserAlreadyExistsException {
        when(userRepository.insert((User) any())).thenReturn(user);
        boolean userSaved = userService.createUser(user);
        assertEquals(true, userSaved);

    }

    @Test(expected = UserAlreadyExistsException.class       )
    public void registerUserFailure() throws UserAlreadyExistsException {
        when(userRepository.insert((User) any())).thenReturn(null);
        boolean userSaved = userService.createUser(user);
        assertEquals(user, userSaved);

    }

    @Test
    public void updateUser() throws UserNotFoundException {
        when(userRepository.findById(user.getEmailId())).thenReturn(options);
        User fetchuser = userService.updateUser(user.getEmailId(), user);
        assertEquals(user, fetchuser);

    }

    @Test
    public void deleteUserSuccess() throws UserNotFoundException {
        when(userRepository.findById(user.getEmailId())).thenReturn(options);
        boolean flag = userService.deleteUser(user.getEmailId());
        assertEquals(true, flag);

    }

    @Test
    public void getUserById() throws UserNotFoundException {

        when(userRepository.findById(user.getEmailId())).thenReturn(options);

        User fetchedUser = userService.getUser(user.getEmailId());

        assertEquals(user, fetchedUser);

    }



}
