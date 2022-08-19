package by.epam.tr.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import by.epam.tr.bean.Item;
import by.epam.tr.bean.Order;
import by.epam.tr.dao.DaoException;
import by.epam.tr.dao.OrderDao;
import by.epam.tr.dao.connection.ConnectionPool;
import by.epam.tr.dao.connection.ConnectionPoolException;
import by.epam.tr.service.ServiceException;

public class SQLOrderDao implements OrderDao {
  private static final ConnectionPool connectionPool = ConnectionPool.getConnectionPool();

  private static final int ORDER_ID_COLUMN_INDEX = 1;
  private static final int ORDER_STATUS_COLUMN_INDEX = 2;
  private static final int ORDER_PAYMENT_SUM_COLUMN_INDEX = 3;
  private static final String GET_ORDERS_QUERY =
      "SELECT orders.id, orders.order_status, payments.payment_sum FROM eshopdb.orders, payments "
          + "WHERE orders.id=payments.orders_id AND orders.users_id=?";
  private static final String ADD_ORDER_QUERY =
      "INSERT INTO orders(order_status, users_id) VALUES (false, ?);";
  private static final String FIND_LAST_ORDER_QUERY =
      "SELECT * FROM orders WHERE users_id =? ORDER BY id DESC;";
  private static final String ADD_ITEMS_TO_ORDER_QUERY =
      "INSERT INTO orders_has_items VALUES(?, ?);";
  private static final String UPDATE_ORDER_PAYMENT_SUM_QUERY =
      "INSERT INTO payments(orders_id, payment_sum) VALUES(?, ?);";


  @Override
  public void makeOrder(int userId, List<Item> cart) throws ServiceException, DaoException {
    Connection con = null;
    PreparedStatement preparedStatement = null;
    PreparedStatement preparedStatement2 = null;
    PreparedStatement preparedStatement3 = null;
    PreparedStatement preparedStatement4 = null;


    int insert = 0;
    ResultSet rs = null;
    int itemId;
    int paymentSum = 0;

    // System.out.println("root2 " + userId);

    try {
      con = connectionPool.takeConnection();
      preparedStatement = con.prepareStatement(ADD_ORDER_QUERY);
      preparedStatement.setInt(1, userId);
      preparedStatement.executeUpdate();
      // System.out.println("rootinsert");
      preparedStatement2 = con.prepareStatement(FIND_LAST_ORDER_QUERY);
      preparedStatement2.setInt(1, userId);
      rs = preparedStatement2.executeQuery();
      rs.next();
      int orderId = rs.getInt(ORDER_ID_COLUMN_INDEX);
      insert = 0;
      //вычисление последнего id
      // System.out.println(
      // "rootbeforeloop id" + cart.get(0).getItemId() + "rootbeforeloop size" + cart.size());
      for(int i = 0; i < cart.size(); i++) {
        // System.out.println("rootloop1");
        itemId = cart.get(i).getItemId();
        // System.out.println("rootloop2 itemId orderId" + itemId + " " + orderId);
        preparedStatement3 = con.prepareStatement(ADD_ITEMS_TO_ORDER_QUERY);
        preparedStatement3.setInt(1, orderId);
        preparedStatement3.setInt(2, itemId);
        preparedStatement3.executeUpdate();
        // System.out.println("rootloop3");
        paymentSum += cart.get(i).getPrice();
        // System.out.println("rootloop5");
      }
      // System.out.println("rootafterloop");
      preparedStatement4 = con.prepareStatement(UPDATE_ORDER_PAYMENT_SUM_QUERY);
      preparedStatement4.setInt(1, orderId);
      preparedStatement4.setInt(2, paymentSum);
      preparedStatement4.executeUpdate();

      //System.out.println("root");
      preparedStatement2.close();
      preparedStatement3.close();
      preparedStatement4.close();
    } catch (SQLException | ConnectionPoolException e) {
      throw new DaoException(e.getMessage());
    } finally {
      if (con != null) {
        try {
          connectionPool.closeConnection(con, preparedStatement, rs);
        } catch (SQLException e) {
          throw new DaoException(e.getMessage());
        }
      }
    }
  }

  @Override
  public List<Order> getAllOrders(int userId) throws DaoException {
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;
    int itemId;
    List<Order> orders = new ArrayList<Order>();
    // System.out.println("root2");

    try {
      con = connectionPool.takeConnection();
      preparedStatement = con.prepareStatement(GET_ORDERS_QUERY);
      preparedStatement.setInt(1, userId);
      rs = preparedStatement.executeQuery();

      while (rs.next()) {
        Order order = new Order();
        order.setOrderId(rs.getInt(ORDER_ID_COLUMN_INDEX));
        if (rs.getInt(ORDER_STATUS_COLUMN_INDEX) == 0) {
          order.setOrderStatus(false);
        }else {
          order.setOrderStatus(true);
        }
        order.getPayment().setPaymentSum(rs.getInt(ORDER_PAYMENT_SUM_COLUMN_INDEX));
        orders.add(order);
      } ;
      // System.out.println("root");
    } catch (SQLException | ConnectionPoolException e) {
      throw new DaoException(e.getMessage());
    } finally {
      if (con != null) {
        try {
          connectionPool.closeConnection(con, preparedStatement, rs);
        } catch (SQLException e) {
          throw new DaoException(e.getMessage());
        }
      }
    }
    return orders;
  }
}
