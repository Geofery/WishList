package com.eksamen.restapi.service;

import com.eksamen.restapi.model.Team;

import java.util.List;

/**
 * @author roed
 */
public interface TeamService {
  List<Team> getTeams();

  Team createTeam(Team team);

  Team findTeam(int teamId);
}
