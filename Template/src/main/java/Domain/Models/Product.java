package Domain.Models;

/**
 * @author roed
 */
public class Product {
  private String name;
  private String description;
  private String price;
  private String url;

  public Product() {
  }

  public Product(String name, String description, String price, String url) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.url = url;
  }
}
