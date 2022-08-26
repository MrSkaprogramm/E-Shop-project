package by.epam.tr.service.impl;

import java.util.ArrayList;
import java.util.List;
import by.epam.tr.bean.Item;
import by.epam.tr.dao.DaoException;
import by.epam.tr.dao.DaoProvider;
import by.epam.tr.dao.ItemDao;
import by.epam.tr.service.ItemService;
import by.epam.tr.service.ServiceException;
import by.epam.tr.service.validation.ItemValidator;
import by.epam.tr.service.validation.ValidatorProvider;

/**
 * 
 * A class of the Service layer containing methods for working with the Item entity
 *
 */
public class ItemServiceImpl implements ItemService {
  private static final DaoProvider daoProvider = DaoProvider.getDaoprovider();
  private static final ItemDao itemDao = daoProvider.getItemDao();
  private static final ValidatorProvider validatorProvider =
      ValidatorProvider.getValidatorprovider();
  private static final ItemValidator itemValidator = validatorProvider.getItemValidator();

  /**
   * 
   * Method of adding a product to the catalog
   *
   */
  @Override
  public void addItem(String name, String itemInfo, int price)
      throws ServiceException {

    if (!itemValidator.checkItemInfo(name, itemInfo, price)) {
      throw new ServiceException("Wrong item data");
    }


    try {
      itemDao.addItem(name, itemInfo, price);
    } catch (DaoException e) {
      throw new ServiceException(e.getMessage());
    }
  }

  /**
   * 
   * Method of removing an item from the catalog
   *
   */
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

  /**
   * 
   * Method of getting the entire catalog
   *
   */
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

  /**
   * 
   * Method of changing product data
   *
   */
  @Override
  public void changeItemsDetails(int itemId, String itemInfo, int price) throws ServiceException {

    if (!itemValidator.checkItemInfo(itemInfo, price)) {
      throw new ServiceException("Wrong item data");
    }


    try {
      itemDao.changeItemsDetails(itemId, itemInfo, price);
    } catch (DaoException e) {
      throw new ServiceException(e.getMessage());
    }
  }
}
