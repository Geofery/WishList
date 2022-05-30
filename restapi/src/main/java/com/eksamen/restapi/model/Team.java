package com.eksamen.restapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author roed
 */

@Entity
@Setter
@Getter
public class Team {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "team_id", nullable = false)
  private Integer teamId;

  private String name;

  @OneToMany
  @JoinColumn(name = "team_id")
  private List<Rider> riders;


}
