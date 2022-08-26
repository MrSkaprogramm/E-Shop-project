package by.epam.tr.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import by.epam.tr.bean.Role;
import by.epam.tr.bean.User;
import by.epam.tr.bean.UserStatus;
import by.epam.tr.bean.builder.UserBuilder;
import by.epam.tr.dao.DaoException;
import by.epam.tr.dao.UserDao;
import by.epam.tr.dao.connection.ConnectionPool;
import by.epam.tr.dao.connection.ConnectionPoolException;

/**
 * 
 * A class of the DAO layer containing methods for working with the User entity
 *
 */
public class SQLUserDao implements UserDao {
  private static final ConnectionPool connectionPool = ConnectionPool.getConnectionPool();

  private static final String GET_PAYMENT_EVADERS_QUERY =
      "SELECT DISTINCT users.id, users.login, orders.order_status, users.FIO, users.status "
          + "FROM users, orders WHERE orders.users_id=users.id AND order_status=0;";
  private static final int USER_ID_COLUMN_INDEX = 1;
  private static final int USER_FIO_COLUMN_INDEX = 5;
  private static final int USER_EMAIL_COLUMN_INDEX = 6;
  private static final int USER_ADDRESS_COLUMN_INDEX = 7;
  private static final int USER_ROLE_COLUMN_INDEX = 4;
  private static final int USER_STATUS_COLUMN_INDEX = 8;
  private static final int PAYMENT_EVADERS_LOGIN_COLUMN_INDEX = 2;
  private static final int PAYMENT_EVADERS_FIO_COLUMN_INDEX = 4;
  private static final int PAYMENT_EVADERS_STATUS_COLUMN_INDEX = 5;
  private static final String USER_AUTHORIZATION_QUERY =
      "SELECT * FROM users WHERE login =? AND password =?;";
  private static final String ADD_USER_TO_BLACKLIST_QUERY =
      "UPDATE users SET status = false WHERE id =?";
  private static final String USER_REGISTRATION_QUERY =
      "iNSERT INTO users (login, password, users_role, FIO, email, address, status) VALUES (?, ?, ?, ?, ?, ?, true);";
  private static final String FIND_BY_USER_ID_QUERY = "SELECT * FROM users WHERE id =?";
  private static final String CHECK_UNIQUENESS_USER_LOGIN_QUERY =
      "SELECT * FROM users WHERE login =?";

  /**
   * 
   * User authorization method
   *
   */
  public User userAuth(String login, String password) throws DaoException {
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;
    UserBuilder buildUser = new UserBuilder();
    User user = null;

      try {
        con = connectionPool.takeConnection();
        preparedStatement = con.prepareStatement(USER_AUTHORIZATION_QUERY);
        preparedStatement.setString(1, login);
        preparedStatement.setString(2, password);
        rs = preparedStatement.executeQuery();
        rs.next();

        int role = rs.getInt(USER_ROLE_COLUMN_INDEX);
        int status = rs.getInt(USER_STATUS_COLUMN_INDEX);

        switch (role) {
          case 1:
            buildUser.setUserId(rs.getInt(USER_ID_COLUMN_INDEX));
            buildUser.setLogin(login);
            buildUser.setPassword(password);
            buildUser.setRole(Role.CLIENT);
            buildUser.setFio(rs.getString(USER_FIO_COLUMN_INDEX));
            buildUser.setEmail(rs.getString(USER_EMAIL_COLUMN_INDEX));
            buildUser.setAddress(rs.getString(USER_ADDRESS_COLUMN_INDEX));
            if (status == 1) {
              buildUser.setStatus(UserStatus.FREE);
            } else {
              buildUser.setStatus(UserStatus.BLACKLISTED);
            }
            user = buildUser.build();
            break;
          case 2:
            buildUser.setUserId(rs.getInt(USER_ID_COLUMN_INDEX));
            buildUser.setLogin(login);
            buildUser.setPassword(password);
            buildUser.setRole(Role.ADMIN);
            buildUser.setFio(rs.getString(USER_FIO_COLUMN_INDEX));
            user = buildUser.build();
            break;
        }
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
      return user;
  }

  /**
   * 
   * User registration method
   *
   */
  @Override
  public void userRegistration(String login, String password, String fio, String email,
      String phoneNum, String address, int role) throws DaoException {
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement preparedStatement = null;

    try {
      con = connectionPool.takeConnection();
      preparedStatement = con.prepareStatement(USER_REGISTRATION_QUERY);
      preparedStatement.setString(1, login);
      preparedStatement.setString(2, password);
      preparedStatement.setInt(3, role);
      preparedStatement.setString(4, fio);
      preparedStatement.setString(5, email);
      preparedStatement.setString(6, address);
      preparedStatement.executeUpdate();

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

  /**
   * 
   * Method of adding a user to the blacklist
   *
   */
  @Override
  public void addtoBlackList(int userId) throws DaoException {
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;

    try {
      con = connectionPool.takeConnection();
      preparedStatement = con.prepareStatement(ADD_USER_TO_BLACKLIST_QUERY);
      preparedStatement.setInt(1, userId);
      preparedStatement.executeUpdate();
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

  /**
   * 
   * Method of receiving all defaulters
   *
   */
  @Override
  public List<User> getAllPaymentEvaders() throws DaoException {
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    UserBuilder buildUser = new UserBuilder();
    List<User> paymentEvaders = new ArrayList<User>();

    try {
      con = connectionPool.takeConnection();
      st = con.createStatement();
      rs = st.executeQuery(GET_PAYMENT_EVADERS_QUERY);
      while (rs.next()) {
        buildUser.setUserId(rs.getInt(USER_ID_COLUMN_INDEX));
        buildUser.setLogin(rs.getString(PAYMENT_EVADERS_LOGIN_COLUMN_INDEX));
        buildUser.setFio(rs.getString(PAYMENT_EVADERS_FIO_COLUMN_INDEX));
        if (rs.getInt(PAYMENT_EVADERS_STATUS_COLUMN_INDEX) == 0) {
          buildUser.setStatus(UserStatus.BLACKLISTED);
        } else {
          buildUser.setStatus(UserStatus.FREE);
        }
        User paymentEvader = buildUser.build();
        paymentEvaders.add(paymentEvader);
      }
    } catch (SQLException | ConnectionPoolException e) {
      throw new DaoException(e.getMessage());
    } finally {
      if (con != null) {
        try {
          connectionPool.closeConnection(con, st, rs);
        } catch (SQLException e) {
          throw new DaoException(e.getMessage());
        }
      }
    }
    return paymentEvaders;
  }

  /**
   * 
   * User status verification method
   *
   */
  @Override
  public boolean checkUserStatus(int userId) throws DaoException {
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;

     try {
      con = connectionPool.takeConnection();
      preparedStatement = con.prepareStatement(FIND_BY_USER_ID_QUERY);
      preparedStatement.setInt(1, userId);
      rs = preparedStatement.executeQuery();
      rs.next();

      int status = rs.getInt(8);
      if (status == 0) {
        return false;
      }
    } catch (ConnectionPoolException | SQLException e) {
      throw new DaoException(e.getMessage());
    } finally {
      if (con != null) {
        try {
          connectionPool.closeConnection(con, preparedStatement, rs);
        } catch (SQLException e) {
          throw new DaoException("Blacklisted user");
        }
      }
    }
    return true;
  }

  /**
   * 
   * User login verification method
   *
   */
  @Override
  public boolean checkUserLogin(String login) throws DaoException {
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;

    try {
      con = connectionPool.takeConnection();
      preparedStatement = con.prepareStatement(CHECK_UNIQUENESS_USER_LOGIN_QUERY);
      preparedStatement.setString(1, login);
      rs = preparedStatement.executeQuery();

      int count = 0;
      while (rs.next()) {
        count++;
      }
      if (count > 0) {
        return false;
      }
    } catch (ConnectionPoolException | SQLException e) {
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

    return true;
  }
}
