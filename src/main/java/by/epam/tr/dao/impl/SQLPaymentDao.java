package by.epam.tr.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import by.epam.tr.dao.DaoException;
import by.epam.tr.dao.PaymentDao;
import by.epam.tr.dao.connection.ConnectionPool;
import by.epam.tr.dao.connection.ConnectionPoolException;

public class SQLPaymentDao implements PaymentDao {
  private static final ConnectionPool connectionPool = ConnectionPool.getConnectionPool();

  private static final String UPDATE_ORDER_PAYMENT_INFORMATION =
      "UPDATE payments SET bank_card_num =?, expiring_date=? WHERE orders_id=?;";
  private static final String UPDATE_ORDER_STATUS =
      "UPDATE orders SET order_status = true WHERE id=?;";

  @Override
  public void makePayment(int orderId, String bankCardNum, String expiringDate)
      throws DaoException {
    // System.out.println("rootpay int orderId, String bankCardNum, String expiringDate" + orderId
    // + bankCardNum + expiringDate);
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement preparedStatement = null;
    PreparedStatement preparedStatement2 = null;

    try {
      con = connectionPool.takeConnection();
      // System.out.println("rootpay1 " + orderId);
      preparedStatement = con.prepareStatement(UPDATE_ORDER_PAYMENT_INFORMATION);
      preparedStatement.setString(1, bankCardNum);
      preparedStatement.setString(2, expiringDate);
      preparedStatement.setInt(3, orderId);
      preparedStatement.executeUpdate();
      // System.out.println("rootpay2 " + orderId);

      preparedStatement2 = con.prepareStatement(UPDATE_ORDER_STATUS);
      preparedStatement2.setInt(1, orderId);
      preparedStatement2.executeUpdate();

      // System.out.println("root");
      preparedStatement2.close();
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
}
