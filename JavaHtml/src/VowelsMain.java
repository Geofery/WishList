import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author roed
 */
public class VowelsMain {
  public static String getVowels(String in) {

    char[] temp = in.toLowerCase().toCharArray();
    ArrayList<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'y'));
    String res = "";

    for (char c : temp) {
      if (vowels.contains(c) && !res.contains(Character.toString(c))) {
        res += c;
      }
    }
    return res;
  }

  public static String getVowelsSet(String in) {

    char[] temp = in.toLowerCase().toCharArray();
    ArrayList<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'y'));
    String res = "";
    Set<Character> chset = new HashSet<>();

    for (char c : temp) {
      if (vowels.contains(c) && !res.contains(Character.toString(c))) {
        res += c;
        chset.add(c);
      }
    }
    return chset.toString();
  }

  public static void main(String[] args) {
    String vow = getVowels("Erik spiser ymer til morgenmad");
    String vow2 = getVowelsSet("Erik spiser ymer til morgenmad");
    System.out.println(vow);
    System.out.println(vow2);

  }
}

