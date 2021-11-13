import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author roed
 */
public class Main4 {
  public static void main(String[] args) {


    Set<String> strset = new HashSet<>();

    String s1 = "Jon";
    String s2 = "Erik";

    strset.add(s1);
    strset.add(s2);

    System.out.println("String set size " + strset.size());

    Set<HtmlTag> hset = new HashSet<>();
    PTag p1 = new PTag("p1", "Jeg er p1");
    PTag p2 = new PTag("p2", "Jeg er p2");
    PTag p3 = new PTag("p1", "Jeg er p1");

    hset.add(p1);
    hset.add(p2);
    hset.add(p3);
    System.out.println("hset size " + hset.size());

    HeaderTag h1 = new HeaderTag("p1", "jeg er header", 1);
    hset.add(h1);

    System.out.println("hset size + header " + hset.size());

    for (int i = 0; i < 20; i++) {
      PTag pt = new PTag("p" + i, "jeg er ptag p" + i);
      hset.add(pt);
    }
    System.out.println(hset.size());
    for (HtmlTag tg : hset) {
      tg.print();
    }
    System.out.println();
    System.out.println();
    System.out.println();

    Set<HtmlTag> sortSet = new TreeSet<>(hset);
    for (HtmlTag tg : sortSet) {
      tg.print();
    }
  }
}
