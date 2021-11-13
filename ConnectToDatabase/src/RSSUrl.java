import java.util.ArrayList;

/**
 * @author roed
 */
public class RSSUrl {

  private int feedId;
  private String rssUrl;

  public static ArrayList<RSSUrl> getNews(){
    ArrayList<RSSUrl> rss = new ArrayList<>();
    rss.add(new RSSUrl(1,"https://ekstrabladet.dk/rssfeed/all/"));
    rss.add(new RSSUrl(2,"https://ekstrabladet.dk/rssfeed/sport/"));
    rss.add(new RSSUrl(3,"https://www.dr.dk/nyheder/service/feeds/senestenyt"));
    rss.add(new RSSUrl(4,"https://www.dr.dk/nyheder/service/feeds/udland"));
    rss.add(new RSSUrl(5,"https://www.dr.dk/nyheder/service/feeds/penge"));
    rss.add(new RSSUrl(6,"https://www.dr.dk/nyheder/service/feeds/sporten"));
    rss.add(new RSSUrl(7,"https://www.dr.dk/nyheder/service/feeds/viden"));
    return rss;
  }

  public RSSUrl(int feedId, String rssUrl) {
    this.feedId = feedId;
    this.rssUrl = rssUrl;
  }

  public int getFeedId() {
    return feedId;
  }

  public void setFeedId(int feedId) {
    this.feedId = feedId;
  }

  public String getRssUrl() {
    return rssUrl;
  }

  public void setRssUrl(String rssUrl) {
    this.rssUrl = rssUrl;
  }

  @Override
  public String toString() {
    return "FeedId: " + feedId +
        ", RSSUrl: " + rssUrl;
  }
}
