package com.stackroute.buzzup.test.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.buzzup.controller.UserProfileController;
import com.stackroute.buzzup.exceptions.UserAlreadyExistsException;
import com.stackroute.buzzup.exceptions.UserNotFoundException;
import com.stackroute.buzzup.model.UserProfile;
import com.stackroute.buzzup.service.UserProfileService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.any;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest
public class UserProfileControllerTest {


    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserProfile user;
    @MockBean
    UserProfileService userService;
    @InjectMocks
    UserProfileController userController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
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
        
    }

    @Test
    public void registerUserSuccess() throws Exception {

        when(userService.registerUser(user)).thenReturn(user);
        mockMvc.perform(post("/api/v1/userprofile")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
                .andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void registerUserFailure() throws Exception {

        when(userService.registerUser(any())).thenThrow(UserAlreadyExistsException.class);
        mockMvc.perform(post("/api/v1/userprofile")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
                .andExpect(status().isConflict()).andDo(MockMvcResultHandlers.print());

    }


    @Test
    public void updateUserSuccess() throws Exception {
        user.setUserPassword("23456789");
        when(userService.updateUser(eq(user.getUserId()), any())).thenReturn(user);
        mockMvc.perform(put("/api/v1/userprofile/09")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
                .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void updateUserFailure() throws Exception {
            user.setUserPassword("23456789");
            when(userService.updateUser(eq(user.getUserId()), any())).thenThrow(UserNotFoundException.class);
            mockMvc.perform(put("/api/v1/userprofile/09")
                    .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
                    .andExpect(status().isNotFound()).andDo(MockMvcResultHandlers.print());

    }

    @Test
    public void deleteUserSuccess() throws Exception {
        when(userService.deleteUser("09")).thenReturn(true);
        mockMvc.perform(delete("/api/v1/userprofile/09")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }


    @Test
    public void deleteUserFailure() throws Exception {
        when(userService.deleteUser("09")).thenThrow(UserNotFoundException.class);
        mockMvc.perform(delete("/api/v1/userprofile/09")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andDo(MockMvcResultHandlers.print());

    }


    @Test
    public void getByUserIdSuccess() throws Exception {

        when(userService.getUserById("09")).thenReturn(user);
        mockMvc.perform(get("/api/v1/userprofile/09").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void getByUserIdFAilure() throws Exception {

        when(userService.getUserById("09")).thenThrow(UserNotFoundException.class);
        mockMvc.perform(get("/api/v1/userprofile/09").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andDo(MockMvcResultHandlers.print());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}