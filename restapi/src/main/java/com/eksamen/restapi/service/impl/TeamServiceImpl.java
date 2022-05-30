package com.eksamen.restapi.service.impl;

import com.eksamen.restapi.model.Team;
import com.eksamen.restapi.repository.TeamRepository;
import com.eksamen.restapi.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author roed
 */

@Service
public class TeamServiceImpl implements TeamService {
  @Autowired
  TeamRepository teamRepository;


  @Override
  public List<Team> getTeams() {
    return teamRepository.findAll();
  }

  @Override
  public Team createTeam(Team team) {
    return teamRepository.save(team);
  }

  @Override
  public Team findTeam(int teamId) {
    return teamRepository.findById(teamId).orElse(null);
  }
}
