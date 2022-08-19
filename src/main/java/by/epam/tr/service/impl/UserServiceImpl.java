package by.epam.tr.service.impl;

import java.util.ArrayList;
import java.util.List;
import by.epam.tr.bean.User;
import by.epam.tr.dao.DaoException;
import by.epam.tr.dao.DaoProvider;
import by.epam.tr.dao.UserDao;
import by.epam.tr.service.ServiceException;
import by.epam.tr.service.UserService;
import by.epam.tr.service.validation.DataValidation;

public class UserServiceImpl implements UserService {
  private static final DaoProvider daoProvider = DaoProvider.getDaoprovider();
  private static final UserDao userDao = daoProvider.getUserDao();
  DataValidation validation = DataValidation.getValidation();

  @Override
  public User userAuth(String login, String password) throws ServiceException {
    /*
     * if(!validation.check(login, password)) { throw new ServiceException(); }
     */

    UserDao userDao = DaoProvider.getDaoprovider().getUserDao();
    User user;
    try {
      user = userDao.userAuth(login, password);
    } catch (DaoException e) {
      throw new ServiceException(e.getMessage());
    }
    return user;
  }

  @Override
  public User userRegistration(String login, String password, String fio, String email,
      String phoneNum, String address, int role) throws ServiceException {
    User user;
    System.out.println("root1");

    try {
      user = userDao.userRegistration(login, password, fio, email, phoneNum, address, role);
    } catch (DaoException e) {
      throw new ServiceException(e.getMessage());
    }
    return user;
  }

  @Override
  public void addtoBlackList(int userId) throws ServiceException {
    System.out.println("root1");

    try {
      userDao.addtoBlackList(userId);
    } catch (DaoException e) {
      throw new ServiceException(e.getMessage());
    }
  }

  @Override
  public List<User> getAllPaymentEvaders() throws ServiceException {
    System.out.println("root1");
    List<User> paymentEvaders = new ArrayList<User>();
    try {
      paymentEvaders = userDao.getAllPaymentEvaders();
    } catch (DaoException e) {
      throw new ServiceException(e.getMessage());
    }
    return paymentEvaders;
  }
}
