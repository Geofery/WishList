package com.example.learningspring.repository;

/**
 * @author roed
 */
public class Movie {
  int id;
  String title;
  int year;
  int length;
  String subject;
  int popularity;
  String awards;

  public Movie(int id, String title, int year, int length, String subject, int popularity, String awards) {
    this.id = id;
    this.title = title;
    this.year = year;
    this.length = length;
    this.subject = subject;
    this.popularity = popularity;
    this.awards = awards;
  }

  @Override
  public String toString() {
    return "<h1 style=\"text-align: center\"> Movie: " + title + "</h1>" +
        "<p style=\"text-align: center\">id: " + id +
        ", Year: " + year +
        ", Length: " + length +
        ", Subject: " + subject +
        ", Popularity: " + popularity +
        ", Awards: " + awards + "</p>";
  }

  public int getPopularity() {
    return popularity;
  }
}
