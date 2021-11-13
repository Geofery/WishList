import java.util.Objects;

/**
 * @author roed
 */
public abstract class HtmlTag implements Comparable<HtmlTag> {
  private String id;
  private String text;

  public HtmlTag(String id, String text) {
    this.id = id;
    this.text = text;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  abstract String toHtmlString();
  abstract void print();

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    HtmlTag htmlTag = (HtmlTag) o;
    return id.equals(htmlTag.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public int compareTo(HtmlTag o) {
    return this.getId().compareTo(o.getId());
  }
}
