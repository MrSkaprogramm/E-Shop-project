package by.epam.tr.service.impl;

import java.util.ArrayList;
import java.util.List;
import by.epam.tr.bean.User;
import by.epam.tr.dao.DaoException;
import by.epam.tr.dao.DaoProvider;
import by.epam.tr.dao.UserDao;
import by.epam.tr.service.ServiceException;
import by.epam.tr.service.UserService;
import by.epam.tr.service.validation.UserValidator;
import by.epam.tr.service.validation.ValidatorProvider;

/**
 * 
 * A class of the Service layer containing methods for working with the User entity
 *
 */
public class UserServiceImpl implements UserService {
  private static final DaoProvider daoProvider = DaoProvider.getDaoprovider();
  private static final UserDao userDao = daoProvider.getUserDao();
  private static final ValidatorProvider validatorProvider =
      ValidatorProvider.getValidatorprovider();
  private static final UserValidator userValidator = validatorProvider.getUserValidator();

  /**
   * 
   * User authorization method
   *
   */
  @Override
  public User userAuth(String login, String password) throws ServiceException {
    if (!userValidator.checkUserAuthInfo(login, password)) {
      throw new ServiceException("Wrong authorization data");
    }

    UserDao userDao = DaoProvider.getDaoprovider().getUserDao();
    User user;
    try {
      user = userDao.userAuth(login, password);
    } catch (DaoException e) {
      throw new ServiceException(e.getMessage());
    }
    return user;
  }

  /**
   * 
   * User registration method
   *
   */
  @Override
  public boolean userRegistration(String login, String password, String fio, String email,
      String phoneNum, String address, int role) throws ServiceException {
    if (!userValidator.checkUserRegisterInfo(login, password, fio, email, address)) {
      throw new ServiceException("Wrong registration data");
    }

    try {
      if (!userDao.checkUserLogin(login)) {
        return false;
      }
      userDao.userRegistration(login, password, fio, email, phoneNum, address, role);
    } catch (DaoException e) {
      throw new ServiceException(e.getMessage());
    }
    return true;
  }

  /**
   * 
   * Method of adding a user to the blacklist
   *
   */
  @Override
  public void addtoBlackList(int userId) throws ServiceException {

    try {
      userDao.addtoBlackList(userId);
    } catch (DaoException e) {
      throw new ServiceException(e.getMessage());
    }
  }

  /**
   * 
   * Method of receiving all defaulters
   *
   */
  @Override
  public List<User> getAllPaymentEvaders() throws ServiceException {
    List<User> paymentEvaders = new ArrayList<User>();
    try {
      paymentEvaders = userDao.getAllPaymentEvaders();
    } catch (DaoException e) {
      throw new ServiceException(e.getMessage());
    }
    return paymentEvaders;
  }
}
