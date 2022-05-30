package com.eksamen.restapi.repository;

import com.eksamen.restapi.model.Rider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author roed
 */
public interface RiderRepository extends JpaRepository<Rider, Integer> {

  @Query(
      value =
          "select * from rider where time_seconds order by time_seconds asc limit 1",
      nativeQuery = true)
  Rider getYellowShirt();

  @Query(
      value =
          "select * from rider where age< 26 and time_seconds order by time_seconds asc limit 1;",
      nativeQuery = true)
  Rider getWhiteShirt();

  @Query(
      value =
          "select * from rider where sprint_points order by sprint_points desc limit 1;",
      nativeQuery = true)
  Rider getGreenShirt();

  @Query(
      value =
          "select * from rider where mountain_points order by mountain_points desc limit 1;",
      nativeQuery = true)
  Rider getDottedShirt();

}
