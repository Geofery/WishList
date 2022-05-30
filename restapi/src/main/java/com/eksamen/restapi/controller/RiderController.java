package com.eksamen.restapi.controller;

import com.eksamen.restapi.model.Rider;
import com.eksamen.restapi.service.RiderService;
import com.eksamen.restapi.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author roed
 */

@RestController
@CrossOrigin
@RequestMapping("/riders")
public class RiderController {

  @Autowired
  RiderService riderService;

  @Autowired
  TeamService teamService;

  @GetMapping()
  public List<Rider> getRiders(){
    return riderService.getRiders();
  }

  @GetMapping("/{riderId}")
  public Rider findRider(@PathVariable int riderId){
    return riderService.findRider(riderId);
  }

  @PostMapping("{teamId}")
  public Rider createRider(@PathVariable int teamId, @RequestBody Rider rider){
    rider.setTeam(teamService.findTeam(teamId));
    return riderService.createRider(rider);
  }

  //Måske ResponseEntity???
  @PutMapping("/{riderId}")
  public Rider updateRider(@PathVariable int riderId, @RequestBody Rider rider){
    rider.setRiderId(riderId);
    return riderService.updateRider(rider);
  }

  @DeleteMapping("/riderId")
  public Rider deleteRider(@PathVariable int riderId){
    return riderService.deleteRider(riderId);
  }

  @GetMapping("/yellowShirt")
  public Rider getYellowShirt(){
    return riderService.getYellowShirt();
  }

  @GetMapping("/whiteShirt")
  public Rider getWhiteShirt(){
    return riderService.getWhiteShirt();
  }

  @GetMapping("/greenShirt")
  public Rider getGreenShirt(){
    return riderService.getGreenShirt();
  }

  @GetMapping("/dottedShirt")
  public Rider getDottedShirt(){
    return riderService.getDottedShirt();
  }


}
