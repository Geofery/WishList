public class Human implements Player {
  private int points;
  UI ui = new UI();


  @Override
  public String takeTurn() {
    return ui.scanString();
  }

  @Override
  public void addPoint() {
    points++;
  }

  @Override
  public void resetPoints() {
    points = 0;
  }

  @Override
  public int getPoint() {
    return points;
  }
}
