package by.epam.tr.dao;

import by.epam.tr.dao.impl.SQLItemDao;
import by.epam.tr.dao.impl.SQLOrderDao;
import by.epam.tr.dao.impl.SQLPaymentDao;
import by.epam.tr.dao.impl.SQLUserDao;

public class DaoProvider {
  private static final DaoProvider daoProvider = new DaoProvider();

  private UserDao userDao = new SQLUserDao();
  private ItemDao itemDao = new SQLItemDao();
  private OrderDao orderDao = new SQLOrderDao();
  private PaymentDao paymentDao = new SQLPaymentDao();

  public DaoProvider() {}

  public UserDao getUserDao() {
    return userDao;
  }

  public void setUserDao(UserDao clientDao) {
    this.userDao = clientDao;
  }

  public ItemDao getItemDao() {
    return itemDao;
  }

  public void setItemDao(ItemDao itemDao) {
    this.itemDao = itemDao;
  }

  public OrderDao getOrderDao() {
    return orderDao;
  }

  public void setOrderDao(OrderDao orderDao) {
    this.orderDao = orderDao;
  }

  public PaymentDao getPaymentDao() {
    return paymentDao;
  }

  public void setPaymentDao(PaymentDao paymentDao) {
    this.paymentDao = paymentDao;
  }

  public static DaoProvider getDaoprovider() {
    return daoProvider;
  }
}
