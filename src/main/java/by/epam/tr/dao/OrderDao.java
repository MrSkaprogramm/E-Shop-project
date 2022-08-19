package by.epam.tr.dao;

import java.util.List;
import by.epam.tr.bean.Item;
import by.epam.tr.bean.Order;
import by.epam.tr.service.ServiceException;

public interface OrderDao {
  public void makeOrder(int userId, List<Item> cart) throws ServiceException, DaoException;

  public List<Order> getAllOrders(int userId) throws DaoException;
}
