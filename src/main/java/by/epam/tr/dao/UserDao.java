package by.epam.tr.dao;

import java.util.List;
import by.epam.tr.bean.User;

/**
 * 
 * Interface of the DAO layer containing methods that work with the User entity
 *
 */
public interface UserDao {
  public User userAuth(String login, String password) throws DaoException;

  public void userRegistration(String login, String password, String fio, String email,
      String phoneNum, String address, int role) throws DaoException;

  public void addtoBlackList(int userId) throws DaoException;

  public List<User> getAllPaymentEvaders() throws DaoException;

  public boolean checkUserStatus(int userId) throws DaoException;

  public boolean checkUserLogin(String login) throws DaoException;
}
