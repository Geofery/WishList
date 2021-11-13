import java.util.ArrayList;

/**
 * @author roed
 */
public abstract class Style extends HtmlTag {

  private String color;

  public static ArrayList<String> colors;

  public Style(String id, String text, String color) {
    super(id, text);
    this.color = color;
    colors = new ArrayList<>();
    colors.add("red");
    colors.add("blue");
    colors.add("pink");
    colors.add("green");
    colors.add("yellow");
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public String toStyleString() {
    return "Style=" + '"' +
        "color: " + color + '"';
  }

}
