package Data.DataMapper;

import Data.Repositories.DBManager;
import Domain.Models.User;
import Domain.Services.ExceptionService;
import org.springframework.stereotype.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author roed
 */
@Controller
public class SQLUsers {
    Connection connection;
    PreparedStatement ps;
    boolean bol;
    ResultSet rs;
    ArrayList<User> users = new ArrayList<>();


    public void query(String sqlCommand) {
      try {
        connection = DBManager.getConnection();
        ps = connection.prepareStatement(sqlCommand);
        bol = ps.execute();
      } catch (SQLException ex) {
        System.out.println(ex.getMessage());
      }
    }

    public ResultSet load(String sqlCommand) throws ExceptionService {
      try {
        connection = DBManager.getConnection();
        ps = connection.prepareStatement(sqlCommand);
        rs = ps.executeQuery();
      } catch (SQLException ex) { throw new ExceptionService(ex.getMessage());

      }
      return rs;
    }

    public ArrayList<User> getResults(ResultSet rs) {
      try {
        users.clear();
        while (rs.next()) {
          users.add(new User());
        }
      } catch (SQLException ex) {
        System.out.println(ex.getMessage());
      }
      return users;
    }
}
