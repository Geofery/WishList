package com.eksamen.restapi.service;

import com.eksamen.restapi.model.Rider;

import java.util.List;

/**
 * @author roed
 */
public interface RiderService {
  List<Rider> getRiders();

  Rider findRider(int riderId);

  Rider createRider(Rider rider);

  Rider updateRider(Rider rider);

  Rider deleteRider(int riderId);

  Rider getYellowShirt();

  Rider getWhiteShirt();

  Rider getGreenShirt();

  Rider getDottedShirt();
}
