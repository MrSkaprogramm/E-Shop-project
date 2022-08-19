package by.epam.tr.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import by.epam.tr.bean.Item;
import by.epam.tr.bean.Order;
import by.epam.tr.dao.DaoException;
import by.epam.tr.dao.DaoProvider;
import by.epam.tr.dao.OrderDao;
import by.epam.tr.service.OrderService;
import by.epam.tr.service.ServiceException;

public class OrderServiceImpl implements OrderService {
  private static final DaoProvider daoProvider = DaoProvider.getDaoprovider();
  private static final OrderDao orderDao = daoProvider.getOrderDao();

  @Override
  public void makeOrder(int userId, List<Item> cart) throws ServiceException {

    try {
      orderDao.makeOrder(userId, cart);
    } catch (DaoException e) {
      throw new ServiceException(e.getMessage());
    }
  }

  @Override
  public List<Item> addItemToCart(List<Item> cart, int itemId, String name, String itemInfo,
      int price) {
    Item item = new Item();
    item.setItemId(itemId);
    item.setName(name);
    item.setItemInfo(itemInfo);
    item.setPrice(price);
    cart.add(item);
    return cart;
  }

  @Override
  public List<Item> deleteItemFromCart(List<Item> cart, int itemId) {
    Iterator<Item> cartIterator = cart.iterator();
    while (cartIterator.hasNext()) {
      Item item = new Item();
      item = cartIterator.next();
      if (item.getItemId() == itemId) {
        cartIterator.remove();
      }
    }
    return cart;
  }

  @Override
  public List<Order> getAllOrders(int userId) throws ServiceException {
    List<Order> orders = new ArrayList<Order>();

    try {
      orders = orderDao.getAllOrders(userId);
    } catch (DaoException e) {
      throw new ServiceException(e.getMessage());
    }
    return orders;
  }
}
