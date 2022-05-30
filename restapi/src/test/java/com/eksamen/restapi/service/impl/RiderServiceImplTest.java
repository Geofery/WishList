package com.eksamen.restapi.service.impl;

import com.eksamen.restapi.model.Rider;
import com.eksamen.restapi.service.RiderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author roed
 */
@SpringBootTest
class RiderServiceImplTest {
  @Autowired
  RiderService riderService;


  @Test
  void getRiders() {
    //Arrange
    List<Rider> riders;
    //Act
    riders = riderService.getRiders();

    //Assert
    Assertions.assertNotEquals(riders.size(), 0);

  }

  @Test
  void findRider() {
    //Arrange
    Rider rider = new Rider();
    rider.setName("test");
    rider.setNationality("Denmark");

    //Act
    Rider riderDB = riderService.createRider(rider);

    //Assert
    Assertions.assertEquals(riderDB.getName(), riderService.findRider(riderDB.getRiderId()).getName());

    //Teardown
    riderService.deleteRider(riderDB.getRiderId());


  }

  @Test
  void createRider() {
    //Arrange
    Rider rider = new Rider();
    rider.setName("test");
    rider.setNationality("Denmark");

    //Act
    Rider riderDB = riderService.createRider(rider);

    //Assert
    Assertions.assertEquals(riderDB, rider);

    //Teardown
    riderService.deleteRider(rider.getRiderId());
  }

  @Test
  void updateRider() {
  }
}