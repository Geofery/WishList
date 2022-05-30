package com.eksamen.restapi.repository;


import com.eksamen.restapi.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author roed
 */
public interface TeamRepository extends JpaRepository<Team, Integer> {
}
