package by.epam.tr.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import by.epam.tr.bean.Item;
import by.epam.tr.dao.DaoException;
import by.epam.tr.dao.ItemDao;
import by.epam.tr.dao.connection.ConnectionPool;
import by.epam.tr.dao.connection.ConnectionPoolException;

public class SQLItemDao implements ItemDao {
  private static final ConnectionPool connectionPool = ConnectionPool.getConnectionPool();

  private static final String GET_ITEMS_FROM_ORDERS_QUERY =
      "SELECT items_id FROM orders_has_items;";
  private static final String GET_ALL_ITEMS_QUERY = "SELECT * FROM items";
  private static final int ITEM_ID_COLUMN_INDEX = 1;
  private static final int ITEM_NAME_COLUMN_INDEX = 2;
  private static final int ITEM_INFO_COLUMN_INDEX = 3;
  private static final int ITEM_PRICE_COLUMN_INDEX = 4;
  private static final String ADD_ITEM_QUERY =
      "iNSERT INTO items (name, item_info, price) VALUES (?, ?, ?);";
  private static final String DELETE_ITEM_QUERY = "DELETE FROM items WHERE id =?";
  private static final String UPDATE_ITEM_PRICE_QUERY = "UPDATE items SET price=? WHERE id=?;";
  private static final String UPDATE_ITEM_INFO_QUERY = "UPDATE items SET item_info=? WHERE id=?;";
  private static final String UPDATE_ITEM_PRICE_AND_INFO_QUERY =
      "UPDATE items SET item_info=?, price=? WHERE id=?;";

  @Override
  public void addItem(String name, String itemInfo, int price)
      throws DaoException {
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement preparedStatement = null;
    // System.out.println("root2");

    try {
      con = connectionPool.takeConnection();
      preparedStatement = con.prepareStatement(ADD_ITEM_QUERY);
      preparedStatement.setString(1, name);
      preparedStatement.setString(2, itemInfo);
      preparedStatement.setInt(3, price);
      preparedStatement.executeUpdate();

      //System.out.println("root");
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
  public boolean deleteItem(int itemId) throws DaoException {
    Connection con = null;
    Statement st = null;
    PreparedStatement preparedStatement = null;
    ResultSet rs = null;
    // System.out.println("root2");

    try {
      con = connectionPool.takeConnection();
      st = con.createStatement();
      rs = st.executeQuery(GET_ITEMS_FROM_ORDERS_QUERY);
      while (rs.next()) {
        if (rs.getInt(ITEM_ID_COLUMN_INDEX) == itemId) {
          return false;
        }
      }
      preparedStatement = con.prepareStatement(DELETE_ITEM_QUERY);
      preparedStatement.setInt(1, itemId);
      preparedStatement.executeUpdate();
      // System.out.println("root");
      st.close();
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
    return true;
  }

  @Override
  public List<Item> getAllItems() throws DaoException {
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    // System.out.println("root2");
    List<Item> catalog = new ArrayList<Item>();

    try {
      con = connectionPool.takeConnection();
      st = con.createStatement();
      rs = st.executeQuery(GET_ALL_ITEMS_QUERY);
      while (rs.next()) {
        Item item = new Item();
        item.setItemId(rs.getInt(ITEM_ID_COLUMN_INDEX));
        item.setName(rs.getString(ITEM_NAME_COLUMN_INDEX));
        item.setItemInfo(rs.getString(ITEM_INFO_COLUMN_INDEX));
        item.setPrice(rs.getInt(ITEM_PRICE_COLUMN_INDEX));
        catalog.add(item);
      }
      // System.out.println("root");
      st.close();
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
    return catalog;
  }

  @Override
  public void changeItemsDetails(int itemId, String itemInfo, int price) throws DaoException {
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement preparedStatement = null;
    // System.out.println("root2");

    try {
      con = connectionPool.takeConnection();
      // System.out.println("rootcon");
      if (itemInfo.isEmpty()) {
        preparedStatement = con.prepareStatement(UPDATE_ITEM_PRICE_QUERY);
        preparedStatement.setInt(1, price);
        preparedStatement.setInt(2, itemId);
        preparedStatement.executeUpdate();
      } else if (price != -1) {
        preparedStatement = con.prepareStatement(UPDATE_ITEM_INFO_QUERY);
        preparedStatement.setString(1, itemInfo);
        preparedStatement.setInt(2, itemId);
        preparedStatement.executeUpdate();
      } else {
        preparedStatement = con.prepareStatement(UPDATE_ITEM_PRICE_AND_INFO_QUERY);
        preparedStatement.setString(1, itemInfo);
        preparedStatement.setInt(2, price);
        preparedStatement.setInt(3, itemId);
        preparedStatement.executeUpdate();
      }

      // System.out.println("root4");
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
