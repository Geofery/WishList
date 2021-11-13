import java.util.ArrayList;

/**
 * @author roed
 */
public class Main {
  public static void main(String[] args) {
    UI ui = new UI();
    JDBCWriter jdbcWriter = new JDBCWriter();
    boolean hasCon = jdbcWriter.setConnection(ui);
    System.out.println("Har con hasCon= " + hasCon);

    if (hasCon) {
      int feedcount = jdbcWriter.countFeeds();
      System.out.println("Der var " + feedcount + " Feeds");

      int cntFeedsStart = jdbcWriter.countTable("Feeds");
      int cntFeedMsgStart = jdbcWriter.countTable("FeedMessages");
      ui.displayGreen("CntFeeds = " + cntFeedsStart);
      ui.displayGreen("CntFeedMsg = " + cntFeedMsgStart);

      ArrayList<FeedDTO> feeds = new ArrayList<>();
      feeds = jdbcWriter.readFeedDTO("bil");
      FeedDTO dto = feeds.get(0);
      int feedCnt = dto.getFeedid();
      ui.errorRed("jeg har " + feedCnt + " feeds");

      for (FeedDTO feedDTO: feeds){
        System.out.println((feeds));
      }

      System.exit(1);
      ArrayList<RSSUrl> urls = RSSUrl.getNews();
      for (RSSUrl rss : urls) {
        System.out.println(rss);
        RSSFeedParser parser = new RSSFeedParser(rss.getRssUrl());

        Feed feed = parser.readFeed();
        System.out.println("Feed læste: " + feed);

        int ii = jdbcWriter.writeFeed(rss, feed);
        System.out.println("WriteFeed kaldt i = " + ii);

        for (FeedMessage msg : feed.getMessages()) {
          //System.out.println(msg);
          int imsg = jdbcWriter.writeFeedMessages(rss, msg);
          System.out.println("FeedMessage written imsg = " + imsg);
        }
      }
      int cntFeedsSlut = jdbcWriter.countTable("Feeds");
      int cntFeedMsgSlut = jdbcWriter.countTable("FeedMessages");
      ui.displayGreen("Antal nye feeds læst = " + (cntFeedsSlut - cntFeedsStart));
      ui.displayGreen("Antal nye feedMessages læst  = " + (cntFeedMsgSlut - cntFeedMsgStart));
    }
  }
}
