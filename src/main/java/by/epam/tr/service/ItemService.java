package by.epam.tr.service;

import java.util.List;
import by.epam.tr.bean.Item;

/**
 * 
 * Interface of the Service layer containing methods that work with the Item entity
 *
 */
public interface ItemService {
  public void addItem(String name, String itemInfo, int price)
      throws ServiceException;

  public boolean deleteItem(int itemId) throws ServiceException;

  public void changeItemsDetails(int itemId, String itemInfo, int price) throws ServiceException;

  public List<Item> getAllItems() throws ServiceException;
}
