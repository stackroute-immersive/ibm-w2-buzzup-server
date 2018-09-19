package com.stackroute.buzzup.test.repository;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.buzzup.model.UserProfile;
import com.stackroute.buzzup.repository.UserProfileRepository;
import java.util.NoSuchElementException;

@RunWith(SpringRunner.class)
@DataMongoTest
public class UserProfileRepositoryTest {

    @Autowired
    private UserProfileRepository userRepository;
    private UserProfile user;


    @Before
    public void setUp() throws Exception {
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

    @After
    public void tearDown() throws Exception {
    	userRepository.deleteAll();
    }

    @Test
    public void registerUserTest() {

        userRepository.insert(user);
        UserProfile fetcheduser = userRepository.findById("04").get();
        Assert.assertEquals(user.getUserId(), fetcheduser.getUserId());

    }

    @Test(expected = NoSuchElementException.class)
    public void deleteUserTest() {
        userRepository.insert(user);
        UserProfile fetcheduser = userRepository.findById("03").get();
        Assert.assertEquals("03", fetcheduser.getUserId());
        userRepository.delete(fetcheduser);
        fetcheduser = userRepository.findById("03").get();

    }

    @Test
    public void updateUserTest() {
        userRepository.insert(user);
        UserProfile fetcheduser = userRepository.findById("04").get();
        fetcheduser.setUserPassword("987654321");
        userRepository.save(fetcheduser);
        fetcheduser = userRepository.findById("04").get();
        Assert.assertEquals("987654321", fetcheduser.getUserPassword());
    }

    @Test
    public void getUserByIdTest() {
        userRepository.insert(user);
        UserProfile fetcheduser = userRepository.findById("04").get();
        Assert.assertEquals(user.getUserId(),fetcheduser.getUserId());

    }
}
