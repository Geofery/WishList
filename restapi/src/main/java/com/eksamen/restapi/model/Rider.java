package com.eksamen.restapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author roed
 */

@Entity
@Setter
@Getter
public class Rider {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "rider_id", nullable = false)
  private Integer riderId;

  private String name;

  private int age;

  private String nationality;

  private int mountainPoints;

  private int sprintPoints;

  @ManyToOne
  @JsonBackReference
  @JoinColumn(name = "team_id")
  private Team team;

  private int stage;

  private int timeSeconds;

}
