import java.util.Random;

public class Computer implements Player {
  private int points;


  @Override
  public String takeTurn() {
    String[] handMoves = {"Rock", "Paper", "Scissor"};
    return handMoves[new Random().nextInt(handMoves.length)];
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
