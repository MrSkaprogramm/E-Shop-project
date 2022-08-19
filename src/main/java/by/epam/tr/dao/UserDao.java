package by.epam.tr.dao;

import java.util.List;
import by.epam.tr.bean.User;

public interface UserDao {
  public User userAuth(String login, String password) throws DaoException;

  public User userRegistration(String login, String password, String fio, String email,
      String phoneNum, String address, int role) throws DaoException;

  public void addtoBlackList(int userId) throws DaoException;

  public List<User> getAllPaymentEvaders() throws DaoException;
}
