/**
 * @author roed
 */
public class HeaderTag extends Style {

  private int number;

  public HeaderTag(String id, String text, int number) {
    super(id, text, "");
    this.number = number;
  }


  public HeaderTag(String id, String text, String color, int number) {
    super(id, text, color);
    this.number = number;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  @Override
  void print() {
    System.out.println(this.toHtmlString());
  }

  @Override
  String toHtmlString() {
    return "<h"+ this.getNumber() + " " + this.getId() + " " + this.toStyleString() + ">" + this.getText() + ">" + "</" + getId() + ">";
  }

  @Override
  public int compareTo(HtmlTag o) {
    return this.getId().compareTo(o.getId());
  }
}
