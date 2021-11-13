import java.util.*;

/**
 * @author roed
 */
public class main {
  public static void main(String[] args) {
    int[] numbers = new int[10];
    Random random = new Random();

    for (int i = 0; i < numbers.length; i++) {
      int temp = random.nextInt(100)+1;
      numbers[i] = temp;
    }

    System.out.println(Arrays.stream(numbers).average());

    Arrays.stream(numbers).sorted();



//anden del ArrayList
    ArrayList<Double> arrayNumbers = new ArrayList();

    for (int i = 0; i < 10; i++) {
      arrayNumbers.add((double)random.nextInt(100)+1);
    }

    //Collections.reverseOrder();


    for (int i = 0; i < arrayNumbers.size(); i++) {
      if (arrayNumbers.get(i) )
    }

  }
}
