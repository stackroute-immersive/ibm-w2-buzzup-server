package com.stackroute.buzzup.repository.test;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.buzzup.model.User;
import com.stackroute.buzzup.repository.UserAuthenticationRepository;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@SpringBootTest
@DataJpaTest
public class UserAuthenticationRepositoryTest
{

        @Autowired
        private UserAuthenticationRepository authenticateRepository;
        private User user;


        @Before
        public void setUp() throws Exception {
            user = new User();
            user.setEmailId("Johan@gmail.com");
            user.setPassword("1234");
            user.setUserRole("employee");
        }

        @After
        public void tearDown() throws Exception {

            authenticateRepository=null;

        }
        @Test

        public void registerUserTest() {

            authenticateRepository.save(user);
            User fetcheduser = authenticateRepository.findById("Johan@gmail.com").get();
            Assert.assertEquals(user.getEmailId(), fetcheduser.getEmailId());

        }

        @Test
        public void findByMailidAndPasswordTest() {
            authenticateRepository.save(user);
            User fetcheduser = authenticateRepository.findById("Johan@gmail.com").get();
            Assert.assertEquals(user.getEmailId(),fetcheduser.getEmailId());

        }

}