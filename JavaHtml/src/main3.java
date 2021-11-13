import java.util.ArrayList;
import java.util.Iterator;

public class main3 {
  public static void main(String[] args) throws Exception {

    PTag p1 = new PTag("p1", "ligemeget");
    PTag p2 = new PTag("p2", "mere ligemeget");
    PTag p3 = new PTag("p3", "meget mere ligemeget");

    ArrayList<HtmlTag> lst = new ArrayList<>();
    lst.add(p1);
    lst.add(p2);
    lst.add(p3);

    int ix = lst.indexOf(p2);
    System.out.println(ix);

    PTag pt4 = new PTag("p2", "afd");

    for(HtmlTag ht : lst){
      ht.print();

      lst.remove(p2);
      System.out.println();

      /*Iterator<HtmlTag> ite = new lst.iterator();
      while (ite.hasNext()) {
        if (ite.next() instanceof PTag) {
          ite.remove();
        }
      }
*/
      for (int i = lst.size()-1; i >= 0; i--) {
        lst.add(new HeaderTag("h" + i + "-1", "Jeg er en h" + i + " tag", Style.colors.get(i), i));
        for (int j = 0; j < 4; j++) {
          lst.add(new PTag("p" + i + "-1", "Jeg er en pTag"));
        }
      }
    }
  }
}