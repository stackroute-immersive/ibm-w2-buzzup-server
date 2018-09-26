package com.stackroute.buzzup.repository.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.buzzup.model.User;
import com.stackroute.buzzup.repository.UserRepository;

import java.util.NoSuchElementException;

@RunWith(SpringRunner.class)
@DataMongoTest

public class UserRepositoryTest {


    @Autowired
    private UserRepository userRepository;
    private User user;


    @Before
    public void setUp() throws Exception {
        user = new User();
        user.setEmailId("jhonsimon@gmail.com");
        user.setUserName("Jhon Simon");
        user.setPassword("123456");
    }

    @After
    public void tearDown() throws Exception {

        userRepository.deleteAll();

    }

    @Test
    public void registerUserTest() {

        userRepository.insert(user);
        User fetcheduser = userRepository.findById("jhonsimon@gmail.com").get();
        //System.out.println(fetcheduser.getUserMailId());
        Assert.assertEquals(user.getEmailId(), fetcheduser.getEmailId());

    }

    @Test(expected = NoSuchElementException.class)
    public void deleteUserTest() {
        userRepository.insert(user);
        User fetcheduser = userRepository.findById("jhonsimon@gmail.com").get();
        Assert.assertEquals("jhonsimon@gmail.com", fetcheduser.getEmailId());
        userRepository.delete(fetcheduser);
        fetcheduser = userRepository.findById("jhonsimon@gmail.com").get();

    }

    @Test
    public void updateUserTest() {
        userRepository.insert(user);
        User fetcheduser = userRepository.findById("jhonsimon@gmail.com").get();
        fetcheduser.setUserName("Jhon Simon Miguel");
        userRepository.save(fetcheduser);
        fetcheduser = userRepository.findById("jhonsimon@gmail.com").get();
        Assert.assertEquals("Jhon Simon Miguel", fetcheduser.getUserName());
    }

    @Test
    public void getUserByIdTest() {
        userRepository.insert(user);
        User fetcheduser = userRepository.findById("jhonsimon@gmail.com").get();
        Assert.assertEquals(user.getEmailId(),fetcheduser.getEmailId());

    }

}
