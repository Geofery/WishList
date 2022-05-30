package com.eksamen.restapi.service.impl;

import com.eksamen.restapi.model.Rider;
import com.eksamen.restapi.repository.RiderRepository;
import com.eksamen.restapi.repository.TeamRepository;
import com.eksamen.restapi.service.RiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author roed
 */
@Service
public class RiderServiceImpl implements RiderService {

  @Autowired
  RiderRepository riderRepository;

  @Autowired
  TeamRepository teamRepository;

  @Override
  public List<Rider> getRiders() {
    return riderRepository.findAll();
  }

  @Override
  public Rider findRider(int riderId) {
    return riderRepository.findById(riderId).orElse(null);
  }

  @Override
  public Rider createRider(Rider rider) {
    return riderRepository.save(rider);
  }

  @Override
  public Rider updateRider(Rider rider) {
    Optional<Rider> existingRider = riderRepository.findById(rider.getRiderId());
    if (existingRider.isPresent()){
      return riderRepository.save(rider);
    }
    return null;
  }

  //ResponseEntity
  @Override
  public Rider deleteRider(int riderId) {
    try {
      Optional<Rider> riderDB = riderRepository.findById(riderId);
      if (riderDB.isPresent()){
        riderRepository.delete(riderDB.get());
        return riderDB.get();
      }
    }catch (Exception err){
      return null;
    }
    return null;
  }

  @Override
  public Rider getYellowShirt() {
    return riderRepository.getYellowShirt();
  }

  @Override
  public Rider getWhiteShirt() {
    return riderRepository.getWhiteShirt();
  }

  @Override
  public Rider getGreenShirt() {
    return riderRepository.getGreenShirt();
  }

  @Override
  public Rider getDottedShirt() {
    return riderRepository.getDottedShirt();
  }
}
