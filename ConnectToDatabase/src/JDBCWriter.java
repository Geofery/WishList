import java.sql.*;
import java.util.ArrayList;

/**
 * @author roed
 */
public class JDBCWriter {
  private Connection connection;

  public boolean setConnection(UI ui) {
    final String url = "jdbc:mysql://localhost:3306/RSSFeed";
    boolean res = false;
    try {
     /* ui.displayGreen("Write user name: ");
      String userName = ui.getString();
      ui.displayGreen("Write password: ");
      String password = ui.getString();
      connection = DriverManager.getConnection(url, userName, password);*/
      connection = DriverManager.getConnection(url, "Roed", "Fvx7m47bvf4gepx");
      res = true;
    } catch (SQLException err) {
      System.out.println("Vi fik ikke conection err= " + err.getMessage());
    }
    //connection.close();
    return res;
  }

  public int countFeeds() {
    String str = "Select count(*) from feeds";
    //String str = "Select count(*) from" + tabel;
    PreparedStatement preparedStatement;
    int result = -1;
    try {
      preparedStatement = connection.prepareStatement(str);
      ResultSet resset = preparedStatement.executeQuery();
      if (resset.next()) {
        // String str2 = "" +resset.getObject(1);
        // result = Integer.parseInt(str2);
        result = resset.getInt(1);
      }
    } catch (SQLException err) {
      System.out.println("Fejl i count err= " + err.getMessage());
    }
    return result;
  }

  public int countTable(String table) {
    String str = "Select count(*) from" + table;
    PreparedStatement preparedStatement;
    int result = -1;
    try {
      preparedStatement = connection.prepareStatement(str);
      ResultSet resset = preparedStatement.executeQuery();
      if (resset.next()) {
        // String str2 = "" +resset.getObject(1);
        // result = Integer.parseInt(str2);
        result = resset.getInt(1);
      }
    } catch (SQLException err) {
      System.out.println("Fejl i count err= " + err.getMessage());
    }
    return result;
  }

  public int writeFeed(RSSUrl rssUrl, Feed feed) {
    String insstr = "Insert into feeds(feedid, title, link, description, language, copyright, pubDate) values (?, ?, ?, ?, ?, ?,?,?)";
    PreparedStatement preparedStatement;
    int rowCount = 0;

    try {
      preparedStatement = connection.prepareStatement(insstr);
      preparedStatement.setInt(1, rssUrl.getFeedId());
      preparedStatement.setString(2, rssUrl.getRssUrl());
      preparedStatement.setString(3, feed.getTitle());
      preparedStatement.setString(4, feed.getLink());
      preparedStatement.setString(5, feed.getDescription());
      preparedStatement.setString(6, feed.getLanguage());
      preparedStatement.setString(7, feed.getCopyright());
      preparedStatement.setString(8, feed.getPubDate());
      int ii = preparedStatement.executeUpdate();
      rowCount += ii;
    } catch (SQLException err) {
      System.out.println("Fejl i Insert feed err= " + err.getMessage());
    }
    return rowCount;
  }

  public int writeFeedMessages(RSSUrl rssUrl, FeedMessage feedMessage) {
    String insstr = "insert into feedmessages(feedid, title, description, guid, link, author) values (?, ?, ?, ?, ?, ?)";
    PreparedStatement preparedStatement;
    int rowCount = 0;

    try {
      preparedStatement = connection.prepareStatement(insstr);
      preparedStatement.setInt(1, rssUrl.getFeedId());
      preparedStatement.setString(2, feedMessage.guid);
      preparedStatement.setString(3, feedMessage.getTitle());
      preparedStatement.setString(4, feedMessage.getDescription());
      preparedStatement.setString(5, feedMessage.getLink());
      preparedStatement.setString(6, feedMessage.getAuthor());
      int ii = preparedStatement.executeUpdate();
      rowCount += ii;
    } catch (SQLException err) {
      System.out.println("Fejl i Insert feedMessage err= " + err.getMessage());
    }
    return rowCount;
  }

  //Select feedid,feedurl,f1.title, fm1.title, fm1.link, fm1.Description from Feeds f1
  //join feedmessages fm1 using(feedid)
  //where f1.title like "%Joe%" or fm1.title like "%Joe%";
  public ArrayList<FeedDTO> readFeedDTO(String searchWord) {
    String srchstr = "select feedId,feedURL,f1.title, fm1.title, fm1.link, fm1.Description " +
        "from feeds f1 join feedMessages fm1 using(feedid) " +
        "where f1.title like ? or fm1.title like ?";

    ArrayList<FeedDTO> feeds = new ArrayList<>();
    PreparedStatement preparedStatement = null;

    try{
    try {
      preparedStatement = connection.prepareStatement(srchstr);
      preparedStatement.setString(1, "%" + searchWord + "%");
      preparedStatement.setString(2, "%" + searchWord + "%");
      ResultSet resset = preparedStatement.executeQuery();
        try {
          while (resset.next()) {
            FeedDTO dto = new FeedDTO();
            int feedid = resset.getInt(1);
            dto.setFeedid(feedid);
            dto.setFeedURL(resset.getString("FeedURL"));
            dto.setTitle(resset.getString("Title"));
            dto.setDescription(resset.getString("Description"));
            dto.setLink(resset.getString("Link"));
            feeds.add(dto);
          }
        } finally {
          resset.close();

        }
      } catch (SQLException err) {
        System.out.println("Fejl i count err= " + err.getMessage());
      }
    } finally {
      try {
        preparedStatement.close();
      }catch (SQLException err){
        System.out.println("Fejl i close ");
      }
    }
    return feeds;
  }
}
