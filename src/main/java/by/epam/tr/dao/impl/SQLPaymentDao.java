package by.epam.tr.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import by.epam.tr.dao.DaoException;
import by.epam.tr.dao.PaymentDao;
import by.epam.tr.dao.connection.ConnectionPool;
import by.epam.tr.dao.connection.ConnectionPoolException;

/**
 * 
 * A class of the DAO layer containing methods for working with the Order and Payment entity
 *
 */
public class SQLPaymentDao implements PaymentDao {
  private static final ConnectionPool connectionPool = ConnectionPool.getConnectionPool();

  private static final String UPDATE_ORDER_PAYMENT_INFORMATION =
      "UPDATE payments SET bank_card_num =?, expiring_date=? WHERE orders_id=?;";
  private static final String UPDATE_ORDER_STATUS =
      "UPDATE orders SET order_status = true WHERE id=?;";

  /**
   * 
   * Order payment method
   *
   */
  @Override
  public void makePayment(int orderId, String bankCardNum, String expiringDate)
      throws DaoException {
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement preparedStatement = null;
    PreparedStatement preparedStatement2 = null;

    try {
      con = connectionPool.takeConnection();
      preparedStatement = con.prepareStatement(UPDATE_ORDER_PAYMENT_INFORMATION);
      preparedStatement.setString(1, bankCardNum);
      preparedStatement.setString(2, expiringDate);
      preparedStatement.setInt(3, orderId);
      preparedStatement.executeUpdate();

      preparedStatement2 = con.prepareStatement(UPDATE_ORDER_STATUS);
      preparedStatement2.setInt(1, orderId);
      preparedStatement2.executeUpdate();

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
