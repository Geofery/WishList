package com.example.learningspring.controllers;

import com.example.learningspring.repository.DBManager;
import com.example.learningspring.repository.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author roed
 */
@Controller
public class MovieController {
  Connection connection;
  PreparedStatement ps;
  ResultSet rs;
  Movie tmp;
  String sqlCommand;
  ArrayList<Movie> movieList = new ArrayList<>();
  ArrayList<String> commands = new ArrayList<>();
  String movie;
  Statement s;

  
  public ResultSet query(String command) {
    try {
      connection = DBManager.getConnection();
      ps = connection.prepareStatement(command);
      rs = ps.executeQuery();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    return rs;
  }

  public void batch(ArrayList<String> commands) {
    try {
      connection = DBManager.getConnection();
      s = connection.createStatement();
      for (int i = 0; i < commands.size(); i++) {
        s.addBatch(commands.get(i));
      }
      s.executeBatch();
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
  }

  public ArrayList<Movie> getResults(ResultSet rs) {
    try {
      movieList.clear();
      while (rs.next()) {
        tmp = new Movie(
            rs.getInt(1),
            rs.getString(2),
            rs.getInt(3),
            rs.getInt(4),
            rs.getString(5),
            rs.getInt(6),
            rs.getString(7));
        movieList.add(tmp);
      }
    } catch (SQLException ex) {
      System.out.println(ex.getMessage());
    }
    return movieList;
  }

  public String arrayToString(ArrayList<Movie> movieList){
    movie = "";
    for (int i = 0; i < movieList.size(); i++) {
      movie += movieList.get(i);
    }
    return movie;
  }

  @GetMapping("/Check")
  @ResponseBody
  public String checkConnection() {
    connection = DBManager.getConnection();
    if (connection != null) {
      return "Connected";
    } else return "Not Connected";
  }

  //Finished
  @GetMapping("/")
  @ResponseBody
  public String welcome() {
    return "Hello and welcome to Imdb!";
  }

  @GetMapping("/First")
  @ResponseBody
  public String first() {
    sqlCommand = "Select * from movies where id = 1;";
    return arrayToString(getResults(query(sqlCommand)));
  }

  @GetMapping("/getRandom")
  @ResponseBody
  public String getRandom() {
    sqlCommand = "SELECT * FROM movies ORDER BY RAND() LIMIT 1;";
    return arrayToString(getResults(query(sqlCommand)));
  }

  @GetMapping("/topTen")
  @ResponseBody
  public String getTenSortByPopularity() {
    sqlCommand = "SELECT * FROM imdb.movies " +
        "ORDER BY rand() " +
        "LIMIT 10;";
    movie = "";
    movieList = getResults(query(sqlCommand));
    movieList.sort(Comparator.comparing(Movie::getPopularity));
    for (int i = 0; i < movieList.size(); i++) {
      movie += movieList.get(i);
    }
    return movie;
  }

  @GetMapping("/award")
  @ResponseBody
  public String whoWonAwards() {
    sqlCommand = "SELECT * FROM imdb.movies where awards = \"yes\";";
    return arrayToString(getResults(query(sqlCommand)));
  }

  @GetMapping("/awardCount")
  @ResponseBody
  public String howManyWonAwards() {
    try {
      sqlCommand = "SELECT count(*) FROM imdb.movies where awards = \"yes\";";
      rs = query(sqlCommand);
      movie = "";
      if (rs.next()) {
        movie = Integer.toString(rs.getInt(1));
      }
      return movie;
    } catch (SQLException ex) {
      return ex.getMessage();
    }
  }

  @GetMapping("/advance")
  @ResponseBody
  public String advance2() {
    sqlCommand = "select * from AwardedComedys;";
    movie = "";
    commands.clear();
    commands.add("Drop table if exists imdb.AwardedComedys;");
    commands.add("create table AwardedComedys(id int auto_increment primary key, title varchar(100), " +
        "year int, length int, subject varchar(50),popularity int, awards varchar(3));");
    commands.add("insert into imdb.AwardedComedys select id, title, year, length, subject, popularity, " +
        "awards from movies where subject = \"Comedy\" and awards = \"Yes\";");
    batch(commands);
   return arrayToString(getResults(query(sqlCommand)));
  }
}