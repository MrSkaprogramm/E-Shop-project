package by.epam.tr.dao;

import java.util.List;
import by.epam.tr.bean.Item;

public interface ItemDao {
  public void addItem(String name, String itemInfo, int price)
      throws DaoException;

  public boolean deleteItem(int itemId) throws DaoException;

  public void changeItemsDetails(int itemId, String itemInfo, int price) throws DaoException;

  public List<Item> getAllItems() throws DaoException;
}
