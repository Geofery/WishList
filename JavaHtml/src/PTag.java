/**
 * @author roed
 */
public class PTag extends HtmlTag {


  public PTag(String id, String text) {
    super(id, text);
  }

  @Override
  String toHtmlString() {
    return "<p>" + this.getText() + "</p>";
  }

  @Override
  void print() {
    System.out.println(this.toHtmlString());
  }

}
