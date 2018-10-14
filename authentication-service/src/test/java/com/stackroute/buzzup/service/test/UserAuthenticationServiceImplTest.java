package com.stackroute.buzzup.service.test;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;




import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.stackroute.buzzup.exception.UserAlreadyExistsException;
import com.stackroute.buzzup.exception.UserNotFoundException;
import com.stackroute.buzzup.kafka.model.User;
import com.stackroute.buzzup.repository.UserAuthenticationRepository;
import com.stackroute.buzzup.service.UserAuthenticationServiceImpl;



public class UserAuthenticationServiceImplTest
{
    
        @Mock
       private UserAuthenticationRepository userRepository;
       private User user;

        @InjectMocks
        private UserAuthenticationServiceImpl authenticateService;

      

        @Before
        public void setUp() {
            MockitoAnnotations.initMocks(this);

            user = new User();
            user.setEmailId("Johan@gmail.com");
            user.setPassword("johnpass");
            user.setUserRole("employee");
            

        }

        @Test
        public void registerUserSuccess() throws UserAlreadyExistsException {
            when(userRepository.save((User) any())).thenReturn(user);
            boolean userSaved = authenticateService.saveUser(user);
            assertEquals(true, userSaved);

        }

        public void registerUserFailure() throws UserAlreadyExistsException{
            when(userRepository.save((User) any())).thenReturn(null);
            boolean userSaved = authenticateService.saveUser(user);
            assertEquals(false, userSaved);

        }


        @Test
        public void getUserByIdAndpassword() throws UserNotFoundException , UserAlreadyExistsException{

           
            when(userRepository.findByEmailIdAndPassword("Johan@gmail.com","johnpass")).thenReturn(user);
            boolean fetchedUser = authenticateService.saveUser(user);

            assertEquals(true, fetchedUser);

        }

}