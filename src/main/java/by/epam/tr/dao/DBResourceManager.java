package by.epam.tr.dao;

import java.util.ResourceBundle;

/**
 * 
 * A class that manages information about the database
 *
 */
public class DBResourceManager {
  private static final DBResourceManager instance = new DBResourceManager();

  private ResourceBundle bundle = ResourceBundle.getBundle("db");

  public static DBResourceManager getInstance() {
    return instance;
  }

  public String getValue(String key) {
    return bundle.getString(key);
  }
}
