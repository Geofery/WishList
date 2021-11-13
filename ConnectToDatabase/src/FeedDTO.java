/**
 * @author roed
 */
public class FeedDTO {
  private int feedid;
  private String feedURL;
  private String title;
  private String description;
  private String link;

  public int getFeedid() {
    return feedid;
  }

  public void setFeedid(int feedid) {
    this.feedid = feedid;
  }

  public String getFeedURL() {
    return feedURL;
  }

  public void setFeedURL(String feedURL) {
    this.feedURL = feedURL;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  @Override
  public String toString() {
    return "Feed Id: " + feedid +
        ", Feed URL: " + feedURL +", Title: " + title +
        ", Description: " + description +
        ", Link: " + link;
  }
}
