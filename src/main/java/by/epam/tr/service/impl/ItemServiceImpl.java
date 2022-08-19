package by.epam.tr.service.impl;

import java.util.ArrayList;
import java.util.List;
import by.epam.tr.bean.Item;
import by.epam.tr.dao.DaoException;
import by.epam.tr.dao.DaoProvider;
import by.epam.tr.dao.ItemDao;
import by.epam.tr.service.ItemService;
import by.epam.tr.service.ServiceException;

public class ItemServiceImpl implements ItemService {
  private static final DaoProvider daoProvider = DaoProvider.getDaoprovider();
  private static final ItemDao itemDao = daoProvider.getItemDao();

  @Override
  public void addItem(String name, String itemInfo, int price)
      throws ServiceException {

    try {
      itemDao.addItem(name, itemInfo, price);
    } catch (DaoException e) {
      throw new ServiceException(e.getMessage());
    }
  }

  @Override
  public boolean deleteItem(int itemId) throws ServiceException {
    boolean itemDeleted;
    try {
      itemDeleted = itemDao.deleteItem(itemId);
    } catch (DaoException e) {
      throw new ServiceException(e.getMessage());
    }
    return itemDeleted;
  }

  @Override
  public List<Item> getAllItems() throws ServiceException {
    List<Item> catalog = new ArrayList<Item>();
    try {
      catalog = itemDao.getAllItems();
    } catch (DaoException e) {
      throw new ServiceException(e.getMessage());
    }
    return catalog;
  }

  @Override
  public void changeItemsDetails(int itemId, String itemInfo, int price) throws ServiceException {

    try {
      itemDao.changeItemsDetails(itemId, itemInfo, price);
    } catch (DaoException e) {
      throw new ServiceException(e.getMessage());
    }
  }
}
