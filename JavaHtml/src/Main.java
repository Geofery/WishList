import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

public class Main {

  public static Map<String, Integer> readUrl(ArrayList<String> wList, String urlin) throws IOException {
    // String urlin = "https://www.dr.dk";
    URL url = new URL(urlin);
    InputStreamReader isr = new InputStreamReader(url.openStream());
    BufferedReader bf = new BufferedReader(isr);
    String urlstr = "";

    //String word = "Afghanistan";
    Map<String, Integer> wmap = new HashMap<>();
    //wmap.put(word, 0);
    for (String sw : wList) {
      wmap.put(sw, 0);
    }

    while (urlstr != null) {
      for (String sw : wList) {
        if (urlstr.contains(sw)) {
          Integer i2 = wmap.get(sw);
          i2++;
          wmap.put(sw, i2);
        }
        urlstr = bf.readLine();
      }
    }
    bf.close();
    //System.out.println("Det står der: " + wmap.get(word));
    return wmap;
  }

  public static Map<String, Map<String, Integer>> getNews(ArrayList wList) throws IOException {
    ArrayList<String> urls = new ArrayList<>();
    urls.add("https://borsen.dk");
    urls.add("https://www.dr.dk");
    urls.add("https://edition.cnn.com");
    urls.add("https://ekstrabladet.dk");

    Map<String, Map<String, Integer>> mapNews = new HashMap<>();

    for (String sw: urls){
      var mpp = readUrl(wList, sw);
      mapNews.put(sw, mpp);
    }


    return mapNews;
  }


  public static void main(String[] args) throws IOException {
    ArrayList<String> wList = new ArrayList<>();
    wList.add("Afghanistan");
    wList.add("Mette");
    wList.add("til");
    wList.add("<div");
    wList.add("USA");
    Map<String, Map<String, Integer>> news = getNews(wList);
    Set<String> sset = news.keySet();

    for (String surl : sset) {
      //Integer cnt = news.get(sw);
      Map<String, Integer> mapCount = news.get(surl);
      Set<String> wKeys = mapCount.keySet();
      System.out.println("på " +surl + " står følgende: ");
      for (String w: wKeys){
        Integer i1 = mapCount.get(w);
        System.out.println("ord: " + w + "følgende gange: " + i1);
      }
    }


    Map<String, HtmlTag> map = new HashMap<>();

    PTag pt = new PTag("p1", "Jeg er ptag 1");
    PTag pt2 = new PTag("p2", "Jeg er ptag 2");

    map.put(pt.getId(), pt);
    map.put(pt2.getId(), pt);
    System.out.println("Map size " + map.size());

    HtmlTag pt3 = map.get(pt.getId());
    pt3.print();

  }
}