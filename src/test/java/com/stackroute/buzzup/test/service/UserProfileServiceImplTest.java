package com.stackroute.buzzup.test.service;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.stackroute.buzzup.exceptions.UserAlreadyExistsException;
import com.stackroute.buzzup.exceptions.UserNotFoundException;
import com.stackroute.buzzup.model.UserProfile;
import com.stackroute.buzzup.repository.UserProfileRepository;
import com.stackroute.buzzup.service.UserProfileServiceImpl;



public class UserProfileServiceImplTest {

    @Mock
    UserProfileRepository userRepository;


    UserProfile user;

    @InjectMocks
    UserProfileServiceImpl userService;

    List<UserProfile> userList = null;
    Optional<UserProfile> options;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        user = new UserProfile();
        String l[] = {"eng"};
        String g[] = {"horror"};
        String c[] = {"comedy"};
        user.setUserId("04");
        user.setUserEmail("shshri31@in.ibm.com");
        user.setUserPassword("root123");
        user.setUserMobile("9898989898");
        user.setUserName("shweta");
        user.setUserGender("female");
        user.setAge("18");
        user.setCity("hyd");
        user.setFburl("fb.com");
        user.setTwitterurl("twttr.com");
        user.setPrefLang(l);
        user.setMovieGenre(g); 
        user.setEventCategory(c);
        options = Optional.of(user);

    }

    @Test
    public void registerUserSuccess() throws UserAlreadyExistsException {
        when(userRepository.insert((UserProfile) any())).thenReturn(user);
        UserProfile userSaved = userService.registerUser(user);
        assertEquals(user, userSaved);

    }

    @Test(expected = UserAlreadyExistsException.class       )
    public void registerUserFailure() throws UserAlreadyExistsException {
        when(userRepository.insert((UserProfile) any())).thenReturn(null);
        UserProfile userSaved = userService.registerUser(user);
        assertEquals(user, userSaved);

    }

    @Test
    public void updateUser() throws UserNotFoundException {
        when(userRepository.findById(user.getUserId())).thenReturn(options);
        user.setUserMobile("1234567789");
        UserProfile fetchuser = userService.updateUser(user.getUserId(), user);
        assertEquals(user, fetchuser);

    }

    @Test
    public void deleteUserSuccess() throws UserNotFoundException {
        when(userRepository.findById(user.getUserId())).thenReturn(options);
        boolean flag = userService.deleteUser(user.getUserId());
        assertEquals(true, flag);

    }

    @Test
    public void getUserById() throws UserNotFoundException {

        when(userRepository.findById(user.getUserId())).thenReturn(options);

        UserProfile fetchedUser = userService.getUserById(user.getUserId());

        assertEquals(user, fetchedUser);

    }


}