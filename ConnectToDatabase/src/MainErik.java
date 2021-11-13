import java.util.ArrayList;
/*
public class MainErik {

    public static void main(String[] args) {
    	// write your code here
        //jdbc:mysql://127.0.0.1:3306/rssfeedv1?user=vivi

        JDBCWriter jdbcWriter = new JDBCWriter();
        boolean hasCon = jdbcWriter.setConnection();
        System.out.println("Har con hasCon=" + hasCon);

        if (hasCon) {
            int feedcount = jdbcWriter.countFeeds();
            System.out.println("Der var " + feedcount + " feeds");

            int cntFeedsStart = jdbcWriter.countTable("feeds");
            int cntFeedMsgStart = jdbcWriter.countTable("feedmessages");

            System.out.println("cntfeeds=" + cntFeedsStart);
            System.out.println("cntfeedMsg=" + cntFeedMsgStart);

            //System.exit(1);
            ArrayList<RSSUrl> urls = RSSUrl.getCNN();
            for (RSSUrl rss: urls) {
                System.out.println(rss);
                RSSFeedParser parser = new RSSFeedParser(rss.getRssurl());

                Feed feed = parser.readFeed();

                System.out.println("FEED læst=" + feed);

                int ii = jdbcWriter.writeFeed(rss, feed);
                System.out.println("WriteFeed kaldt i=" + ii);

                for (FeedMessage msg: feed.getMessages()) {
                    //System.out.println(msg);
                    int imsg = jdbcWriter.writeFeedMessages(rss, msg);
                    System.out.println("feedmessage written imsg=" + imsg);
                }

            }
            int cntFeedsSlut = jdbcWriter.countTable("feeds");
            int cntFeedMsgSlut = jdbcWriter.countTable("feedmessages");

            System.out.println("Antal nye feeds læst=" + (cntFeedsSlut - cntFeedsStart));
            System.out.println("Antal nye messages læst=" + (cntFeedMsgSlut - cntFeedMsgStart));
        }//end hasCon

    }
}
*/