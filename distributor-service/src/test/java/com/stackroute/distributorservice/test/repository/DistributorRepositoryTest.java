package com.stackroute.distributorservice.test.repository;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.distributorservice.model.Distributor;
import com.stackroute.distributorservice.repository.DistributorRepository;

@RunWith(SpringRunner.class)
@DataMongoTest
public class DistributorRepositoryTest {

    @Autowired
    private DistributorRepository distributorRepository;
    private Distributor distributor;


    @Before
    public void setUp() throws Exception {
    	distributor = new Distributor();
    	distributor.setEmailId("Vignesh008");
    	distributor.setDistributorName("Vignesh");
    	distributor.setDistributorLocation("Bangalore");
    	
    }

    @After
    public void tearDown() throws Exception {

    	distributorRepository.deleteAll();

    }

    @Test
    public void registerDistributorTest() {

    	distributorRepository.insert(distributor);
    	Distributor fetchDistributor = distributorRepository.findById("Vignesh008").get();
        Assert.assertEquals(distributor.getEmailId(), fetchDistributor.getEmailId());

    }
/*
    @Test(expected = NoSuchElementException.class)
    public void deleteUserTest() {
    	distributorRepository.insert(distributor);
    	Distributor fetchDistributor = distributorRepository.findById("Vignesh008").get();
        Assert.assertEquals("Vignesh008", fetchDistributor.getDistributorId());
        distributorRepository.delete(fetchDistributor);
        fetchDistributor = distributorRepository.findById("Vignesh008").get();

    }*/

    @Test
    public void updateDistributorLocation() {
    	distributorRepository.insert(distributor);
    	Distributor fetchDistributor = distributorRepository.findById("Vignesh008").get();
        fetchDistributor.setDistributorLocation("Bangalore");
        distributorRepository.save(fetchDistributor);
        fetchDistributor = distributorRepository.findById("Vignesh008").get();
        Assert.assertEquals("Bangalore", fetchDistributor.getDistributorLocation());
    }

   /* @Test
    public void getUserByIdTest() {
    	distributorRepository.insert(distributor);
    	Distributor fetchDistributor = distributorRepository.findById("Vignesh008").get();
        Assert.assertEquals(distributor.getDistributorId(),fetchDistributor.getDistributorId());

    }*/
}
       