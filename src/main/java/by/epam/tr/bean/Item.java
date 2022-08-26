package by.epam.tr.bean;

import java.io.Serializable;
import java.util.Objects;

/**
 * 
 * A class describing the product entity
 *
 */
public class Item implements Serializable{
  private static final long serialVersionUID = -1449298819053482088L;
  private int itemId;
  private String name;
  private String itemInfo;
  private int price;

  public int getItemId() {
    return itemId;
  }

  public void setItemId(int itemId) {
    this.itemId = itemId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getItemInfo() {
    return itemInfo;
  }

  public void setItemInfo(String itemInfo) {
    this.itemInfo = itemInfo;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  @Override
  public int hashCode() {
    return Objects.hash(itemId, itemInfo, name, price);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Item other = (Item) obj;
    return itemId == other.itemId && Objects.equals(itemInfo, other.itemInfo)
        && Objects.equals(name, other.name) && price == other.price;
  }

  @Override
  public String toString() {
    return "Item [itemId=" + itemId + ", name=" + name + ", itemInfo=" + itemInfo + ", price="
        + price + "]";
  }
}
