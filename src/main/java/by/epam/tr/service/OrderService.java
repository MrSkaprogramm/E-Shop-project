package by.epam.tr.service;

import java.util.List;
import by.epam.tr.bean.Item;
import by.epam.tr.bean.Order;

/**
 * 
 * Interface of the Service layer containing methods that work with the Order entity
 *
 */
public interface OrderService {
  public boolean makeOrder(int userId, List<Item> cart) throws ServiceException;

  public List<Item> addItemToCart(List<Item> cart, int itemId, String name, String itemInfo,
      int price);

  public List<Item> deleteItemFromCart(List<Item> cart, int itemId);

  public List<Order> getAllOrders(int userId) throws ServiceException;
}
