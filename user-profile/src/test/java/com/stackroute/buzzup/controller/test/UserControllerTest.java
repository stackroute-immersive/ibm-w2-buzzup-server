/*package com.stackroute.userprofile.controller.test;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.userprofile.UpstreamServiceApplication;
import com.stackroute.userprofile.controller.UserController;
import com.stackroute.userprofile.model.User;
import com.stackroute.userprofile.service.UserService;

import org.bson.json.JsonParseException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest
@ContextConfiguration(classes= {UpstreamServiceApplication.class})
public class UserControllerTest {


    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private User user;
    @MockBean
    private UserService userService;
    @InjectMocks
   private UserController userController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        user = new User();
        String l[] = {"eng"};
        String g[] = {"horror"};
        String c[] = {"comedy"};
        user.setUserMobile("9898989898");
        user.setEmailId("shshri31@in.ibm.com");
        user.setPassword("root123");
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

        when(userService.createUser(user)).thenReturn(true);
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
        user.setPassword("23456789");
        when(userService.updateUser(eq(user.getEmailId()), any())).thenReturn(user);
        mockMvc.perform(put("/api/v1/userprofile/shshri31@in.ibm.com")
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
        when(userService.deleteUser("shshri31@in.ibm.com")).thenReturn(true);
        mockMvc.perform(delete("/api/v1/userprofile/shshri31@in.ibm.com")
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

        when(userService.getUser("shshri31@in.ibm.com")).thenReturn(user);
        mockMvc.perform(get("/api/v1/userprofile/shshri31@in.ibm.com").contentType(MediaType.APPLICATION_JSON))
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
            throw new JsonParseException(e);
        }
    }
}
*/


package com.stackroute.buzzup.controller.test;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.buzzup.UserProfileApplication;
import com.stackroute.buzzup.controller.UserController;
import com.stackroute.buzzup.exceptions.UserAlreadyExistsException;
import com.stackroute.buzzup.exceptions.UserNotFoundException;
import com.stackroute.buzzup.model.User;
import com.stackroute.buzzup.service.UserService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest
@ContextConfiguration(classes= {UserProfileApplication.class})
public class UserControllerTest {

	

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private User user;
    @MockBean
    private UserService userService;
    @InjectMocks
    private UserController userController;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        user = new User();
        user.setUserName("Jhon Simon");
        user.setPassword("123456");
        user.setEmailId("jhonsimon@gmail.com");
    }

       /* @Test
        public void registerUserSuccess() throws Exception {

            when(userService.createUser(user)).thenReturn(true);
          //  assertNotNull(userService.getUser("Jhon Simon"));
            mockMvc.perform(post("/api/v1/user")
                    .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
                    .andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());

        }*/

        @Test
        public void registerUserFailure() throws Exception {

            when(userService.createUser(any())).thenThrow(UserAlreadyExistsException.class);
          //  assertNotNull(userService.getUser("Jhon Simon"));
            mockMvc.perform(post("/api/v1/user")
                    .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
                    .andExpect(status().isConflict()).andDo(MockMvcResultHandlers.print());

        }
        @Test
        public void updateUserSuccess() throws Exception {
            user.setPassword("23456789");
          //  assertNotNull(userService.getUser("Jhon Simon"));
            when(userService.updateUser(eq(user.getEmailId()), any())).thenReturn(user);
            mockMvc.perform(put("/api/v1/user/Jhon123")
                    .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
                    .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());

        }

        @Test
        public void updateUserFailure() throws Exception {
                user.setPassword("23456789");
              //  assertNotNull(userService.getUser("Jhon Simon"));
                when(userService.updateUser(eq(user.getEmailId()), any())).thenThrow(UserNotFoundException.class);
                mockMvc.perform(put("/api/v1/user/Jhon123")
                        .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user)))
                        .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());

        }
        @Test
        public void deleteUserSuccess() throws Exception {
            when(userService.deleteUser("Jhon123")).thenReturn(true);
            //assertNotNull(userService.getUser("Jhon Simon"));
            mockMvc.perform(delete("/api/v1/user/Jhon123")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(MockMvcResultHandlers.print());

        }


        @Test
        public void deleteUserFailure() throws Exception {
            when(userService.deleteUser("Jhon123")).thenThrow(UserNotFoundException.class);
//            assertNotNull(userService.getUser("Jhon Simon"));
            mockMvc.perform(delete("/api/v1/user/Jhon123")
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isNotFound())
                    .andDo(MockMvcResultHandlers.print());

        }
        @Test
        public void getByUserIdSuccess() throws Exception {

            when(userService.getUser("Jhon123")).thenReturn(user);
           // assertNotNull(userService.getUser("Jhon Simon"));
            mockMvc.perform(get("/api/v1/user/Jhon123").contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andDo(MockMvcResultHandlers.print());
        }

        @Test
        public void getByUserIdFAilure() throws Exception {

            when(userService.getUser("Jhon123")).thenThrow(UserNotFoundException.class);
         //   assertNotNull(userService.getUser("Jhon Simon"));
            mockMvc.perform(get("/api/v1/user/Jhon123").contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isNotFound())
                    .andDo(MockMvcResultHandlers.print());
        }


        public static String asJsonString(final Object obj) {
            try {
                return new ObjectMapper().writeValueAsString(obj);
            } catch (Exception e) {
            	return e.getMessage();
            }
        }

}
