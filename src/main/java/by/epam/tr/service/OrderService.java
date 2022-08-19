package by.epam.tr.service;

import java.util.List;
import by.epam.tr.bean.Item;
import by.epam.tr.bean.Order;

public interface OrderService {
  public void makeOrder(int userId, List<Item> cart) throws ServiceException;

  public List<Item> addItemToCart(List<Item> cart, int itemId, String name, String itemInfo,
      int price);

  public List<Item> deleteItemFromCart(List<Item> cart, int itemId);

  public List<Order> getAllOrders(int userId) throws ServiceException;
}
